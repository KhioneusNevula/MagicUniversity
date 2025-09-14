package character.thought.mind;

import java.util.Collection;

import character.thought.ThetaRole;
import character.thought.base.IThought;
import character.thought.type.IThoughtType;
import character.topic.ITopic;

/**
 * Somewhere that thoughts are contained
 * 
 * @author borah
 *
 */
public interface IMind {

	/**
	 * Return all thoughts
	 * 
	 * @return
	 */
	public Collection<IThought> thoughts();

	/**
	 * Returns thoughts from the given timestamp
	 * 
	 * @param timestamp
	 * @return
	 */
	public Collection<IThought> thoughtsFromTimestamp(long timestamp);

	/**
	 * Return all thoughts with the given topic as a theta role
	 * 
	 * @param topic
	 * @param role
	 * @return
	 */
	public Collection<IThought> thoughtsAbout(ITopic topic, ThetaRole role);

	/**
	 * Return all thoughts with the given argument
	 * 
	 * @param argument
	 * @return
	 */
	public Collection<IThought> thoughtsAbout(Object argument);

	/**
	 * Return all thoughts of the given type
	 * 
	 * @param type
	 * @return
	 */
	public Collection<IThought> thoughtsOfType(IThoughtType type);

}
