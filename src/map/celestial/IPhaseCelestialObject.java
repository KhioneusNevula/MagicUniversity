package map.celestial;

/**
 * Stand in for celestial bodies that visibly go through phases, like the moon
 * 
 * @author borah
 *
 */
public interface IPhaseCelestialObject extends ICelestialObject {

	/**
	 * How many phases this object has
	 * 
	 * @return
	 */
	public int numPhases();

	/**
	 * The duration this body is into its phase cycle when the game world is created
	 * 
	 * @return
	 */
	public long initialPhaseTick();

	/**
	 * The length of a single phase in ticks
	 * 
	 * @return
	 */
	public long phaseLength();

	/**
	 * By default, equivalent to {@link #numPhases()} * {@link #phaseLength()}
	 * 
	 * @return
	 */
	public default long phaseCycleLength() {
		return numPhases() * phaseLength();
	}
}
