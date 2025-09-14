package _category.general.trait_profile;

import java.util.Collection;
import java.util.Map;

import com.google.common.collect.Range;

import avatar.IAvatar;
import avatar.ITraitedObject;
import character.traits.ITrait;

/**
 * A class to represent the distribution of traits in a certain "species"
 * 
 * @author borah
 *
 */
public interface ITraitGenerator<R extends ITrait, T extends ITraitedObject<R>> {

	/**
	 * Return all traits which are selected for initially, which can be thought of
	 * as the "species traits", or otherwise just the root traits.
	 * 
	 * @return
	 */
	public Collection<R> getRootTraits();

	/**
	 * Picks a random number of root traits, given a collection of traits that are
	 * expected to show up in this Avatar. E.g. if the trait "no eyes" is picked,
	 * then a root trait that branches to it has to be picked
	 * 
	 * @param count
	 * @return
	 */
	public Map<R, Integer> selectRootTraits(Collection<R> expectedTraits);

	/**
	 * Return all traits that have this trait as their child and what range of
	 * values the child is permitted in
	 * 
	 * @param trait
	 * @return
	 */
	public Map<R, Range<Integer>> getParentTraits(R trait);

	/**
	 * Returns traits that can only be applied if the given parent trait is applied
	 * with the given value
	 * 
	 * @param parentTrait
	 * @param range
	 * @return
	 */
	public Collection<R> getBranchingTraits(R parentTrait, int value);

	/**
	 * Return an integer value that should be applied to this trait, or null if the
	 * trait cannot be added
	 * 
	 * @param trait
	 * @param avatar
	 * @return
	 */
	public Integer generateTraitValue(R trait, IAvatar avatar);

}
