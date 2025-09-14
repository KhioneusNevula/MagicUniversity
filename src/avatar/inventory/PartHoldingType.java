package avatar.inventory;

/**
 * Ways of holding another object
 * 
 * @author borah
 *
 */
public enum PartHoldingType {
	/**
	 * Something is being fully held in an inventory slot (e.g. fully holding a
	 * hand)
	 */
	FULL,
	/**
	 * Something is only partially held because it is too big for an inventory slot
	 * (e.g. holding onto an arm)
	 */
	PARTIAL
}
