package character.traits;

import _utilities.ITrait;

/**
 * A trait of the mind
 * 
 * @author borah
 *
 */
public interface IMentalTrait extends ITrait {

	/**
	 * Return the id of the culture this trait is associated with (if it is
	 * cultural/language-related) or null otherwise
	 * 
	 * @return
	 */
	public String getCultureID();
}
