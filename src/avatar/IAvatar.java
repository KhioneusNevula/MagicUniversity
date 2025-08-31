package avatar;

import java.util.Collection;
import java.util.Optional;

import avatar.statuses.IStatus;
import avatar.traits.IPhysicalTrait;
import character.ICharacter;
import magic.ISpell;

/**
 * A physical object in the world.
 * 
 * @author borah
 *
 */
public interface IAvatar {

	/**
	 * If this has a Character, return it in the optional; otherwise return an empty
	 * optional
	 * 
	 * @return
	 */
	public Optional<ICharacter> obtainCharacter();

	/**
	 * 
	 * Returns all traits of this Avatar
	 * 
	 * @return
	 */
	public Collection<IPhysicalTrait> getTraits();

	/**
	 * Returns the value of the given trait. Return 0 if the trait is not present
	 * 
	 * @param trait
	 * @return
	 */
	public int getTraitValue(IPhysicalTrait trait);

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
	 * What statuses are applied to this
	 * 
	 * @return
	 */
	public Collection<IStatus> getStatuses();

}
