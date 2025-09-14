package character.memories.storage;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import character.feelings.IFeeling;
import character.memories.IMemory;
import character.thought.ThetaRole;
import character.topic.ITopic;

public class RelationshipMemory implements IRelationshipMemory {

	/**
	 * Create a new relationship memory based on the old one, with the given memory
	 * either added or removed
	 * 
	 * @param topic
	 * @param memory
	 * @param memory
	 * @param remove
	 * @return
	 */
	public static RelationshipMemory update(ITopic topic, IRelationshipMemory rmem, IMemory memory, boolean remove) {
		RelationshipMemory newmem = new RelationshipMemory();
		newmem.salience = rmem.getSalience() + (remove ? -1 : 1) * memory.salience();
		for (IFeeling fee : rmem.getFeelings()) {
			int avg = rmem.getFeeling(fee);
			int count = rmem.getFeelingMemoryCount(fee);
			if (count == 1 && remove) {
				continue;
			} else {
				int newstrength = (avg * count + (remove ? -1 : 1) * memory.getFeelingStrength(fee))
						/ (count + (remove ? -1 : 1));
				newmem.feelings.put(fee, newstrength);
				newmem.feelingCounts.put(fee, count + (remove ? -1 : 1));
			}
		}
		return newmem;
	}

	/**
	 * Compute relmemory from the given topic and memory bank
	 * 
	 * @param topic
	 * @param memrules
	 * @return
	 */
	public static RelationshipMemory compute(ITopic topic, IMemoriesAndRules memrules) {
		RelationshipMemory rmemory = new RelationshipMemory();
		for (IMemory mem : (Iterable<IMemory>) () -> Arrays.stream(ThetaRole.values())
				.flatMap((tr) -> memrules.memoriesWithThetaRole(topic, tr).stream()).distinct().iterator()) {
			for (IFeeling fee : mem.feelings()) {
				int fstr = mem.getFeelingStrength(fee);
				rmemory.feelings.put(fee, rmemory.feelings.getOrDefault(fee, 0) + fstr);
				rmemory.feelingCounts.put(fee, rmemory.feelingCounts.getOrDefault(fee, 0) + 1);
			}
			rmemory.salience += mem.salience();
		}

		return rmemory;
	}

	private Map<IFeeling, Integer> feelings = new HashMap<>();
	private Map<IFeeling, Integer> feelingCounts = new HashMap<>();
	private int salience;

	private RelationshipMemory() {

	}

	@Override
	public int getFeeling(IFeeling forF) {
		return feelings.getOrDefault(forF, 0);
	}

	@Override
	public int getFeelingMemoryCount(IFeeling forF) {
		return feelingCounts.getOrDefault(forF, 0);
	}

	@Override
	public Collection<IFeeling> getFeelings() {
		return Collections.unmodifiableSet(feelings.keySet());
	}

	@Override
	public int getSalience() {
		return salience;
	}

}
