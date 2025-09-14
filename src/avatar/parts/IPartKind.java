package avatar.parts;

import java.util.Collection;

import com.google.common.collect.Range;

import avatar.traits.IPhysicalTrait;
import map.IMaterial;

/**
 * A token for a specific kind of part on an avatar
 * 
 * @author borah
 *
 */
public interface IPartKind {
	/**
	 * The slot this part occupies
	 * 
	 * @return
	 */
	public IPart slot();

	/**
	 * If this part represents "NONE." If this is the case, a null will be inserted
	 * instead of the part itself when geneerating a body
	 * 
	 * @return
	 */
	public boolean isNone();

	/**
	 * If this part is dependent on a certain trait, return the range of allowable
	 * values. (Otherwise, return an infinite range)
	 * 
	 * @param trait
	 * @return
	 */
	// public Range<Integer> traitValues(IPhysicalTrait trait);

	/**
	 * REturn all traits this depends on (i.e. cannot exist without)
	 * 
	 * @return
	 */
	// public Collection<IPhysicalTrait> dependentTraits();

	/**
	 * Whether this part is flesh, bone, hair, etc
	 * 
	 * @return
	 */
	public IMaterial material();
}
