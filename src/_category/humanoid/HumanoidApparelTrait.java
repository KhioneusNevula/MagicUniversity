package _category.humanoid;

import com.google.common.collect.Range;

import avatar.apparel.IApparelTrait;
import avatar.inventory.special.AbstractPocketSlot;

public enum HumanoidApparelTrait implements IApparelTrait {
	/** If the apparel has pockets */
	HAS_POCKETS(0, AbstractPocketSlot.MAX_POCKETS);

	private Range<Integer> rang = Range.closed(0, 1);

	private HumanoidApparelTrait() {
	}

	private HumanoidApparelTrait(int min, int max) {
		this.rang = Range.closed(min, max);
	}

	@Override
	public Range<Integer> strengthRange() {
		return rang;
	}
}
