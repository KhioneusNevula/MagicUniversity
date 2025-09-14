package avatar.statuses;

import com.google.common.collect.Range;

public enum StatusType implements IStatusType {
	WOUNDED(5), SICK(5),
	/** For something that is colored specially */
	DYED(1, 16);

	private Range<Integer> range = Range.closed(0, 1);

	private StatusType() {
	}

	private StatusType(int min, int max) {
		this.range = Range.closed(min, max);
	}

	private StatusType(int max) {
		this.range = Range.closed(1, max);
	}

	@Override
	public Range<Integer> strengthRange() {
		return range;
	}
}
