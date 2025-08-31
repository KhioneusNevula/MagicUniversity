package character.thought.type;

import character.thought.ThetaRole;

/**
 * What kind of thought this is
 * 
 * @author borah
 *
 */
public interface IThoughtType {

	/**
	 * The identifier of this ThoughtType
	 * 
	 * @return
	 */
	public String identifier();

	/**
	 * Return the number of the given theta role that is permitted; return 0 if none
	 * specified, or {@link Integer#MAX_VALUE} if any number is allowed
	 * 
	 * @param role
	 * @return
	 */
	public int thetaRoleCount(ThetaRole role);

	/**
	 * If this thought-type has an action, need, feeling, trait status, or rule as
	 * an argument, return the type of this argument; else return null
	 * 
	 * @return
	 */
	public ThoughtArgumentType<?> getArgumentType();

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
