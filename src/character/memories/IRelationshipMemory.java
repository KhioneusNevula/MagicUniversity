package character.memories;

import java.util.Collection;

import character.feelings.IFeeling;

public interface IRelationshipMemory {

	/**
	 * the average amount of a certain feeling
	 * 
	 * @return
	 */
	public int getFeeling(IFeeling forF);

	/**
	 * the amount of memories of a certain feeling that contribute to this
	 * relationshipMemory
	 * 
	 * @return
	 */
	public int getFeelingMemoryCount(IFeeling forF);

	/**
	 * All feelings surrounding this topic
	 * 
	 * @return
	 */
	public Collection<IFeeling> getFeelings();

	/**
	 * Returns the summed salience
	 * 
	 * @return
	 */
	public int getSalience();
}
