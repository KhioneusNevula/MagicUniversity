package map.celestial;

/**
 * the state of a celestial object at a point in time
 * 
 * @author borah
 *
 */
public interface ICelestialState {
	/**
	 * What segment of its orbit this object is at, or null if irrelevant
	 * 
	 * @return
	 */
	public Integer segment();

	/**
	 * What phase this object is at, or null if irrelevant
	 * 
	 * @return
	 */
	public Integer phase();
}
