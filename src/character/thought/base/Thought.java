package character.thought.base;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Multimaps;

import character.thought.ThetaRole;
import character.thought.type.IThoughtType;
import character.thought.type.ThoughtArgumentType;
import character.topic.ITopic;
import character.topic.IUniqueTopic;

/**
 * Implementation of a thought
 * 
 * @author borah
 *
 */
public class Thought implements IThought {

	IThoughtType type;
	IUniqueTopic source;
	ListMultimap<ThetaRole, ITopic> topics = MultimapBuilder.enumKeys(ThetaRole.class).arrayListValues().build();
	Map<ThoughtArgumentType<?>, Object> arguments = ImmutableMap.of();
	IThought subThought;
	long timestamp;
	boolean isRule;

	Thought() {
	}

	@Override
	public IThoughtType thoughtType() {
		return type;
	}

	@Override
	public IUniqueTopic source() {
		return source;
	}

	@Override
	public List<ITopic> topicsForThetaRole(ThetaRole role) {
		return topics.get(role);
	}

	@Override
	public <T> T getArgument(ThoughtArgumentType<T> art) {
		return (T) arguments.get(art);
	}

	@Override
	public Map<ThoughtArgumentType<?>, ?> argumentMap() {
		return arguments;
	}

	@Override
	public IThought subThought() {
		return subThought;
	}

	@Override
	public long getTimestamp() {
		return timestamp;
	}

	@Override
	public boolean isTemplateForRule() {
		return isRule;
	}

	@Override
	public Collection<ITopic> allTopics() {
		return topics.values();
	}

	@Override
	public Multimap<ThetaRole, ITopic> topicsMap() {
		return Multimaps.unmodifiableMultimap(topics);
	}

	@Override
	public int hashCode() {
		return ((isRule ? 1 : 3) + type.hashCode()) * (topics.hashCode() + arguments.hashCode()
				+ (subThought != null ? subThought.hashCode() : 0) + (isRule ? 3 : 1))
				+ (source != null ? source.hashCode() : 0) + Long.hashCode(timestamp);
	}

	@Override
	public int compareTo(IThought o) {
		if (Boolean.compare(isRule, o.isTemplateForRule()) == 0) {
			if (timestamp == o.getTimestamp()) {
				if (type.equals(o.thoughtType())) {
					if (source == null && o.source() == null || o.source() != null && this.source.equals(o.source())) {
						if (arguments.equals(o.argumentMap())) {
							if (subThought == null || subThought.equals(o.subThought())) {
								return topics.toString().compareTo(o.topicsMap().toString());
							}
							return subThought.compareTo(o.subThought());
						}
						return arguments.toString().compareTo(o.argumentMap().toString());
					}
					return source.uuid().compareTo(o.source().uuid());
				}
				return type.toString().compareTo(o.toString());
			}
			return Long.compare(timestamp, o.getTimestamp());
		}
		return Boolean.compare(isRule, o.isTemplateForRule());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj instanceof IThought th) {
			return isRule && th.isTemplateForRule() //
					&& type.equals(th.thoughtType()) //
					&& this.timestamp == th.getTimestamp() //
					&& (this.source == null ? th.source() == null
							: (th.source() != null && this.source.equals(th.source())))
					&& (this.arguments.equals(th.argumentMap()))
					&& (this.subThought == null ? true : this.subThought.equals(th.subThought()))
					&& Arrays.stream(ThetaRole.values()).allMatch((a) -> {
						if (type.isUnordered(a)) {
							return new HashSet<>(this.topicsForThetaRole(a))
									.equals(new HashSet<>(th.topicsForThetaRole(a)));
						}
						return this.topicsForThetaRole(a).equals(th.topicsForThetaRole(a));
					});
		}
		return false;
	}

}
