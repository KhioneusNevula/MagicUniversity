package avatar.inventory;

import java.util.Collection;

import com.google.common.collect.Range;

import avatar.apparel.IApparelTrait;
import avatar.parts.IPart;
import avatar.traits.IPhysicalTrait;

/**
 * A slot where another object can be held
 */
public interface IInventorySlot {

	/**
	 * Return what inventory slot this is relative to, or null if rleative to a part
	 * 
	 * @return
	 */
	public IInventorySlot parentSlot();

	/**
	 * Return the part that this inventory slot is relative to; or null if relative
	 * to another inventory slot
	 * 
	 * @return
	 */
	public IPart parentPart();

	/**
	 * Maximum size of what can be held here, relative to the size of the parent
	 * slot (if it exists), or the parent part (if no parent slot exists). If parent
	 * part and parent slot are both null, relative to whole body.
	 * 
	 * @return
	 */
	public float maxSize();

	/**
	 * Calculates the size of this based on its relation to other parts and slots
	 * (as described in {@link #maxSize()}
	 * 
	 * @param avatarSize
	 * @return
	 */
	public default float absoluteSize(int avatarSize) {
		if (parentSlot() != null) {
			return maxSize() * parentSlot().absoluteSize(avatarSize);
		} else {
			if (parentPart() != null) {
				return maxSize() * parentPart().absoluteSize(avatarSize);
			} else {
				return avatarSize * maxSize();
			}
		}
	}

	/**
	 * Whether this inventory slot can partially hold things
	 * 
	 * @return
	 */
	public boolean canPartiallyHold();

	/**
	 * What physical traits this depends on from the item in the parent slot
	 * 
	 * @return
	 */
	public Collection<IPhysicalTrait> dependentTraits();

	/**
	 * What values of the trait this depends on; if the trait does not fit, this
	 * slot is disabled
	 * 
	 * @param trait
	 * @return
	 */
	public Range<Integer> dependentTraitRange(IPhysicalTrait trait);

	/**
	 * What apparel traits this depends on from the apparel in the parent HumanoidPart slot
	 * 
	 * @return
	 */
	public Collection<IApparelTrait> dependentApparelTraits();

	/**
	 * What values of the trait this depends on; if the trait does not fit, this
	 * slot is disabled
	 * 
	 * @param trait
	 * @return
	 */
	public Range<Integer> dependentApparelTraitRange(IApparelTrait trait);

}
