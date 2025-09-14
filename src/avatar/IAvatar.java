package avatar;

import java.util.Collection;
import java.util.Optional;

import _category.IObjectCategory;
import _utilities.Pair;
import avatar.apparel.IApparel;
import avatar.inventory.AvatarHoldingType;
import avatar.inventory.IInventorySlot;
import avatar.inventory.PartHoldingType;
import avatar.parts.IPart;
import avatar.parts.IPart.Side;
import avatar.parts.IPartKind;
import avatar.statuses.IStatusInstance;
import avatar.statuses.IStatusType;
import avatar.touching.IHoldingRelation;
import avatar.touching.ITouchingRelation;
import avatar.traits.IPhysicalTrait;
import character.ICharacter;
import magic.ISpell;

/**
 * A physical object in the world.
 * 
 * @author borah
 *
 */
public interface IAvatar extends ITraitedObject<IPhysicalTrait> {

	/**
	 * Get the categorical type of this object
	 * 
	 * @return
	 */
	public IObjectCategory getCategory();

	/**
	 * If this has a Character, return it in the optional; otherwise return an empty
	 * optional
	 * 
	 * @return
	 */
	public Optional<ICharacter> obtainCharacter();

	/**
	 * Return all part slots on this avatar
	 * 
	 * @return
	 */
	public Collection<IPart> getPartSlots();

	/**
	 * Return the part slot that acts as the "universal parent"
	 * 
	 * @return
	 */
	public IPart universalParentPart();

	/**
	 * Return what part is in a given slot. If the slot is empty, or mismatches with
	 * the side of the part, return an empty Optonal
	 * 
	 * @param slot
	 * @return
	 */
	public default Optional<IPartKind> getPart(IPart slot) {
		return getPart(slot, Side.NONE);
	}

	/**
	 * Same as {@link #getPart(IPart)}, but recognizing the side of the body the
	 * part is on (if it is sided)
	 * 
	 * @param slot
	 * @param side
	 * @return
	 */
	public Optional<IPartKind> getPart(IPart slot, Side side);

	/**
	 * REturn the apparel in the given part slot, or an empty optional if the part
	 * does not exist/has no apparel
	 * 
	 * @param slot
	 * @return
	 */
	public default Optional<IApparel> getApparel(IPart slot) {
		return getApparel(slot, Side.NONE);
	}

	/**
	 * Same as {@link #getApparel(IPart)}, but recognizing the side of the body the
	 * part is on (if it is sided)
	 * 
	 * @param slot
	 * @return
	 */
	public Optional<IApparel> getApparel(IPart slot, Side side);

	/**
	 * Return the initialmost species traits of this avatar
	 * 
	 * @return
	 */
	public Collection<IPhysicalTrait> getSpeciesTraits();

	/**
	 * Equivalent to {@link #getTraits(IPart, Side)} where the argument is
	 * {@link IPart#ROOT}, {@link Side#NONE}
	 * 
	 * @return
	 */
	public default Collection<IPhysicalTrait> getTraits() {
		return getTraits(IPart.ROOT, Side.NONE);
	}

	/**
	 * Equivalent to {@link #getTraits(IPart, Side)} where {@link Side} is
	 * {@link Side#None}
	 * 
	 * @return
	 */
	public default Collection<IPhysicalTrait> getTraits(IPart slot) {
		return getTraits(slot, Side.NONE);
	}

	/**
	 * 
	 * Returns all traits of this Avatar on the given part on the given side
	 * 
	 * @return
	 */
	public Collection<IPhysicalTrait> getTraits(IPart part, Side side);

	/**
	 * Equivalent to {@link #getTraitValue(IPart, IPhysicalTrait)} where argument 1
	 * is {@link IPart#ROOT}
	 * 
	 * @param trait
	 * @return
	 */
	public default int getTraitValue(IPhysicalTrait trait) {
		return getTraitValue(IPart.ROOT, trait);
	}

	/**
	 * Equivalent to {@link #getTraitValue(IPart, Side, IPhysicalTrait)} where
	 * argument 1 is {@link IPart#ROOT} and argument 2 is {@link Side#NONE}
	 * 
	 * @param trait
	 * @return
	 */
	public default int getTraitValue(IPart part, IPhysicalTrait trait) {
		return getTraitValue(part, Side.NONE, trait);
	}

	/**
	 * Returns the value of the given trait on the given part. Return 0 if the trait
	 * is not present
	 * 
	 * @param trait
	 * @return
	 */
	public int getTraitValue(IPart part, Side side, IPhysicalTrait trait);

	/**
	 * Equivalent to {@link #getStatuses(IPart)} where the argument is
	 * {@link IPart#ROOT}
	 * 
	 * @return
	 */
	public default Collection<IStatusInstance> getStatuses() {
		return getStatuses(IPart.ROOT);
	}

	/**
	 * 
	 * Equivalent to {@link #getStatus(IPart, Side, IStatusType)} with {@link Side}
	 * as {@link Side#NONE}
	 * 
	 * @return
	 */
	public Collection<IStatusInstance> getStatuses(IPart part);

	/**
	 * Equivalent to {@link #getStatus(IPart, IPhysicalTrait)} where argument 1 is
	 * {@link IPart#ROOT}
	 * 
	 * @param trait
	 * @return
	 */
	public default Optional<IStatusInstance> getStatus(IStatusType trait) {
		return getStatus(IPart.ROOT, trait);
	}

	/**
	 * Returns the status instance of the given status on the given part, or an
	 * empty optional if it does not exist
	 * 
	 * @param trait
	 * @return
	 */
	public default Optional<IStatusInstance> getStatus(IPart part, IStatusType trait) {
		return getStatus(part, Side.NONE, trait);
	}

	/**
	 * Returns the status instance of the given status on the given part
	 * 
	 * @param trait
	 * @return
	 */
	public Optional<IStatusInstance> getStatus(IPart part, Side side, IStatusType trait);

	/**
	 * The x position of this Avatar
	 * 
	 * @return
	 */
	public int getX();

	/**
	 * The y position of this Avatar
	 * 
	 * @return
	 */
	public int getY();

	/**
	 * The Z layer of this Avatar
	 * 
	 * @return
	 */
	public int getZLayer();

	/**
	 * Set the position of this Avatar on the map map.
	 * 
	 * @param x
	 * @param y
	 */
	public void setPosition(int x, int y, int z);

	/**
	 * Change the position of this Avatar by the given amount
	 * 
	 * @param x
	 * @param y
	 */
	public void move(int x, int y);

	/**
	 * Move up/down z layers by the given amount
	 * 
	 * @param z
	 */
	public void ascend(int z);

	/**
	 * What spells are currently tied to this Avatar
	 * 
	 * @return
	 */
	public Collection<ISpell> getSpells();

	/**
	 * Return how big this object is (assume this measurement to be approximately
	 * inches)
	 * 
	 * @return
	 */
	public int size();

	/**
	 * What avatars are currently being touched by a part of the body
	 * 
	 * @return
	 */
	public Collection<IAvatar> touchingAvatars();

	/** How this avatar is touching the other (if at all) */
	public Optional<ITouchingRelation> touchingRelationWith(IAvatar avatar);

	/**
	 * Which avatars are being held by this avatar, in the fashion described
	 * 
	 * @return
	 */
	public Collection<IAvatar> heldAvatars(AvatarHoldingType holdingType);

	/** What kind of holding relation is present wih the given avatar */
	public Optional<IHoldingRelation> holdingRelationWith(IAvatar avatar);

	/**
	 * Which avatars are holding this avatar as
	 * {@link AvatarHoldingType#NO_MOVEMENT_CONTROL}
	 */
	public Collection<IAvatar> partialHolders();

	/**
	 * Which avatar is holding this avatar as
	 * {@link AvatarHoldingType#MOVEMENT_CONTROL}
	 * 
	 * @return
	 */
	public IAvatar controllingHolder();

}
