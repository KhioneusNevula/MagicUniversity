package character.thought.type;

import java.util.HashMap;
import java.util.Map;

import character.thought.ThetaRole;

public class TTProps {
	Map<ThetaRole, Integer> troles = new HashMap<>();
	ThoughtArgumentType<?> tat;
	boolean isMeta;
	// if this thought expresses something that the speaker intends to do
	ThoughtMood mood = ThoughtMood.STATEMENT;

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
	 * Give thought an argument type
	 * 
	 * @param tat
	 * @return
	 */
	public TTProps argumentType(ThoughtArgumentType<?> tat) {
		this.tat = tat;
		return this;
	}

	/**
	 * Set a theta role to have unlimited assignments
	 * 
	 * @param tr
	 * @return
	 */
	public TTProps unlimitedThetaCount(ThetaRole tr) {
		troles.put(tr, Integer.MAX_VALUE);
		return this;
	}

	/**
	 * The count of theta roles assigned for this thought type
	 * 
	 * @param tr
	 * @param i
	 * @return
	 */
	public TTProps thetaCount(ThetaRole tr, int i) {
		troles.put(tr, i);
		return this;
	}

	/**
	 * Makes this thought into an intention, questiton, etc
	 * 
	 * @return
	 */
	public TTProps setMood(ThoughtMood mood) {
		this.mood = mood;
		return this;
	}

}
