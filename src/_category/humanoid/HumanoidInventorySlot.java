package _category.humanoid;

import java.util.Collection;
import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Range;

import avatar.apparel.IApparelTrait;
import avatar.inventory.IInventorySlot;
import avatar.inventory.general.BSProps;
import avatar.parts.IPart;
import avatar.traits.IPhysicalTrait;

/**
 * Typical inventory slots
 * 
 * @author borah
 *
 */
public enum HumanoidInventorySlot implements IInventorySlot {
	/**
	 * The hand to hold things with
	 */
	HAND(BSProps.make(2f).allowPartialHolding().parentPart(HumanoidPart.HAND)),
	/**
	 * The slot to hug people in
	 */
	HUG(BSProps.make(2f).allowPartialHolding().parentPart(HumanoidPart.TORSO));

	private IInventorySlot pslot;
	private IPart ppart;
	private float msize;
	private boolean phold;
	private Map<IPhysicalTrait, Range<Integer>> depTraits;
	private Map<IApparelTrait, Range<Integer>> appTraits;

	private HumanoidInventorySlot(BSProps props) {
		this.msize = props.msize;
		this.ppart = props.ppart;
		this.phold = props.phold;
		this.pslot = props.pslot;
		this.depTraits = ImmutableMap.copyOf(depTraits);
		this.appTraits = ImmutableMap.copyOf(appTraits);
	}

	@Override
	public IInventorySlot parentSlot() {
		return pslot;
	}

	@Override
	public IPart parentPart() {
		return ppart;
	}

	@Override
	public float maxSize() {
		return msize;
	}

	@Override
	public boolean canPartiallyHold() {
		return phold;
	}

	@Override
	public Collection<IPhysicalTrait> dependentTraits() {
		return depTraits.keySet();
	}

	@Override
	public Range<Integer> dependentTraitRange(IPhysicalTrait trait) {
		return depTraits.get(trait);
	}

	@Override
	public Collection<IApparelTrait> dependentApparelTraits() {
		return appTraits.keySet();
	}

	@Override
	public Range<Integer> dependentApparelTraitRange(IApparelTrait trait) {
		return appTraits.get(trait);
	}

}
