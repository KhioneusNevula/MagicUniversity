package character.thought.type;

import java.util.HashMap;
import java.util.Map;

import _utilities.ITrait;
import avatar.statuses.IStatusType;
import character.actions.IAction;
import character.feelings.IFeeling;
import character.needs.INeed;
import character.rules.IRule;
import character.thought.IThoughtArgument;

public class ThoughtArgumentType<T extends IThoughtArgument> {

	public static final ThoughtArgumentType<IAction> ACTION = new ThoughtArgumentType<>(IAction.class);
	public static final ThoughtArgumentType<INeed> NEED = new ThoughtArgumentType<>(INeed.class);
	public static final ThoughtArgumentType<ITrait> TRAIT = new ThoughtArgumentType<>(ITrait.class);
	public static final ThoughtArgumentType<IRule> RULE = new ThoughtArgumentType<>(IRule.class);
	public static final ThoughtArgumentType<IFeeling> FEELING = new ThoughtArgumentType<>(IFeeling.class);
	public static final ThoughtArgumentType<IStatusType> STATUS = new ThoughtArgumentType<>(IStatusType.class);
	public static final ThoughtArgumentType<IThoughtArgument> OTHER = new ThoughtArgumentType<>(IThoughtArgument.class);

	private static final Map<Class<?>, ThoughtArgumentType<?>> mapa = new HashMap<>();

	Class<T> clazz;

	private ThoughtArgumentType(Class<T> clazz) {
		this.clazz = clazz;
		mapa.put(clazz, this);
	}

	/**
	 * Return the class this thought argument type is associated with
	 * 
	 * @return
	 */
	public Class<T> getThoughtArgumentClass() {
		return clazz;
	}

	/**
	 * Casts
	 * 
	 * @param th
	 * @return
	 */
	public T cast(IThoughtArgument th) {
		return (T) th;
	}
}
