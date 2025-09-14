package character.dialogue;

import java.util.Collection;

import character.feelings.IFeelingToken;
import character.topic.ITopic;

/**
 * A simple statement meant to cause a certain emotin
 * 
 * @author borah
 *
 */
public interface ISimpleStatement extends IStatement {

	/**
	 * What type of simple statement this is
	 * 
	 * @return
	 */
	public ISimpleStatementType statementType();

	/**
	 * What feelings this statement is said with
	 * 
	 * @return
	 */
	public Collection<IFeelingToken> intendedFeelings();

}
