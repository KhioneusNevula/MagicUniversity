package avatar.inventory.special;

import java.util.Collection;
import java.util.Collections;

import com.google.common.collect.Range;

import _category.humanoid.HumanoidApparelTrait;
import avatar.apparel.IApparelTrait;
import avatar.inventory.IIndexedInventorySlot;
import avatar.parts.IPart;
import avatar.traits.IPhysicalTrait;

/**
 * A slot representing an apparel pocket
 * 
 * @author borah
 *
 */
public abstract class AbstractPocketSlot implements IIndexedInventorySlot {

	public static final int MAX_POCKETS = 10;
	private int index;

	public AbstractPocketSlot(int index) {
		this.index = index;
	}

	@Override
	public int index() {
		return index;
	}

	@Override
	public float maxSize() {
		return 1f / 16f;
	}

	@Override
	public boolean canPartiallyHold() {

		return false;
	}

	@Override
	public Collection<IPhysicalTrait> dependentTraits() {
		return Collections.emptyList();
	}

	@Override
	public Range<Integer> dependentTraitRange(IPhysicalTrait trait) {
		return Range.all();
	}

	@Override
	public Collection<IApparelTrait> dependentApparelTraits() {
		return Collections.singleton(HumanoidApparelTrait.HAS_POCKETS);
	}

	@Override
	public Range<Integer> dependentApparelTraitRange(IApparelTrait trait) {
		return Range.atLeast(1);
	}

}
