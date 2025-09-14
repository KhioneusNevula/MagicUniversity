package avatar.statuses;

import com.google.common.collect.Range;

/**
 * A description of the nature of a status.
 * 
 * @author borah
 *
 */
public interface IStatusType {

	/**
	 * Range of strengths a status can have
	 * 
	 * @return
	 */
	public Range<Integer> strengthRange();
}
