package avatar.parts;

import character.thought.type.ThoughtArgumentType;

/**
 * The "slot" a part belongs to; i.e. an ElfEar is in the "Ear" slot
 * 
 * @author borah
 *
 */
public interface IPart {

	/**
	 * What side of the body something is on
	 * 
	 * @author borah
	 *
	 */
	public static enum Side {
		LEFT, RIGHT, NONE
	}

	/**
	 * Default part slot representing the whole body
	 */
	public static IPart ROOT = new IPart() {

		@Override
		public IPart parentSlot() {
			return null;
		}

		@Override
		public boolean mirrored() {
			return false;
		}

		@Override
		public boolean backOnly() {
			return false;
		}

		@Override
		public float fractionalSize() {
			return 1;
		}
	};

	/**
	 * The slot that this slot is connected to, i.e. the Ear is connected to the
	 * Head slot
	 * 
	 * @return
	 */
	public IPart parentSlot();

	/**
	 * Whether this slot is symmetrical on the left and right sides of the body,
	 * e.g. eyes, ears, etc
	 * 
	 * @return
	 */
	public boolean mirrored();

	/**
	 * If this slot is only visible from the back
	 * 
	 * @return
	 */
	public boolean backOnly();

	/**
	 * What (general) fraction of the body's size this is
	 * 
	 * @return
	 */
	public float fractionalSize();

	/**
	 * How big this body part is, calculated by multiplying fractional sizes by
	 * parent parts and the avatar size
	 * 
	 * @return
	 */
	public default float absoluteSize(int avatarSize) {
		float frac = 1f;
		for (IPart slot = this; slot != null; slot = slot.parentSlot()) {
			frac *= slot.fractionalSize();
		}
		return frac * avatarSize;
	}

}
