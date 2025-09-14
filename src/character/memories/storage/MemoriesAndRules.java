package character.memories.storage;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Table;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;

import character.memories.IMemory;
import character.rules.IRule;
import character.thought.ThetaRole;
import character.thought.base.IThought;
import character.thought.type.IThoughtType;
import character.topic.ITopic;

public class MemoriesAndRules implements IMemoriesAndRules {

	/**
	 * Maps memory to topics by theta role
	 */
	private Table<ITopic, ThetaRole, TreeSet<IMemory>> topicsByTheta = HashBasedTable.create();
	/**
	 * relatiomnshp memories for topics
	 */
	private Map<ITopic, IRelationshipMemory> relationshipMemories = new HashMap<>();
	/**
	 * Directed edges indicate causal relationships
	 */
	private MutableGraph<IMemory> memoryGraph = GraphBuilder.directed().allowsSelfLoops(false).build();

	/**
	 * Used to store memory by timestamp
	 */
	private Multimap<Long, IMemory> timeBasedMemory = MultimapBuilder.treeKeys().treeSetValues().build();

	/**
	 * Rules for this mind
	 */
	private Multimap<IThoughtType, IRule> rules = MultimapBuilder.hashKeys().hashSetValues().build();

	public MemoriesAndRules() {

	}

	@Override
	public Collection<IRule> rules() {
		return rules.values();
	}

	/**
	 * Adds a rule to memory
	 * 
	 * @param rule
	 */
	public void addRule(IRule rule) {
		rules.put(rule.cause().thoughtType(), rule);
	}

	/**
	 * Removes rule from memory
	 * 
	 * @param rule
	 */
	public void forgetRule(IRule rule) {
		rules.remove(rule.cause().thoughtType(), rule);
	}

	/**
	 * Adds a memory
	 * 
	 * @param memory
	 * @return
	 */
	public void addMemory(IMemory memory) {
		if (!this.memoryGraph.addNode(memory)) { // already present
			return;
		}
		for (ThetaRole theta : ThetaRole.values()) {
			for (ITopic topic : memory.thought().topicsForThetaRole(theta)) {
				if (topicsByTheta.column(theta).computeIfAbsent(topic, (a) -> new TreeSet<>()).add(memory)) {
					if (this.relationshipMemories.containsKey(topic)) {
						this.relationshipMemories.put(topic,
								updateRelationship(topic, this.relationshipMemory(topic), memory, false));
					}
				}
			}
		}
	}

	public void removeMemory(IMemory memory) {
		if (!this.memoryGraph.removeNode(memory)) {
			return;
		}
		for (ThetaRole theta : ThetaRole.values()) {
			for (ITopic topic : memory.thought().topicsForThetaRole(theta)) {
				if (topicsByTheta.column(theta).getOrDefault(topic, new TreeSet<>()).remove(memory)) {
					if (this.relationshipMemories.containsKey(topic)) {
						this.relationshipMemories.put(topic,
								updateRelationship(topic, this.relationshipMemory(topic), memory, true));
					}
				}
			}
		}
	}

	/**
	 * Adds a causal relationship from the given memory to "cause" (adds memories if
	 * they are not present)
	 * 
	 * @param memory
	 * @param cause
	 */
	public void addCausationalMemories(IMemory memory, IMemory cause) {
		this.addMemory(memory);
		this.addMemory(cause);
		this.memoryGraph.putEdge(EndpointPair.ordered(cause, memory));
	}

	@Override
	public Collection<IRule> rulesFitting(IThought thought) {
		Set<IRule> returns = new HashSet<>();
		for (IRule rule : rules.get(thought.thoughtType())) {
			if (rule.matchesThoughts(thought)) {
				returns.add(rule); // if everything passes through, add it
			}
		}
		return returns;
	}

	@Override
	public Collection<IMemory> memories() {
		return memoryGraph.nodes();
	}

	@Override
	public Collection<ITopic> topics() {
		return topicsByTheta.rowKeySet();
	}

	protected IRelationshipMemory computeRelationship(ITopic topic) {
		return RelationshipMemory.compute(topic, this);
	}

	protected IRelationshipMemory updateRelationship(ITopic topic, IRelationshipMemory rela, IMemory memory,
			boolean remove) {
		return RelationshipMemory.update(topic, rela, memory, remove);
	}

	@Override
	public IRelationshipMemory relationshipMemory(ITopic topic) {
		if (!this.topicsByTheta.containsRow(topic)) {
			return null;
		}
		return this.relationshipMemories.computeIfAbsent(topic, (key) -> {
			return computeRelationship(key);
		});
	}

	@Override
	public Collection<IMemory> memoriesWithThetaRole(ITopic topic, ThetaRole role) {
		TreeSet<IMemory> memories = topicsByTheta.get(topic, role);
		if (memories == null) {
			return Collections.emptyList();
		}
		return memories;
	}

	@Override
	public Collection<IMemory> getCausedMemories(IMemory memory) {
		return memoryGraph.successors(memory);
	}

	@Override
	public Collection<IMemory> getCausers(IMemory memory) {
		return memoryGraph.predecessors(memory);
	}

}
