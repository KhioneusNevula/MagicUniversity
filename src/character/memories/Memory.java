package character.memories;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import character.feelings.IFeeling;
import character.thought.base.IThought;

public class Memory implements IMemory {

	float truth;
	int salience;
	IThought thought;
	Map<IFeeling, Integer> feelings;

	Memory() {
	}

	@Override
	public int compareTo(IMemory o) {
		if (salience == o.salience()) {
			if (truth == o.truth()) {
				int comp = thought.compareTo(o.thought());
				if (comp == 0) {
					return feelings.toString().compareTo(o.feelingsMap().toString());
				}
				return comp;
			}
			return -Float.compare(truth, o.truth());
		}
		return -Integer.compare(salience, o.salience());
	}

	@Override
	public int hashCode() {
		return thought.hashCode() * salience + feelings.hashCode() + Float.hashCode(truth);
	}

	@Override
	public boolean equals(Object obj) {

		return super.equals(obj);
	}

	@Override
	public int salience() {
		return salience;
	}

	@Override
	public float truth() {
		return truth;
	}

	@Override
	public IThought thought() {
		return thought;
	}

	@Override
	public Collection<IFeeling> feelings() {
		return Collections.unmodifiableSet(feelings.keySet());
	}

	@Override
	public int getFeelingStrength(IFeeling feeling) {
		return feelings.getOrDefault(feeling, 0);
	}

	@Override
	public Map<IFeeling, Integer> feelingsMap() {
		return Collections.unmodifiableMap(feelings);
	}

}
