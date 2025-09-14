package avatar.touching;

import avatar.inventory.IInventorySlot;
import avatar.inventory.PartHoldingType;
import avatar.parts.IPart;
import avatar.parts.IPart.Side;

/**
 * A relation representing this holding or being held by something else. In this
 * relation, the holder may be both this being or another being
 * 
 * @author borah
 *
 */
public interface IHoldingRelation {
	/** If this side of the relation is the holder */
	public boolean isHolder();

	/** What inventory slot is holding the part */
	public IInventorySlot holder();

	/** What side the inventory slot is on, if it is on a sided part */
	public Side holderSide();

	/** What is being held */
	public IPart held();

	/** What side the thing held is on, if on a sided part */
	public Side heldSide();

	/** How the other part is being held */
	public PartHoldingType holdingType();

}
