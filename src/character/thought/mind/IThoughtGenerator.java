package character.thought.mind;

import java.util.Collection;

import character.ICharacter;
import character.thought.base.IThought;

/**
 * A system that tries to generate thoughts into a mind, running with some
 * randomness
 * 
 * @author borah
 *
 */
public interface IThoughtGenerator {

	/**
	 * The probability of this generator running each tick
	 * 
	 * @return
	 */
	public float frequency();

	/**
	 * Generates a set of thoughts for this character based on its current status
	 * 
	 * @param forCharacter
	 * @return
	 */
	public Collection<IThought> generateThoughts(ICharacter forCharacter);

}
