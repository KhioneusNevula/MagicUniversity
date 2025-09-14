package character.thought.type;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Range;

import character.thought.ThetaRole;
import character.thought.base.ThoughtMood;

public class TTProps {
	Map<ThetaRole, Range<Integer>> troles = new HashMap<>();
	Set<ThoughtArgumentType<?>> tat = new HashSet<>();
	boolean isMeta;
	// if this thought expresses something that the speaker intends to do
	ThoughtMood mood = ThoughtMood.STATEMENT;
	boolean isEvent;

	private TTProps() {
	}

	public static TTProps make() {
		TTProps ttp = new TTProps();
		return ttp;
	}

	/**
	 * Turn thought into meta thought
	 * 
	 * @return
	 */
	public TTProps makeMeta() {
		this.isMeta = true;
		return this;
	}

	/**
	 * Turn this thought from a state into an event
	 * 
	 * @return
	 */
	public TTProps event() {
		this.isEvent = true;
		if (this.mood != ThoughtMood.STATEMENT) {
			throw new UnsupportedOperationException("Cannot assign event status to a non-statement thought");
		}
		return this;
	}

	/**
	 * Give thought argument types
	 * 
	 * @param tat
	 * @return
	 */
	public TTProps argumentTypes(ThoughtArgumentType<?>... tat) {
		for (ThoughtArgumentType<?> t : tat) {
			this.tat.add(t);
		}
		return this;
	}

	/**
	 * Adds theta roles with singular counts
	 * 
	 * @param tr
	 * @return
	 */
	public TTProps thetas(ThetaRole... trs) {
		for (ThetaRole tr : trs)
			thetaCount(tr, 1);
		return this;
	}

	/**
	 * Theta count for one specific value
	 */
	public TTProps thetaCount(ThetaRole tr, int only) {
		return thetaCount(tr, only, only);
	}

	/**
	 * The count of theta roles assigned for this thought type
	 * 
	 * @param tr
	 * @param i
	 * @return
	 */
	public TTProps thetaCount(ThetaRole tr, int lower, int upper) {
		Range<Integer> rang = Range.closed(lower, upper);
		if (lower < 0 || upper < 0) {
			throw new IllegalArgumentException("No negatives dummy");
		}
		troles.put(tr, rang);
		return this;
	}

	/**
	 * Makes this thought into an intention, questiton, etc
	 * 
	 * @return
	 */
	public TTProps setMood(ThoughtMood mood) {
		this.mood = mood;
		if (this.isEvent) {
			throw new UnsupportedOperationException("Cannot assign non-statement status to an eventive thought");

		}
		return this;
	}

	/**
	 * Adds theta roles which may allow 0 or more topics
	 * 
	 * @param roles
	 * @return
	 */
	public TTProps thetaStars(ThetaRole... roles) {
		for (ThetaRole role : roles) {
			thetaCountUnbounded(role, 0);
		}
		return this;
	}

	/**
	 * Adds theta roles which may allow 1 or more topics
	 * 
	 * @param roles
	 * @return
	 */
	public TTProps thetaPluses(ThetaRole... roles) {
		for (ThetaRole role : roles) {
			thetaCountUnbounded(role, 1);
		}
		return this;
	}

	/**
	 * A theta count that has no upper bound
	 * 
	 * @param patient
	 * @param lower
	 * @return
	 */
	public TTProps thetaCountUnbounded(ThetaRole patient, int lower) {
		Range<Integer> rang = Range.atLeast(lower);
		if (lower < 0) {
			throw new IllegalArgumentException("No negatives dummy");
		}
		troles.put(patient, rang);
		return this;
	}

}
