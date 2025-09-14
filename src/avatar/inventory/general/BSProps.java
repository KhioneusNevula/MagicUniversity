package avatar.inventory.general;

import java.util.Map;

import com.google.common.collect.Range;

import avatar.apparel.IApparelTrait;
import avatar.inventory.IInventorySlot;
import avatar.parts.IPart;
import avatar.traits.IPhysicalTrait;

public class BSProps {

	public float msize;
	public boolean phold;
	public Map<IPhysicalTrait, Range<Integer>> depTraits;
	public Map<IApparelTrait, Range<Integer>> appTraits;
	public IInventorySlot pslot;
	public IPart ppart;

	public static BSProps make(float msize) {
		return new BSProps(msize);
	}

	private BSProps(float msize) {
		this.msize = msize;
	}

	public BSProps allowPartialHolding() {
		this.phold = true;
		return this;
	}

	public BSProps parentPart(IPart parent) {
		this.ppart = parent;
		return this;
	}

	public BSProps parentSlot(IInventorySlot slot) {
		this.pslot = slot;
		return this;
	}

	/**
	 * Marks dependency on these trait being nonzero
	 * 
	 * @param trait
	 * @return
	 */
	public BSProps traits(IPhysicalTrait... traits) {
		for (IPhysicalTrait trait : traits) {
			this.depTraits.put(trait, Range.closed(0, 1));
		}
		return this;
	}

	/**
	 * add trait with single permitted value
	 * 
	 * @param trait
	 * @param val
	 * @return
	 */
	public BSProps trait(IPhysicalTrait trait, int val) {
		this.depTraits.put(trait, Range.singleton(val));
		return this;
	}

	/**
	 * add trait with range of permitted values
	 * 
	 * @param trait
	 * @param val
	 * @return
	 */
	public BSProps trait(IPhysicalTrait trait, int min, int max) {
		this.depTraits.put(trait, Range.closed(min, max));
		return this;
	}

	/**
	 * Marks dependency on these trait being nonzero
	 * 
	 * @param trait
	 * @return
	 */
	public BSProps traits(IApparelTrait... traits) {
		for (IApparelTrait trait : traits) {
			this.appTraits.put(trait, Range.closed(0, 1));
		}
		return this;
	}

	/**
	 * add trait with single permitted value
	 * 
	 * @param trait
	 * @param val
	 * @return
	 */
	public BSProps trait(IApparelTrait trait, int val) {
		this.appTraits.put(trait, Range.singleton(val));
		return this;
	}

	/**
	 * add trait with range of permitted values
	 * 
	 * @param trait
	 * @param val
	 * @return
	 */
	public BSProps trait(IApparelTrait trait, int min, int max) {
		this.appTraits.put(trait, Range.closed(min, max));
		return this;
	}

}
