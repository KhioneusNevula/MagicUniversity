package _category.humanoid;

import com.google.common.collect.Range;

import avatar.parts.IPartKind;
import avatar.traits.IPhysicalTrait;
import avatar.traits.ISpeciesTrait;

/**
 * An enum representing different supernatural traits humanoids can have
 * 
 * @author borah
 *
 */
public enum HumanoidSpeciesTrait implements ISpeciesTrait {

	/** A standard human */
	HUMAN,
	/** Physiologically, gives demonic wings, horns, and a tail */
	DAEMON,
	/** Physiologically gives fairy wings */
	FAIRY,
	/** Physiologically, gives wolf head, paws, and tail */
	WOLFISH,
	/** Physiologically, gives a mermaid tail */
	MERMAID,
	/** Physiologically, gives a serpent tail */
	SERPENTINE;

	@Override
	public Range<Integer> strengthRange() {
		return Range.closed(0, 1);
	}

	@Override
	public boolean appliesToPart(IPartKind part) {
		return part.slot() == HumanoidPart.ROOT;
	}

}
