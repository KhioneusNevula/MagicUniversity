package character.dialogue;

import outer_world.ILanguage;

/**
 * Something spoken
 * 
 * @author borah
 *
 */
public interface IStatement {
	/**
	 * How easy this statement is to understand
	 * 
	 * @return
	 */
	public float comprehensibility();

	/**
	 * What language the statemnet is in
	 * 
	 * @return
	 */
	public ILanguage language();

}
