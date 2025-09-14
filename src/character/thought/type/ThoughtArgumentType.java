package character.thought.type;

import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.Range;

import avatar.apparel.IApparel;
import avatar.inventory.IInventorySlot;
import avatar.parts.IPartKind;
import avatar.parts.IPart;
import avatar.statuses.IStatusType;
import character.actions.IActionType;
import character.dialogue.ISimpleStatementType;
import character.feelings.IFeeling;
import character.needs.INeed;
import character.rules.IRule;
import character.traits.ITrait;
import map.celestial.ICelestialState;
import map.season.ISeason;
import map.weather.IWeatherState;

public class ThoughtArgumentType<T> {

	public static final ThoughtArgumentType<IActionType> ACTION = new ThoughtArgumentType<>(IActionType.class);
	public static final ThoughtArgumentType<INeed> NEED = new ThoughtArgumentType<>(INeed.class);
	public static final ThoughtArgumentType<ITrait> TRAIT = new ThoughtArgumentType<>(ITrait.class);
	public static final ThoughtArgumentType<IRule> RULE = new ThoughtArgumentType<>(IRule.class);
	public static final ThoughtArgumentType<IFeeling> FEELING = new ThoughtArgumentType<>(IFeeling.class);
	public static final ThoughtArgumentType<IStatusType> STATUS = new ThoughtArgumentType<>(IStatusType.class);
	public static final ThoughtArgumentType<IWeatherState> WEATHER = new ThoughtArgumentType<>(IWeatherState.class);
	public static final ThoughtArgumentType<ICelestialState> CELESTIAL_STATE = new ThoughtArgumentType<>(
			ICelestialState.class);
	public static final ThoughtArgumentType<ISimpleStatementType> SIMPLE_STATEMENT = new ThoughtArgumentType<>(
			ISimpleStatementType.class);
	public static final ThoughtArgumentType<ISeason> SEASON = new ThoughtArgumentType<>(ISeason.class);
	public static final ThoughtArgumentType<IPart> PART_SLOT = new ThoughtArgumentType<>(IPart.class);
	public static final ThoughtArgumentType<IPartKind> PART = new ThoughtArgumentType<>(IPartKind.class);
	public static final ThoughtArgumentType<IApparel> APPAREL = new ThoughtArgumentType<>(IApparel.class);
	public static final ThoughtArgumentType<IInventorySlot> INVENTORY_SLOT = new ThoughtArgumentType<>(
			IInventorySlot.class);
	public static final ThoughtArgumentType<Range<Integer>> VALUE = new ThoughtArgumentType<>(Range.class);
	public static final ThoughtArgumentType<Object> OTHER = new ThoughtArgumentType<>(Object.class);

	private static final Set<ThoughtArgumentType<?>> mapa = new HashSet<>();

	Class<? super T> clazz;

	/**
	 * Get the argument type for the given object, or null if not applicable
	 * 
	 * @param <T>
	 * @param obj
	 * @return
	 */
	public static <T> ThoughtArgumentType<? super T> getFor(T obj) {
		return (ThoughtArgumentType<? super T>) getFor(obj.getClass());
	}

	/**
	 * Get the argument type for the given class, or null if it is not applicable
	 * 
	 * @param clazz
	 * @return
	 */
	public static <T> ThoughtArgumentType<? super T> getFor(Class<T> clazz) {
		for (ThoughtArgumentType<?> t : mapa) {
			if (t.getThoughtArgumentClass().isAssignableFrom(clazz)) {
				return (ThoughtArgumentType<? super T>) t;
			}
		}
		return null;
	}

	private ThoughtArgumentType(Class<? super T> clazz) {
		this.clazz = clazz;
		mapa.add(this);
	}

	/**
	 * Return the class this thought argument type is associated with
	 * 
	 * @return
	 */
	public Class<? super T> getThoughtArgumentClass() {
		return clazz;
	}

	/**
	 * Casts
	 * 
	 * @param th
	 * @return
	 */
	public T cast(Object th) {
		return (T) th;
	}
}
