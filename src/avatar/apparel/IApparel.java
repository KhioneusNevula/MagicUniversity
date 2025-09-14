package avatar.apparel;

import java.util.Collection;

import avatar.parts.IPart;

/**
 * A clothing item that covers a part in a part slot (and all child parts of
 * that)
 * 
 * @author borah
 *
 */
public interface IApparel {

	public static enum Coverage {
		/**
		 * For things which fully cover the body, e.g. regular shirts
		 */
		FULL,
		/**
		 * For things which generally cover the body, but show some of the form, e.g. a
		 * tight shirt
		 */
		TIGHT,
		/**
		 * For things which cover the body but are see-through
		 */
		TRANSLUCENT,
		/** No coverage */
		NONE
	}

	/**
	 * What slot this apparel occupies
	 * 
	 * @return
	 */
	public IPart getSlot();

	/**
	 * Return this apparel's coverage of a certain slot, i.e.
	 * 
	 * @return
	 */
	public Coverage getCoverage(IPart slot);

	/**
	 * What traits this apparel has
	 * 
	 * @return
	 */
	public Collection<IApparelTrait> apparelTraits();

}
