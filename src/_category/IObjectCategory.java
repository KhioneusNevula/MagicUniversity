package _category;

import java.util.Optional;

import _category.general.trait_profile.IPhysicalTraitGenerator;
import _category.general.trait_profile.ITraitGenerator;
import avatar.IAvatar;
import character.ICharacter;
import character.traits.IMentalTrait;

/**
 * A category of being or object
 * 
 * @author borah
 *
 */
public interface IObjectCategory {

	/**
	 * REturn the distribution of mental traits in this avatar
	 * 
	 * @return
	 */
	public Optional<ITraitGenerator<IMentalTrait, ICharacter>> getMentalTraitGenerator();

	/**
	 * Return the physical trait profile for this species
	 * 
	 * @return
	 */
	public IPhysicalTraitGenerator getPhysicalTraitGenerator();

	/**
	 * Create a (blank) avatar for this species
	 * 
	 * @return
	 */
	public IAvatar createAvatar();

}
