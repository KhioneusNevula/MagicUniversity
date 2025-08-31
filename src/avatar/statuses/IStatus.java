package avatar.statuses;

/**
 * A status applied to an avatar, e.g. Dead, Drunk, Injured (part), and so on
 * 
 * @author borah
 *
 */
public interface IStatus {
	/**
	 * What the class of status is
	 */
	public IStatusType statusType();

	/**
	 * How much ttime is left for this status
	 */
	public int duration();

	/**
	 * How strong the status is
	 * 
	 * @return
	 */
	public int strength();
}
