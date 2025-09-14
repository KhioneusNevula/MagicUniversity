package character.memories.storage;

import java.util.Collection;
import java.util.stream.Stream;

import character.memories.IMemory;
import character.rules.IRule;
import character.thought.ThetaRole;
import character.thought.base.IThought;
import character.thought.type.IThoughtType;
import character.topic.ITopic;

/**
 * The storage of memory concepts for this character, as well as rules
 * 
 * @author borah
 *
 */
public interface IMemoriesAndRules {
	public Collection<IRule> rules();

	/**
	 * Find all rules applying to a certain thought situation, based on both its
	 * topics and the thought type
	 * 
	 * @param topic
	 * @return
	 */
	public Collection<IRule> rulesFitting(IThought thought);

	public Collection<IMemory> memories();

	public Collection<ITopic> topics();

	/**
	 * Return null if the topic has no such association; try to compute a
	 * relationship memory if it has not been initialized yet
	 * 
	 * @param topic
	 * @return
	 */
	public IRelationshipMemory relationshipMemory(ITopic topic);

	/**
	 * Returned in an iteration order with the highest salience first
	 * 
	 * @param topic
	 * @param role
	 * @return
	 */
	public Collection<IMemory> memoriesWithThetaRole(ITopic topic, ThetaRole role);

	/**
	 * Returns the memories this memory "caused"
	 * 
	 * @param memory
	 * @return
	 */
	Collection<IMemory> getCausedMemories(IMemory memory);

	/**
	 * Returns the memories that caused this memory
	 * 
	 * @param memory
	 * @return
	 */
	Collection<IMemory> getCausers(IMemory memory);

}
