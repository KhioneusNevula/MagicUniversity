package character.thought.type;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Range;

import character.thought.ThetaRole;
import character.thought.base.ThoughtMood;

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
	FEELS(TTProps.make().thetas(ThetaRole.PATIENT).argumentTypes(ThoughtArgumentType.FEELING)),
	/**
	 * Some individual or group did an action using an instrument to certain targets
	 */
	DID_ACTION(TTProps.make().event().thetaPluses(ThetaRole.AGENT).thetaStars(ThetaRole.PATIENT, ThetaRole.INSTRUMENT)
			.argumentTypes(ThoughtArgumentType.ACTION)),
	/**
	 * Obligates thinker to do this action
	 */
	MUST_DO_ACTION(TTProps.make().thetaStars(ThetaRole.PATIENT, ThetaRole.INSTRUMENT)
			.argumentTypes(ThoughtArgumentType.ACTION).setMood(ThoughtMood.IMPERATIVE)),
	/**
	 * Obligates thinker to do this action with a group of other Agents
	 */
	MUST_DO_ACTION_WITH_GROUP(
			TTProps.make().thetaPluses(ThetaRole.AGENT).thetaStars(ThetaRole.PATIENT, ThetaRole.INSTRUMENT)
					.argumentTypes(ThoughtArgumentType.ACTION).setMood(ThoughtMood.IMPERATIVE)),

	/**
	 * About saying a simple statement to someone/group
	 */
	SAID_SIMPLE_STATEMENT(TTProps.make().event().thetaPluses(ThetaRole.AGENT, ThetaRole.PATIENT)
			.argumentTypes(ThoughtArgumentType.SIMPLE_STATEMENT)),
	/**
	 * About saying a simple statement to someone/group
	 */
	MUST_SAY_SIMPLE_STATEMENT(TTProps.make().thetaPluses(ThetaRole.PATIENT)
			.argumentTypes(ThoughtArgumentType.SIMPLE_STATEMENT).setMood(ThoughtMood.IMPERATIVE)),
	/**
	 * Observation something has a part status (with a certain strength)
	 */
	HAS_STATUS(TTProps.make().thetas(ThetaRole.PATIENT).argumentTypes(ThoughtArgumentType.STATUS,
			ThoughtArgumentType.PART_SLOT, ThoughtArgumentType.VALUE)),
	/**
	 * Observation something has a certain apparel
	 */
	HAS_APPAREL_ON_PART(TTProps.make().thetas(ThetaRole.PATIENT).argumentTypes(ThoughtArgumentType.APPAREL,
			ThoughtArgumentType.PART_SLOT)),
	/**
	 * Observation something has no apparel on a part
	 */
	PART_IS_NAKED(TTProps.make().thetas(ThetaRole.PATIENT).argumentTypes(ThoughtArgumentType.PART_SLOT)),
	/**
	 * 
	 */
	HAS_TRAIT();

	private Map<ThetaRole, Range<Integer>> troleCount = Collections.emptyMap();
	private Set<ThoughtArgumentType<?>> tat;
	private boolean isMeta;
	private ThoughtMood mood;
	private boolean isEvent;

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
		this.isEvent = other.isEvent;
	}

	private ThoughtType() {

	}

	private ThoughtType(TTProps props) {
		troleCount = new HashMap<>();
		for (ThetaRole tr : ThetaRole.values()) {
			troleCount.put(tr, props.troles.getOrDefault(tr, Range.closed(0, 0)));
		}
		troleCount = ImmutableMap.copyOf(troleCount);
		this.tat = props.tat;
		this.isMeta = props.isMeta;
		this.mood = props.mood;
		this.isEvent = props.isEvent;
	}

	@Override
	public String identifier() {
		return "thought_" + this.name().toLowerCase();
	}

	@Override
	public Range<Integer> thetaRoleCount(ThetaRole role) {
		return troleCount.get(role);
	}

	@Override
	public Set<ThoughtArgumentType<?>> getArgumentTypes() {
		return Collections.unmodifiableSet(tat);
	}

	@Override
	public boolean isMetaThought() {
		return isMeta;
	}

	@Override
	public ThoughtMood getMood() {
		return mood;
	}

	@Override
	public boolean isEvent() {
		return true;
	}

}
