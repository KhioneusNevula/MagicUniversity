package _category.general.trait_profile;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Range;

import avatar.IAvatar;
import avatar.parts.IPart;
import avatar.traits.IPhysicalTrait;

public class PhysicalTraitGenerator implements IPhysicalTraitGenerator {

	private Set<IPhysicalTrait> rootTraits;

	public PhysicalTraitGenerator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<IPhysicalTrait> getRootTraits() {
		return rootTraits;
	}

	@Override
	public Map<IPhysicalTrait, Integer> selectRootTraits(Collection<IPhysicalTrait> expectedTraits) {
		for (IPhysicalTrait trait : expectedTraits) {
			this.getParentTraits(trait);
		}
		return null;
	}

	@Override
	public Map<IPhysicalTrait, Range<Integer>> getParentTraits(IPhysicalTrait trait) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<IPhysicalTrait> getBranchingTraits(IPhysicalTrait parentTrait, int value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer generateTraitValue(IPhysicalTrait trait, IAvatar avatar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<IPhysicalTrait> getBranchingTraits(IPart part, IPhysicalTrait parentTrait, int value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<IPhysicalTrait, Range<Integer>> getParentTraits(IPhysicalTrait trait, IPart part) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer generateTraitValue(IPhysicalTrait trait, IPart part, IAvatar avatar) {
		// TODO Auto-generated method stub
		return null;
	}

}
