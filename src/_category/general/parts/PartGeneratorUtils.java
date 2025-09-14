package _category.general.parts;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

import avatar.IAvatar;
import avatar.traits.IPhysicalTrait;

/**
 * Has utilities for making part profiles
 * 
 * @author borah
 *
 */
public class PartGeneratorUtils {

	protected PartGeneratorUtils() {
	}

	public static final Function<IAvatar, Float> ALWAYS = (ava) -> 1f;

	/**
	 * For traits always allowed
	 * 
	 * @return
	 */
	public static Function<IAvatar, Float> always() {
		return ALWAYS;
	}

	/**
	 * Returns a fixed probabiliy
	 */
	public static Function<IAvatar, Float> fixed(float prob) {
		return (ava) -> prob;
	}

	/**
	 * Returns 1 - the value of the given function
	 * 
	 * @param func
	 * @return
	 */
	public static Function<IAvatar, Float> inv(Function<IAvatar, Float> func) {
		return (ava) -> 1f - func.apply(ava);
	}

	/**
	 * If this function returns 0, return 1. Otherwise, return 0.
	 * 
	 * @param func
	 * @return
	 */
	public static Function<IAvatar, Float> not(Function<IAvatar, Float> func) {
		return (ava) -> func.apply(ava) == 0 ? 1f : 0f;
	}

	/**
	 * Returns the value of the given function multiplied by the given factor
	 * (maxxed to 0 and 1)
	 * 
	 * @param func
	 * @return
	 */
	public static Function<IAvatar, Float> prob(Function<IAvatar, Float> func, float factor) {
		return (ava) -> func.apply(ava) * factor;
	}

	/**
	 * Returns the value of the given functions multiplied together
	 * 
	 * @param func
	 * @return
	 */
	@SafeVarargs
	public static Function<IAvatar, Float> mult(Function<IAvatar, Float>... func) {
		return (ava) -> (float) Arrays.stream(func).mapToDouble((s) -> s.apply(ava)).reduce(1, (a, b) -> a * b);
	}

	/**
	 * Returns the average probability of the results of the functions in this
	 * sequence
	 * 
	 * @param funcs
	 * @return
	 */
	@SafeVarargs
	public static Function<IAvatar, Float> avg(Function<IAvatar, Float>... funcs) {
		return (ava) -> (float) Arrays.stream(funcs).mapToDouble((s) -> s.apply(ava)).average().orElse(0);
	}

	/**
	 * Returns the minimum probability of the results of the functions in this
	 * sequence
	 * 
	 * @param funcs
	 * @return
	 */
	@SafeVarargs
	public static Function<IAvatar, Float> min(Function<IAvatar, Float>... funcs) {
		return (ava) -> (float) Arrays.stream(funcs).mapToDouble((s) -> s.apply(ava)).min().orElse(0);
	}

	/**
	 * Returns the maximum probability of the results of the functions in this
	 * sequence
	 * 
	 * @param funcs
	 * @return
	 */
	@SafeVarargs
	public static Function<IAvatar, Float> max(Function<IAvatar, Float>... funcs) {
		return (ava) -> (float) Arrays.stream(funcs).mapToDouble((s) -> s.apply(ava)).max().orElse(0);
	}

	/**
	 * Checks the given functions in the given sequence, returning either the last
	 * value, or a 0 if a 0 was encountered before that
	 * 
	 * @param funcs
	 * @return
	 */
	@SafeVarargs
	public static Function<IAvatar, Float> and(Function<IAvatar, Float>... funcs) {
		return (ava) -> {
			float lastVal = 0f;
			for (Function<IAvatar, Float> funca : funcs) {
				float res = funca.apply(ava);
				if (res <= 0) {
					return res;
				}
				lastVal = res;
			}
			return lastVal;
		};
	}

	/**
	 * Checks the given functions in the given sequence, returning the first value >
	 * 0
	 * 
	 * @param funcs
	 * @return
	 */
	@SafeVarargs
	public static Function<IAvatar, Float> or(Function<IAvatar, Float>... funcs) {
		return (ava) -> {
			for (Function<IAvatar, Float> funca : funcs) {
				float res = funca.apply(ava);
				if (res > 0) {
					return res;
				}
			}
			return 0f;
		};
	}

	/**
	 * Creates a part probability function that forbids a part to appear at 1f
	 * chance if ANY of the traits given are present
	 * 
	 * @return
	 */
	public static Function<IAvatar, Float> disallowedIfAnyPresent(IPhysicalTrait... args) {
		return (ava) -> Arrays.stream(args).noneMatch((trait) -> ava.getTraitValue(trait) > 0) ? 1f : 0f;
	}

	/**
	 * Creates a part probability function that forbids a part to appear at 1f
	 * chance if ANY of the traits given are greater than or equal to the given
	 * value
	 * 
	 * @return
	 */
	public static Function<IAvatar, Float> disallowedIfAnyGEThan(int val, IPhysicalTrait... args) {
		return (ava) -> Arrays.stream(args).noneMatch((trait) -> ava.getTraitValue(trait) >= val) ? 1f : 0f;
	}

	/**
	 * Creates a part probability function that permits a part to appear at 1f
	 * chance if ANY OF the traits given are present
	 * 
	 * @return
	 */
	public static Function<IAvatar, Float> allowedIfAnyPresent(IPhysicalTrait... args) {
		return (ava) -> Arrays.stream(args).anyMatch((trait) -> ava.getTraitValue(trait) > 0) ? 1f : 0f;
	}

	/**
	 * Creates a part probability function that permits a part to appear at 1f
	 * chance if ANY OF the traits given are >= the given value
	 * 
	 * @return
	 */
	public static Function<IAvatar, Float> allowedIfAnyGEThan(int val, IPhysicalTrait... args) {
		return (ava) -> Arrays.stream(args).anyMatch((trait) -> ava.getTraitValue(trait) >= val) ? 1f : 0f;
	}

	/**
	 * Creates a part probability function that permits a part to appear at 1f
	 * chance if ANY OF the traits given are present, with the probability given
	 * based on the trait that has the highest probability mapped to it in the given
	 * map
	 * 
	 * @return
	 */
	public static Function<IAvatar, Float> allowedIfAnyPresent(Map<IPhysicalTrait, Float> traits) {
		return (ava) -> (float) traits.keySet().stream().filter((trait) -> ava.getTraitValue(trait) > 0)
				.mapToDouble(traits::get).max().orElse(0);
	}

	/**
	 * Creates a part probability function that permits a part to appear at 1f
	 * chance if ANY OF the traits given are greater than the values in the given
	 * map, with the probability given based on the trait that has the highest
	 * probability mapped to it in the second given map map
	 * 
	 * @return
	 */
	public static Function<IAvatar, Float> allowedIfAnyGEThan(Map<IPhysicalTrait, Integer> vals,
			Map<IPhysicalTrait, Float> traits) {
		return (ava) -> (float) traits.keySet().stream()
				.filter((trait) -> ava.getTraitValue(trait) >= vals.getOrDefault(trait, 1)).mapToDouble(traits::get)
				.max().orElse(0);
	}

	/**
	 * Creates a part probability function that permits a part to appear at 1f
	 * chance if ANY OF the traits given are less than the values in the given map,
	 * with the probability given based on the trait that has the highest
	 * probability mapped to it in the second given map map
	 * 
	 * @return
	 */
	public static Function<IAvatar, Float> allowedIfAnyLEThan(Map<IPhysicalTrait, Integer> vals,
			Map<IPhysicalTrait, Float> traits) {
		return (ava) -> (float) traits.keySet().stream()
				.filter((trait) -> ava.getTraitValue(trait) <= vals.getOrDefault(trait, 1)).mapToDouble(traits::get)
				.max().orElse(0);
	}

	/**
	 * Creates a part probability function that permits a part to appear at 1f
	 * chance if ANY OF the traits given are equal to the values in the given map,
	 * with the probability given based on the trait that has the highest
	 * probability mapped to it in the second given map map
	 * 
	 * @return
	 */
	public static Function<IAvatar, Float> allowedIfAnyEqualTo(Map<IPhysicalTrait, Integer> vals,
			Map<IPhysicalTrait, Float> traits) {
		return (ava) -> (float) traits.keySet().stream()
				.filter((trait) -> ava.getTraitValue(trait) == vals.getOrDefault(trait, 1)).mapToDouble(traits::get)
				.max().orElse(0);
	}

	/**
	 * Creates a part probability function that permits a part to appear at 1f
	 * chance if ALL the traits given are present
	 * 
	 * @return
	 */
	public static Function<IAvatar, Float> allowedIfAllPresent(IPhysicalTrait... args) {
		return (ava) -> Arrays.stream(args).allMatch((trait) -> ava.getTraitValue(trait) > 0) ? 1f : 0f;
	}

	/**
	 * Creates a part probability function that permits a part to appear at 1f
	 * chance if ALL the traits given are greater than the given value
	 * 
	 * @return
	 */
	public static Function<IAvatar, Float> allowedIfAllGEThan(int val, IPhysicalTrait... args) {
		return (ava) -> Arrays.stream(args).allMatch((trait) -> ava.getTraitValue(trait) >= val) ? 1f : 0f;
	}

}
