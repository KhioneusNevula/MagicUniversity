package magic;

import character.targeting.ITopic;
import character.targeting.IUniqueTopic;

/**
 * A single magical effect
 * 
 * @author borah
 *
 */
public interface ISpell {

	/**
	 * Return -1 if duration is infinite
	 * 
	 * @return
	 */
	public int duration();

	/**
	 * What this spell targets
	 * 
	 * @return
	 */
	public ITopic target();

	/**
	 * Which Character cast this spell
	 * 
	 * @return
	 */
	public IUniqueTopic caster();

	/**
	 * What this spell does
	 * 
	 * @return
	 */
	public ISpellEffect effect();

}
