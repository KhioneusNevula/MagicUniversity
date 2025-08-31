package character;

import java.util.Collection;

import character.feelings.IFeeling;
import character.memories.IMemoriesAndRules;
import character.thought.IThought;
import character.traits.IMentalTrait;

/**
 * An individual being with their own tendencies
 * 
 * @author borah
 *
 */
public interface ICharacter {

	/**
	 * Return all thoughts this Character is thinking
	 * 
	 * @return
	 */
	public Collection<IThought> getThoughts();

	/**
	 * Return the "memory" storage where memories and rules are stored
	 * 
	 * @return
	 */
	public IMemoriesAndRules getMemoriesAndRules();

	/**
	 * Return all feelings currently active with values
	 * 
	 * @return
	 */
	public Collection<IFeeling> getActiveFeelings();

	/**
	 * Return the magnitude of a certain feeling
	 * 
	 * @param feeling
	 * @return
	 */
	public int getMagnitudeOfFeeling(IFeeling feeling);

	/**
	 * Return all mental traits which have set values
	 * 
	 * @return
	 */
	public Collection<IMentalTrait> getMentalTraits();

	/**
	 * Return the value of a certain mental trait
	 * 
	 * @param trait
	 * @return
	 */
	public int getTraitValue(IMentalTrait trait);

	/**
	 * Set value of the given mental trait
	 * 
	 * @param trait
	 */
	public void setTraitValue(IMentalTrait trait);
}
