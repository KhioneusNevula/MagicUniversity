package character.dialogue;

import character.thought.IThought;

/**
 * A statement conveying info
 * 
 * @author borah
 *
 */
public interface IInfoStatement extends IStatement {

	/**
	 * What thought this statement is conveying
	 */
	public IThought conveyedThought();

}
