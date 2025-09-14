package avatar.inventory;

/**
 * How an entire avatar is held, i.e. whether the holder can move it around or
 * not
 * 
 * @author borah
 *
 */
public enum AvatarHoldingType {
	/**
	 * For cases where an avatar is held in such a way it fully moves with the
	 * holder
	 */
	MOVEMENT_CONTROL,
	/**
	 * For cases where an avatar is held in a way that it does not fully move with
	 * the holder
	 */
	NO_MOVEMENT_CONTROL

}
