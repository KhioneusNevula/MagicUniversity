package avatar.touching;

import avatar.parts.IPart;
import avatar.parts.IPart.Side;

/**
 * A relation representing something touching something else. In this relation,
 * things labeled "this" indicate the bearer of the relation object, while
 * things labeled "other" indicate the other entity
 * 
 * @author borah
 *
 */
public interface ITouchingRelation {

	/**
	 * What part of the other thing being touched is being touched
	 * 
	 * @return
	 */
	public IPart otherTouched();

	/**
	 * The side of what is being touched
	 * 
	 * @return
	 */
	public Side otherTouchedSide();

	/**
	 * What part of this thing is touching the other thing
	 * 
	 * @return
	 */
	public IPart thisToucher();

	/**
	 * Side of the toucher
	 * 
	 * @return
	 */
	public Side toucherSide();
}
