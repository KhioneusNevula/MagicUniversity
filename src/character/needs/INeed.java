package character.needs;

import _main.GameWorld;
import avatar.IAvatar;
import character.thought.IThoughtArgument;

/**
 * A physiological stat (among other things) that is influenced by the state of
 * being
 * 
 * @author borah
 *
 */
public interface INeed extends IThoughtArgument {

	/**
	 * Calculate the value of the need based on the state of the avatar and game
	 * surroundings
	 * 
	 * @param forAvatar
	 * @param game
	 * @return
	 */
	public double calculateNeedValue(IAvatar forAvatar, GameWorld game);
}
