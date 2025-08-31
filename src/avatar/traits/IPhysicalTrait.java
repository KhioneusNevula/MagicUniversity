package avatar.traits;

import java.util.Collection;

import _utilities.ITrait;

/**
 * Physical trait of an avatar
 * 
 * @author borah
 *
 */
public interface IPhysicalTrait extends ITrait {

	/**
	 * Which (binary) traits this trait depends on. E.g. the trait "RedThirdEye"
	 * depends on the "ThirdEye" trait. If these dependent traits are not present,
	 * this trait cannot be applied
	 * 
	 * @return
	 */
	public Collection<IPhysicalTrait> dependsOnTraits();

	// public ____ overlay()

}
