package map.celestial;

/**
 * Something visible in the sky that moves in cycles
 * 
 * @author borah
 *
 */
public interface ICelestialObject {

	/**
	 * How long it takes for this object to complete one orbit segment
	 * 
	 * @return
	 */
	public long orbitSegmentLength();

	/**
	 * Used for things like "clock time", in the sense that the sun's orbital period
	 * should be treated as having 24 segments. The orbital period is divided by
	 * this to get a number of segments; if the numbers cannot be divided evenly,
	 * errors are thrown
	 * 
	 * @return
	 */
	public int orbitalSegments();

	/**
	 * Length of one orbit cycle of this body; equivalent to
	 * {@link #orbitSegmentLength()} * {@link #orbitalSegments()}
	 * 
	 * @return
	 */
	public default long orbitCycleLength() {
		return orbitSegmentLength() * orbitalSegments();
	}

	/**
	 * The number of segments this body is visible in the sky, e.g. for the sun we
	 * will say 12 hours
	 * 
	 * @return
	 */
	public int numVisibleSegments();

	/**
	 * What position in its orbit cycle this thing is at when the game "starts" in
	 * the very beginning of the world creation
	 * 
	 * @return
	 */
	public long initialOrbitalPosition();

	/**
	 * Whether this object (like the moon) has phases
	 * 
	 * @return
	 */
	public boolean hasPhases();
}
