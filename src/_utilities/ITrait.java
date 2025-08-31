package _utilities;

import character.thought.IThoughtArgument;

/**
 * A general trait of a character or object
 * 
 * @author borah
 *
 */
public interface ITrait extends IThoughtArgument {

	/**
	 * If false, this trait is associated with a value from 0 - 100; otherwise, it
	 * is associated with just 0 and 1
	 * 
	 * @return
	 */
	public boolean isBinary();

}
