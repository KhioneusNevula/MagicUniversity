package _category.humanoid;

import java.util.Set;
import java.util.function.Predicate;

import com.google.common.collect.Range;

import avatar.parts.IPartKind;
import avatar.parts.IPart;
import avatar.traits.IPhysicalTrait;
import map.Material;

/**
 * Physical traits with different properties
 */
public enum HumanoidPhysicalTrait implements IPhysicalTrait {
	/**
	 * The muscularity of this person's body
	 */
	MUSCULARITY(1, 5, HumanoidPart.ARM, HumanoidPart.LEG, HumanoidPart.CHEST, HumanoidPart.STOMACH, HumanoidPart.BACK),
	/**
	 * The visible fatness of this person's body
	 */
	FATNESS(1, 5, HumanoidPart.ARM, HumanoidPart.LEG, HumanoidPart.CHEST, HumanoidPart.STOMACH, HumanoidPart.CHEEK),

	/**
	 * Color of a person's skin
	 */
	SKIN_COLOR(1, 16),
	/**
	 * This person's eye color
	 */
	EYE_COLOR(1, 16, HumanoidPart.EYE),
	/**
	 * Color of the general hair OR fur on a person's body
	 */
	HAIR_COLOR(1, 16),
	/** If a certain body part has a different hair color */
	HAS_DIFFERENT_HAIR_COLOR((p) -> p.material() == Material.HAIR),
	/**
	 * The hair color of a part, if its hair color is different
	 */
	PART_HAIR_COLOR(1, 16, (p) -> p.material() == Material.HAIR),
	/** Whether this person is bald */
	BALD,
	/**
	 * Whether this person grows facial hair
	 */
	HAS_FACIAL_HAIR,
	/**
	 * Whether this person grows body hair. Women usually are on setting 1, while
	 * men are usually on setting 2
	 */
	HAS_BODY_HAIR(0, 2),
	/**
	 * Whether this person grows body fur
	 */
	HAS_BODY_FUR,
	/**
	 * Whether this person's body is feminine
	 */
	HAS_FEMININE_FIGURE,
	/**
	 * Whether this person's body is masculine
	 */
	HAS_MASCULINE_FIGURE,

	/** Whether this person's body is humanoid */
	HAS_HUMANOID_BODY,
	/** Whether this person's arms are humanoid */
	HAS_HUMANOID_ARMS,
	/** Whether this person's head is humanoid */
	HAS_HUMANOID_HEAD,
	/** Whetehr this person has humanoid legs */
	HAS_HUMANOID_LEGS,
	/** Whether this person has wolfish body */
	HAS_WOLFISH_BODY,
	/** Whether this person has wolfish arms */
	HAS_WOLFISH_ARMS,
	/** Whetehr this person has wolfish legs */
	HAS_WOLFISH_LEGS,
	/** Whether this person has a wolfish head */
	HAS_WOLFISH_HEAD,
	/** Whether this person has pointy ears */
	HAS_POINTY_EARS,
	/** Goat legs like a demon */
	HAS_GOAT_LEGS,
	/** Instead of visible legs, just a fading graphic like a genie */
	HAS_FADING_LEGS,
	/** Whether this person has human eyes */
	HAS_HUMAN_EYES, HAS_BLANK_EYES, HAS_SERPENTINE_EYES, HAS_WOLFISH_EYES,
	/** Whether this being has human nose */
	HAS_HUMAN_NOSE, HAS_SERPENTINE_NOSE,
	/** Whether this being has human teeth */
	HAS_HUMAN_TEETH, HAS_FANG_TEETH, HAS_SHARK_TEETH,
	/** Whether this being has a human tongue */
	HAS_HUMAN_TONGUE, HAS_SERPENTINE_TONGUE,
	/** Whether this being has bird wings */
	HAS_BIRD_WINGS, HAS_BAT_WINGS, HAS_BUTTERFLY_WINGS, HAS_DRAGONFLY_WINGS,
	/** Whether this being has human hands */
	HAS_HUMAN_HANDS, HAS_WEBBED_HANDS,
	/** Whethehr this being has a tufty tail */
	HAS_TUFT_TAIL,
	/** Whether this being has a pointy tail */
	HAS_POINT_TAIL,
	/** Whether this being has a wolfy tail */
	HAS_WOLFISH_TAIL,
	/** Whether this being has antlers */
	HAS_ANTLERS,
	/** Whether this being has horns */
	HAS_HORNS,
	/** Whether this species has no eyes */
	HAS_NO_EYES,
	/**
	 * If this species has no eyes paired under their brow (e.g. they have no eyes
	 * at all, or they have only a single eye in their forehead
	 */
	HAS_NO_PAIRED_EYES,
	/** Whether this species has an eye on their forehead */
	HAS_FOREHEAD_EYE,
	/**
	 * The pitch of the voice
	 */
	VOICE_PITCH(1, 15),
	/**
	 * At 5, the voice will sound masculine, at 1 it will sound feminine, in the
	 * middle it will sound androgynous
	 */
	VOICE_MASCULINITY(1, 5);

	private Predicate<IPartKind> partPred;
	private Range<Integer> strengths;

	private HumanoidPhysicalTrait() {
		this.partPred = (p) -> (p.slot() == HumanoidPart.ROOT);
		this.strengths = Range.closed(0, 1);
	}

	private HumanoidPhysicalTrait(IPartKind... partsAllowed) {
		Set<IPartKind> slots = Set.of(partsAllowed);
		this.partPred = (p) -> slots.contains(p);
		this.strengths = Range.closed(0, 1);
	}

	private HumanoidPhysicalTrait(IPart... partsAllowed) {
		Set<IPart> slots = Set.of(partsAllowed);
		this.partPred = (p) -> slots.contains(p.slot());
		this.strengths = Range.closed(0, 1);
	}

	private HumanoidPhysicalTrait(Predicate<IPartKind> partPred) {
		this.partPred = partPred;
		this.strengths = Range.closed(0, 1);
	}

	private HumanoidPhysicalTrait(int min, int max) {
		this.partPred = (p) -> (p.slot() == HumanoidPart.ROOT);
		this.strengths = Range.closed(min, max);
	}

	private HumanoidPhysicalTrait(int min, int max, IPartKind... partsAllowed) {
		Set<IPartKind> slots = Set.of(partsAllowed);
		this.partPred = (p) -> slots.contains(p);
		this.strengths = Range.closed(min, max);
	}

	private HumanoidPhysicalTrait(int min, int max, IPart... partsAllowed) {
		Set<IPart> slots = Set.of(partsAllowed);
		this.partPred = (p) -> slots.contains(p.slot());
		this.strengths = Range.closed(min, max);
	}

	private HumanoidPhysicalTrait(int min, int max, Predicate<IPartKind> partPred) {
		this.partPred = partPred;
		this.strengths = Range.closed(min, max);
	}

	@Override
	public boolean appliesToPart(IPartKind part) {
		return partPred.test(part);
	}

	@Override
	public Range<Integer> strengthRange() {
		return strengths;
	}
}
