package character.feelings;

/**
 * A feeling instance
 * 
 * @author borah
 *
 */
public interface IFeelingToken {

	/**
	 * What the feeling is
	 * 
	 * @return
	 */
	public IFeeling feeling();

	/**
	 * How much this feeling is meant to increase
	 * 
	 * @return
	 */
	public int strength();

}
