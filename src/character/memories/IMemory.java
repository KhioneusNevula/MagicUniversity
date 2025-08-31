package character.memories;

import character.thought.IThought;

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
	 * How many times this memory is accessed
	 * 
	 * @return
	 */
	public int accesses();

	/**
	 * Access the memory
	 * 
	 * @return
	 */
	public int access();

	/**
	 * Set accesses to the given number; -1 if the memory is unforgettable?
	 * 
	 * @param num
	 */
	public void setAccesses(int num);

	/**
	 * The thought this memory stores
	 * 
	 * @return
	 */
	public IThought thought();
}
