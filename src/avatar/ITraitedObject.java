package avatar;

import java.util.Collection;

import character.traits.ITrait;

/**
 * Something with traits
 * 
 * @author borah
 *
 */
public interface ITraitedObject<T extends ITrait> {

	/**
	 * Return the traits present
	 * 
	 * @return
	 */
	public Collection<T> getTraits();

	/**
	 * Return the value of a given trait
	 * 
	 * @param trait
	 * @return
	 */
	public int getTraitValue(T trait);
}
