package avatar.traits;

import avatar.parts.IPartKind;
import character.traits.ITrait;

/**
 * Physical trait of an avatar
 * 
 * @author borah
 *
 */
public interface IPhysicalTrait extends ITrait {

	/**
	 * If this trait applies to the passed part, return true
	 * 
	 * @return
	 */
	public boolean appliesToPart(IPartKind part);

	// public ____ overlay()

}
