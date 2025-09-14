package character.rules;

import java.util.Optional;

import character.thought.base.IThought;

/**
 * What happens as the result of a rule. Can be either a "Thought" about a
 * consequence or a general consequence such as FORBIDDEN or ENCOURAGED.
 * 
 * @author borah
 *
 */
public interface IConsequence {

	/**
	 * Whether this is a "{@link IThought}"
	 * 
	 * @return
	 */
	public boolean isCircumstance();

	/**
	 * The Thought representing this circumstance itself. If the thought is
	 * Imperative, the consequence creates the thought when the rule is invoked
	 * 
	 * @return
	 */
	public Optional<IThought> obtainThoughtEffect();
}
