package character.thought.type;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import character.thought.ThetaRole;

/**
 * The types of thoughts
 * 
 * @author borah
 *
 */
public enum ThoughtType implements IThoughtType {
	/**
	 * A thought about someone feeling something
	 */
	FEELS(TTProps.make().thetaCount(ThetaRole.THEME, 1).argumentType(ThoughtArgumentType.FEELING)),
	/**
	 * A thought about someone no longer feeling somthing
	 */
	NO_LONGER_FEELS(FEELS),
	/**
	 * Did an action (that had no objects)
	 */
	DID_ACTION(TTProps.make().thetaCount(ThetaRole.AGENT, 1).argumentType(ThoughtArgumentType.ACTION)),
	/**
	 * Did an action
	 */
	DID_ACTION_TO(TTProps.make().thetaCount(ThetaRole.AGENT, 1).thetaCount(ThetaRole.PATIENT, Integer.MAX_VALUE)
			.argumentType(ThoughtArgumentType.ACTION)),
	/**
	 * Did an action using an instrument
	 */
	DID_ACTION_USING(TTProps.make().thetaCount(ThetaRole.AGENT, 1).thetaCount(ThetaRole.INSTRUMENT, 1)
			.argumentType(ThoughtArgumentType.ACTION)),
	/**
	 * Did an action using an instrument to certain targets
	 */
	DID_ACTION_TO_USING(TTProps.make().thetaCount(ThetaRole.AGENT, 1).thetaCount(ThetaRole.PATIENT, Integer.MAX_VALUE)
			.thetaCount(ThetaRole.INSTRUMENT, 1).argumentType(ThoughtArgumentType.ACTION)),
	/**
	 * A group did an action
	 */
	GROUP_DID_ACTION(
			TTProps.make().thetaCount(ThetaRole.THEME, Integer.MAX_VALUE).argumentType(ThoughtArgumentType.ACTION)),
	/**
	 * Obligates thinker to do this action
	 */
	MUST_DO_ACTION(TTProps.make().argumentType(ThoughtArgumentType.ACTION).setMood(ThoughtMood.IMPERATIVE)),
	/**
	 * Obligates thinker to do this action
	 */
	MUST_DO_ACTION_TO(TTProps.make().thetaCount(ThetaRole.PATIENT, Integer.MAX_VALUE)
			.argumentType(ThoughtArgumentType.ACTION).setMood(ThoughtMood.IMPERATIVE)),
	/**
	 * Obligates thinker to do this action
	 */
	MUST_DO_ACTION_WITH(TTProps.make().thetaCount(ThetaRole.THEME, Integer.MAX_VALUE)
			.argumentType(ThoughtArgumentType.ACTION).setMood(ThoughtMood.IMPERATIVE)),
	/**
	 * Obligates thinker to do this action
	 */
	MUST_DO_ACTION_USING(TTProps.make().thetaCount(ThetaRole.INSTRUMENT, 1).argumentType(ThoughtArgumentType.ACTION)
			.setMood(ThoughtMood.IMPERATIVE)),
	/**
	 * Obligates thinker to do this action
	 */
	MUST_DO_ACTION_TO_USING(
			TTProps.make().thetaCount(ThetaRole.PATIENT, Integer.MAX_VALUE).thetaCount(ThetaRole.INSTRUMENT, 1)
					.argumentType(ThoughtArgumentType.ACTION).setMood(ThoughtMood.IMPERATIVE));

	private Map<ThetaRole, Integer> troleCount = Collections.emptyMap();
	private ThoughtArgumentType<?> tat;
	private boolean isMeta;
	private ThoughtMood mood;

	/**
	 * Copies all the properties of another
	 * 
	 * @param other
	 */
	private ThoughtType(ThoughtType other) {
		this.troleCount = other.troleCount;
		this.tat = other.tat;
		this.isMeta = other.isMeta;
		this.mood = other.mood;
	}

	private ThoughtType() {

	}

	private ThoughtType(TTProps props) {
		troleCount = new HashMap<>();
		for (ThetaRole tr : ThetaRole.values()) {
			troleCount.put(tr, props.troles.getOrDefault(tr, 0));
		}
		troleCount = ImmutableMap.copyOf(troleCount);
		this.tat = props.tat;
		this.isMeta = props.isMeta;
		this.mood = props.mood;
	}

	@Override
	public String identifier() {
		return "thought_" + this.name().toLowerCase();
	}

	@Override
	public int thetaRoleCount(ThetaRole role) {
		return troleCount.get(role);
	}

	@Override
	public ThoughtArgumentType<?> getArgumentType() {
		return tat;
	}

	@Override
	public boolean isMetaThought() {
		return isMeta;
	}

	@Override
	public ThoughtMood getMood() {
		return mood;
	}

}
