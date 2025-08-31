package character.targeting;

import java.util.Optional;

/**
 * A template to indicate the proprties of a character or object in order to be
 * targeted by thoughts or other things
 * 
 * @author borah
 *
 */
public interface ITopic {

	/**
	 * Whether this topic matches some other (unique) topic
	 * 
	 * @param other
	 * @return
	 */
	public boolean matches(IUniqueTopic other);

	/**
	 * Whether this target is a unique thing with a UUID. IF so, the only relevant
	 * methods are {@link #uuid()} and {@link #topicType()}; otherwise
	 * {@link #uuid()} will be null
	 * 
	 * @return
	 */
	public boolean isUnique();

	/**
	 * What the Type of this topic is
	 * 
	 * @return
	 */
	public TopicType topicType();

	/**
	 * If this is a {@link ITemplateTopic}, cast to it; else return empty optional
	 * 
	 * @return
	 */
	public default Optional<ITemplateTopic> asTemplate() {
		if (this instanceof ITemplateTopic tt)
			return Optional.of(tt);
		return Optional.empty();
	}

	/**
	 * If this is a {@link IUniqueTopic}, cast to it; else return empty optional
	 * 
	 * @return
	 */
	public default Optional<IUniqueTopic> asUnique() {
		if (this instanceof IUniqueTopic tt)
			return Optional.of(tt);
		return Optional.empty();
	}

}
