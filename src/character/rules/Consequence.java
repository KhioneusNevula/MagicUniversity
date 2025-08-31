package character.rules;

import java.util.Optional;

import character.thought.IThought;

/**
 * Generic consequence ("Good" or "Bad")
 * 
 * @author borah
 *
 */
public enum Consequence implements IConsequence {
	ENCOURAGED, FORBIDDEN;

	@Override
	public boolean isCircumstance() {
		return false;
	}

	@Override
	public Optional<IThought> obtainThoughtEffect() {
		return Optional.empty();
	}

}
