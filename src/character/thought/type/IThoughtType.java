package character.thought.type;

import java.util.Collection;

import com.google.common.collect.Range;

import character.thought.ThetaRole;
import character.thought.base.ThoughtMood;

/**
 * What kind of thought this is
 * 
 * @author borah
 *
 */
public interface IThoughtType {

	/**
	 * If this is true, this thought is linked to its timestamp. If this is false,
	 * this thought will "remain" relevant until a new thought with the same topics
	 * replaces it
	 * 
	 * @return
	 */
	public boolean isEvent();

	/**
	 * Whether this thought is about a state of the world; inversion of
	 * {@link #isEvent()}
	 * 
	 * @return
	 */
	public default boolean isState() {
		return !isEvent();
	}

	/**
	 * The identifier of this ThoughtType
	 * 
	 * @return
	 */
	public String identifier();

	/**
	 * Return the range of the number of theta roles that is permitted;
	 * 
	 * @param role
	 * @return
	 */
	public Range<Integer> thetaRoleCount(ThetaRole role);

	/**
	 * If the theta role count has no upper bound, it must be unordered as well
	 * 
	 * @param role
	 * @return
	 */
	public default boolean isUnordered(ThetaRole role) {
		return !thetaRoleCount(role).hasUpperBound();
	}

	/**
	 * Return the types of non-Topic arguments this thought takes
	 * 
	 * @return
	 */
	public Collection<ThoughtArgumentType<?>> getArgumentTypes();

	/**
	 * Whether this thought-type takes another thought as an argument
	 * 
	 * @return
	 */
	public boolean isMetaThought();

	/**
	 * Whether this thought is an intention or question
	 * 
	 * @return
	 */
	public ThoughtMood getMood();

}
