package _category.general.parts;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;

import _utilities.Pair;
import avatar.IAvatar;
import avatar.parts.IPart;
import avatar.parts.IPartKind;
import avatar.traits.IPhysicalTrait;

/**
 * A part profile
 * 
 * @author borah
 *
 */
public class PartGenerator implements IPartGenerator {

	private Table<IPart, IPartKind, Function<IAvatar, Float>> partPos;

	/**
	 * A map mapping part kinds to a function that determines their probability for
	 * the given avatar
	 * 
	 * @param input
	 */
	public PartGenerator(Map<IPartKind, Function<IAvatar, Float>> input) {
		partPos = input.entrySet().stream().collect(Tables.toTable((en) -> en.getKey().slot(), (en) -> en.getKey(),
				(en) -> en.getValue(), HashBasedTable::create));
	}

	@Override
	public Collection<IPartKind> possibleParts(IPart slot) {
		return partPos.row(slot).keySet();
	}

	@Override
	public float probability(IPartKind part, IAvatar avatar) {

		return partPos.get(part.slot(), part).apply(avatar);
	}

	@Override
	public IPartKind selectPart(IPart slot, IAvatar traits, Random rand) {
		List<Entry<IPartKind, Float>> probabilityList = partPos.row(slot).entrySet().stream()
				.map((en) -> Pair.of(en.getKey(), en.getValue().apply(traits))).collect(Collectors.toList());
		Collections.shuffle(probabilityList);
		float totalProb = (float) probabilityList.stream().mapToDouble(Map.Entry::getValue).sum();
		float genProb = rand.nextFloat() * totalProb;
		float sum = 0;
		for (Entry<IPartKind, Float> entry : probabilityList) {
			sum += entry.getValue();
			if (genProb <= sum) {
				if (entry.getKey().isNone()) {
					return null;
				}
				return entry.getKey();
			}
		}
		return null;
	}

}
