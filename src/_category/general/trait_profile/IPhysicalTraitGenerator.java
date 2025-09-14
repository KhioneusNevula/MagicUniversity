package _category.general.trait_profile;

import java.util.Collection;
import java.util.Map;

import com.google.common.collect.Range;

import avatar.IAvatar;
import avatar.parts.IPart;
import avatar.traits.IPhysicalTrait;

/**
 * A trait profile for specifically physical traits
 * 
 * @author borah
 *
 */
public interface IPhysicalTraitGenerator extends ITraitGenerator<IPhysicalTrait, IAvatar> {

	/**
	 * Returns traits that can only be applied to the given part if the given parent
	 * trait is applied to this whole entity
	 * 
	 * @param parentTrait
	 * @param range
	 * @return
	 */
	public Collection<IPhysicalTrait> getBranchingTraits(IPart part, IPhysicalTrait parentTrait, int value);

	/**
	 * Return all traits that have this trait for this part as their child and what
	 * range of values the child is permitted in
	 * 
	 * @param trait
	 * @return
	 */
	public Map<IPhysicalTrait, Range<Integer>> getParentTraits(IPhysicalTrait trait, IPart part);

	/**
	 * Return an integer value that should be applied to this trait for this part,
	 * or null if the trait cannot be added
	 * 
	 * @param trait
	 * @param avatar
	 * @return
	 */
	public Integer generateTraitValue(IPhysicalTrait trait, IPart part, IAvatar avatar);
}
