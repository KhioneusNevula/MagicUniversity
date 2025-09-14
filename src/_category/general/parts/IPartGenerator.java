package _category.general.parts;

import java.util.Collection;
import java.util.Random;

import avatar.IAvatar;
import avatar.parts.IPart;
import avatar.parts.IPartKind;

/**
 * A profile to select parts for an avatar of a certain "species." Assumption is
 * that Whole-Body traits have already been selected before this was run; part
 * traits will be selected after
 * 
 * @author borah
 *
 */
public interface IPartGenerator {

	/**
	 * Return all possible parts for a given slot
	 * 
	 * @param slot
	 * @return
	 */
	public Collection<IPartKind> possibleParts(IPart slot);

	/**
	 * Probability of generating the given part (given avatar traits)
	 * 
	 * @param part
	 * @return
	 */
	public float probability(IPartKind part, IAvatar traits);

	/**
	 * Select a part for the given slot, given traits. Return null if no part could
	 * be selected, leaving the slot empty
	 * 
	 * @param slot
	 * @param traits
	 * @return
	 */
	public IPartKind selectPart(IPart slot, IAvatar traits, Random rand);
}
