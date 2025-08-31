package character.targeting;

import java.util.Collection;

import _utilities.ITrait;
import avatar.statuses.IStatusType;

/**
 * A topic meant to select for things in the world
 * 
 * @author borah
 *
 */
public interface ITemplateTopic extends ITopic {

	/**
	 * Return the "lower bound" (inclusive) selected for a trait, or null if no such
	 * bound exists. If lower bound is 1 (for binary traits) only select for things
	 * with this trait present.
	 * 
	 * @param forTrait
	 * @return
	 */
	public Integer traitLowerBound(ITrait forTrait);

	/**
	 * Return the upper bound (inclusive) selected for a trait, or null if no such
	 * bound exists. If upper bound = 0, only select for things without this trait
	 * (or with the trait value at 0)
	 * 
	 * @param forTrait
	 * @return
	 */
	public Integer traitUpperBound(ITrait forTrait);

	/**
	 * Whether this topic checks the given trait
	 * 
	 * @param trait
	 * @return
	 */
	public boolean hasTrait(ITrait trait);

	/**
	 * Return all traits this ITopic selects for.
	 * 
	 * @return
	 */
	public Collection<ITrait> checkedTraits();

	/**
	 * Return the "lower bound" (inclusive) selected for a status strength, or null
	 * if no such bound exists. If lower bound is 1 (for binary traits) only select
	 * for things with this status present.
	 * 
	 * @param forTrait
	 * @return
	 */
	public Integer statusLowerBound(IStatusType forTrait);

	/**
	 * Return the upper bound (inclusive) selected for a status, or null if no such
	 * bound exists. If upper bound = 0, only select for things without this status
	 * (or with the status strength at 0)
	 * 
	 * @param forTrait
	 * @return
	 */
	public Integer statusUpperBound(IStatusType forTrait);

	/**
	 * Whether this topic checks the given status
	 * 
	 * @param trait
	 * @return
	 */
	public boolean hasStatus(IStatusType trait);

	/**
	 * Return all statuses this ITopic selects for.
	 * 
	 * @return
	 */
	public Collection<IStatusType> checkedStatuses();

}
