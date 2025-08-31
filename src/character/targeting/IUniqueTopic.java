package character.targeting;

import java.util.UUID;

/**
 * A topic for a unique thing in the universe
 * 
 * @author borah
 *
 */
public interface IUniqueTopic extends ITopic {

	/**
	 * The ID of the unique thing to target
	 * 
	 * @return
	 */
	public UUID uuid();

}
