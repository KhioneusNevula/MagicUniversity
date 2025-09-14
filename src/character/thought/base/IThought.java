package character.thought.base;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Range;

import character.rules.IRule;
import character.thought.ThetaRole;
import character.thought.type.IThoughtType;
import character.thought.type.ThoughtArgumentType;
import character.topic.ITemplateTopic;
import character.topic.ITopic;
import character.topic.IUniqueTopic;

/**
 * A thought in the mind
 * 
 * @author borah
 *
 */
public interface IThought extends Comparable<IThought> {

	/**
	 * What type of thought this is
	 * 
	 * @return
	 */
	public IThoughtType thoughtType();

	/**
	 * Who told this thought
	 * 
	 * @return
	 */
	public IUniqueTopic source();

	/**
	 * A list of all targets fitting
	 * 
	 * @param role
	 * @return
	 */
	public List<ITopic> topicsForThetaRole(ThetaRole role);

	/**
	 * If this type has an argument, return it.
	 * 
	 * @return
	 */
	public <T> T getArgument(ThoughtArgumentType<T> argument);

	/**
	 * If this is a metathought, return the contained tthought
	 * 
	 * @return
	 */
	public IThought subThought();

	/**
	 * When this thought was generated
	 * 
	 * @return
	 */
	public long getTimestamp();

	/**
	 * All topics used in this thought
	 * 
	 * @return
	 */
	public Collection<ITopic> allTopics();

	/**
	 * Return true if this thought is the "cause" portion of a {@link IRule},
	 * meaning it may contain {@link ITemplateTopic}s
	 * 
	 * @return
	 */
	public boolean isTemplateForRule();

	/**
	 * A map view of the theta roles and topics
	 * 
	 * @return
	 */
	public Multimap<ThetaRole, ITopic> topicsMap();

	/**
	 * 
	 * @return
	 */
	public Map<ThoughtArgumentType<?>, ?> argumentMap();

	/**
	 * Builder for the cause of a rule
	 * 
	 * @param type
	 * @return
	 */
	public static Builder ruleCauseBuilder(IThoughtType type) {
		return new Builder(type, true);
	}

	/**
	 * Builder for a thought
	 * 
	 * @param type
	 * @return
	 */
	public static Builder builder(IThoughtType type) {
		return new Builder(type, false);
	}

	public static class Builder {

		private boolean editable = true;
		private Thought thought;

		private Builder(IThoughtType type, boolean rule) {
			this.thought = new Thought();
			thought.type = type;
			thought.timestamp = Integer.MIN_VALUE;
			thought.isRule = rule;
		}

		public Builder subThought(IThought sub) {
			if (!editable)
				throw new UnsupportedOperationException();
			thought.subThought = sub;
			return this;
		}

		public Builder arguments(Object... arg) {
			if (!editable)
				throw new UnsupportedOperationException();
			ImmutableMap.Builder<ThoughtArgumentType<?>, Object> builder = ImmutableMap.builder();
			builder.putAll(thought.arguments);
			for (Object a : arg) {
				builder.put(ThoughtArgumentType.getFor(a), a);
			}
			thought.arguments = builder.build();
			return this;
		}

		public Builder source(IUniqueTopic topic) {
			if (!editable)
				throw new UnsupportedOperationException();
			thought.source = topic;
			return this;
		}

		public Builder timestamp(long stamp) {
			if (!editable)
				throw new UnsupportedOperationException();
			thought.timestamp = stamp;
			return this;
		}

		public Builder topics(ThetaRole role, Iterable<ITopic> topic) {
			if (!editable)
				throw new UnsupportedOperationException();
			thought.topics.putAll(role, topic);
			return this;
		}

		public Builder topics(ThetaRole role, ITopic... topics) {
			if (!editable)
				throw new UnsupportedOperationException();
			for (ITopic topic : topics) {
				thought.topics.put(role, topic);
			}
			return this;
		}

		public IThought build() {
			if (!thought.type.getArgumentTypes().isEmpty()
					&& (thought.arguments.keySet().equals(Set.copyOf(thought.type.getArgumentTypes())))) {
				throw new IllegalStateException("Missing/extra arguments: expected=" + thought.type.getArgumentTypes()
						+ ", args=" + thought.arguments);
			}
			if (thought.type.isMetaThought() && thought.subThought == null) {
				throw new IllegalStateException("No subthought for metathought");
			}
			for (ThetaRole role : ThetaRole.values()) {
				Range<Integer> range = thought.type.thetaRoleCount(role);
				List<ITopic> topics = thought.topicsForThetaRole(role);
				if (!range.contains(topics.size())) {
					throw new IllegalStateException("Count " + topics.size() + " does not fit in range " + range);
				}
				if (!thought.isRule) {
					for (ITopic topic : topics) {
						if (!topic.isUnique()) {
							throw new IllegalArgumentException(
									"Non-unique topic found despite thought not being a rule: " + topic);
						}
					}
				}
			}
			if (thought.timestamp < 0) {
				throw new IllegalArgumentException("Problematic timestamp: "
						+ (thought.timestamp == Integer.MIN_VALUE ? "not set" : (thought.timestamp + "(negative)")));
			}
			editable = false;
			return thought;
		}
	}

}
