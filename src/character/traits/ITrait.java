package character.traits;

import com.google.common.collect.Range;

/**
 * A general trait of a character or object. Note that in nearly every use case,
 * a value of 0 is treated identically to the lack of the trait
 * 
 * @author borah
 *
 */
public interface ITrait {

	/**
	 * The range of allowable strengths for this trait, e.g. 1-5, 0-10, etc. Most
	 * traits just have 0-1
	 * 
	 * @return
	 */
	public Range<Integer> strengthRange();

}
