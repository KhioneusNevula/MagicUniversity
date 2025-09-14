package character.memories;

import java.util.Collection;
import java.util.Map;

import character.feelings.IFeeling;
import character.thought.base.IThought;

/**
 * A single instance of memory
 * 
 * @author borah
 *
 */
public interface IMemory extends Comparable<IMemory> {
	/**
	 * How strong this memory is
	 * 
	 * @return
	 */
	public int salience();

	/**
	 * How truthful this is (-1 to 1)
	 * 
	 * @return
	 */
	public float truth();

	/**
	 * The thought this memory stores
	 * 
	 * @return
	 */
	public IThought thought();

	/**
	 * What feelings the thought in this memory generated
	 * 
	 * @return
	 */
	public Collection<IFeeling> feelings();

	/**
	 * Map of feelings
	 * 
	 * @return
	 */
	public Map<IFeeling, Integer> feelingsMap();

	/**
	 * the strength of the feeling from the thought
	 * 
	 * @param feeling
	 * @return
	 */
	public int getFeelingStrength(IFeeling feeling);
}
