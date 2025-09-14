package _category.humanoid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import _category.general.parts.IPartGenerator;
import _category.general.parts.PartGenerator;
import _category.general.parts.PartGeneratorUtils;
import avatar.IAvatar;
import avatar.parts.IPartKind;

public class HumanoidPartUtils extends PartGeneratorUtils {

	private static IPartGenerator PROFILE;

	protected HumanoidPartUtils() {
	}

	/**
	 * Return the humanoid parts profile
	 * 
	 * @return
	 */
	public static IPartGenerator getHumanoidPartGenerator() {
		return PROFILE;
	}

	/**
	 * Initializes the general human {@link IPartGenerator}f
	 */
	public static void initPartGenerator() {
		Map<IPartKind, Function<IAvatar, Float>> map = new HashMap<>();

		// generalized body parts
		Function<IAvatar, Float> isHumanoid = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_HUMANOID_BODY);
		map.put(HumanoidPartKind.BODY, always());
		map.put(HumanoidPartKind.LOWER_EXTREMITY, always());
		map.put(HumanoidPartKind.HEAD_HUMAN, isHumanoid);

		// torso parts
		Function<IAvatar, Float> masculine = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_MASCULINE_FIGURE);
		Function<IAvatar, Float> feminine = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_FEMININE_FIGURE);

		map.put(HumanoidPartKind.TORSO_HUMANOID_MASCULINE, and(isHumanoid, masculine));
		map.put(HumanoidPartKind.TORSO_HUMANOID_FEMININE, and(isHumanoid, feminine));
		map.put(HumanoidPartKind.TORSO_HUMANOID_ANDROGYNOUS, and(isHumanoid, fixed(0.25f)));

		map.put(HumanoidPartKind.CHEST, always());
		map.put(HumanoidPartKind.BACK, always());

		map.put(HumanoidPartKind.BREAST_MASCULINE, masculine);
		map.put(HumanoidPartKind.BREAST_FEMININE, feminine);

		map.put(HumanoidPartKind.STOMACH, always());

		map.put(HumanoidPartKind.NAVEL_INNIE, fixed(0.9f));
		map.put(HumanoidPartKind.NAVEL_OUTIE, fixed(0.1f));

		map.put(HumanoidPartKind.GROIN_FEMININE, feminine);
		map.put(HumanoidPartKind.GROIN_MASCULINE, masculine);
		map.put(HumanoidPartKind.BUTT, always());
		map.put(HumanoidPartKind.HIP, always());

		// arms
		Function<IAvatar, Float> humanArms = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_HUMANOID_ARMS);
		Function<IAvatar, Float> humanHands = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_HUMAN_HANDS);
		Function<IAvatar, Float> webbedHands = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_WEBBED_HANDS);

		map.put(HumanoidPartKind.ARM, humanArms);
		map.put(HumanoidPartKind.SHOULDER, always());
		map.put(HumanoidPartKind.UPPER_ARM, always());
		map.put(HumanoidPartKind.FOREARM, always());

		map.put(HumanoidPartKind.HAND_HUMAN, humanHands);
		map.put(HumanoidPartKind.HAND_WEBBED, webbedHands);

		// legs
		Function<IAvatar, Float> humanLegs = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_HUMANOID_LEGS);
		Function<IAvatar, Float> goatLegs = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_GOAT_LEGS);
		Function<IAvatar, Float> fadeLegs = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_FADING_LEGS);

		map.put(HumanoidPartKind.LEG_HUMAN, humanLegs);
		map.put(HumanoidPartKind.LEG_GOAT, goatLegs);
		map.put(HumanoidPartKind.LEG_FADE, fadeLegs);

		map.put(HumanoidPartKind.THIGH, always());
		map.put(HumanoidPartKind.SHIN, always());
		map.put(HumanoidPartKind.FOOT, humanLegs);

		// head parts
		Function<IAvatar, Float> isHeadHumanoid = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_HUMANOID_HEAD);

		map.put(HumanoidPartKind.CROWN, always());
		map.put(HumanoidPartKind.NECK, always());
		map.put(HumanoidPartKind.NAPE, always());

		// head hair
		Function<IAvatar, Float> notBald = disallowedIfAnyPresent(HumanoidPhysicalTrait.BALD);

		map.put(HumanoidPartKind.HAIR_BALD, always());
		List.of(HumanoidPartKind.HAIR_1, HumanoidPartKind.HAIR_2, HumanoidPartKind.HAIR_3)
				.forEach((a) -> map.put(a, notBald));

		// ears
		Function<IAvatar, Float> hasPointyEars = and(isHeadHumanoid,
				allowedIfAllPresent(HumanoidPhysicalTrait.HAS_POINTY_EARS));

		map.put(HumanoidPartKind.EAR_HUMAN, and(isHeadHumanoid, not(hasPointyEars)));
		List.of(HumanoidPartKind.EAR_LONG_POINT, HumanoidPartKind.EAR_SMALL_POINT)
				.forEach((ea) -> map.put(ea, hasPointyEars));

		// face
		List.of(HumanoidPartKind.FACE_1, HumanoidPartKind.FACE_2, HumanoidPartKind.FACE_3, HumanoidPartKind.FACE_4)
				.forEach((fa) -> map.put(fa, isHeadHumanoid));
		map.put(HumanoidPartKind.CHEEK, always());

		// eyes
		Function<IAvatar, Float> hasEyes = disallowedIfAnyPresent(HumanoidPhysicalTrait.HAS_NO_EYES);
		Function<IAvatar, Float> hasNoPairEyes = disallowedIfAnyPresent(HumanoidPhysicalTrait.HAS_NO_PAIRED_EYES);
		Function<IAvatar, Float> hasPairEyes = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_NO_PAIRED_EYES);
		Function<IAvatar, Float> haveHumanEyes = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_HUMAN_EYES);
		Function<IAvatar, Float> haveBlankEyes = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_BLANK_EYES);
		Function<IAvatar, Float> haveSerpentineEyes = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_SERPENTINE_EYES);
		Function<IAvatar, Float> haveWolfishEyes = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_WOLFISH_EYES);

		map.put(HumanoidPartKind.EYES_HUMAN, and(haveHumanEyes, hasEyes, hasPairEyes));
		map.put(HumanoidPartKind.EYES_BLANK, and(haveBlankEyes, hasEyes, hasPairEyes));
		map.put(HumanoidPartKind.EYES_SERPENTINE, and(haveSerpentineEyes, hasEyes, hasPairEyes));
		map.put(HumanoidPartKind.EYES_WOLFISH, and(haveWolfishEyes, hasEyes, hasPairEyes));

		map.put(HumanoidPartKind.EYE, always());

		// nose
		Function<IAvatar, Float> haveHumanNose = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_HUMAN_NOSE);
		Function<IAvatar, Float> haveSerpentineNose = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_SERPENTINE_NOSE);

		List.of(HumanoidPartKind.NOSE_1, HumanoidPartKind.NOSE_2, HumanoidPartKind.NOSE_3, HumanoidPartKind.NOSE_4)
				.forEach((no) -> map.put(no, haveHumanNose));
		map.put(HumanoidPartKind.NOSE_SERPENTINE, haveSerpentineNose);

		// mouth
		Function<IAvatar, Float> haveHumanTeeth = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_HUMAN_TEETH);
		Function<IAvatar, Float> haveFangTeeth = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_FANG_TEETH);
		Function<IAvatar, Float> haveSharkTeeth = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_SHARK_TEETH);
		Function<IAvatar, Float> haveHumanTongue = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_HUMAN_TONGUE);
		Function<IAvatar, Float> haveSerpentineTongue = allowedIfAllPresent(
				HumanoidPhysicalTrait.HAS_SERPENTINE_TONGUE);

		map.put(HumanoidPartKind.MOUTH, always());
		List.of(HumanoidPartKind.LIPS_1, HumanoidPartKind.LIPS_2, HumanoidPartKind.LIPS_3, HumanoidPartKind.LIPS_4)
				.forEach((li) -> map.put(li, always()));

		map.put(HumanoidPartKind.TEETH_HUMAN, haveHumanTeeth);
		map.put(HumanoidPartKind.TEETH_FANGS, haveFangTeeth);
		map.put(HumanoidPartKind.TEETH_SHARK, haveSharkTeeth);

		map.put(HumanoidPartKind.TONGUE_HUMAN, haveHumanTongue);
		map.put(HumanoidPartKind.TONGUE_SERPENTINE, haveSerpentineTongue);

		// body hair parts
		Function<IAvatar, Float> hasNoBodyHair = disallowedIfAnyPresent(HumanoidPhysicalTrait.HAS_BODY_HAIR);
		Function<IAvatar, Float> hasSomeBodyHair = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_BODY_HAIR);
		Function<IAvatar, Float> hasMuchBodyHair = allowedIfAllGEThan(2, HumanoidPhysicalTrait.HAS_BODY_HAIR);

		List.of(HumanoidPartKind.ARM_HAIR_NONE, HumanoidPartKind.CHEST_HAIR_NONE, HumanoidPartKind.LEG_HAIR_NONE,
				HumanoidPartKind.STOMACH_HAIR_NONE).forEach((hai) -> map.put(hai, hasNoBodyHair));
		List.of(HumanoidPartKind.ARM_HAIR_DECENT, HumanoidPartKind.ARM_HAIR_SPARSE, HumanoidPartKind.CHEST_HAIR_LINE,
				HumanoidPartKind.CHEST_HAIR_SPARSE, HumanoidPartKind.LEG_HAIR_DECENT, HumanoidPartKind.LEG_HAIR_SPARSE,
				HumanoidPartKind.STOMACH_HAIR_SPARSE, HumanoidPartKind.STOMACH_HAIR_TRAIL)
				.forEach((hai) -> map.put(hai, hasSomeBodyHair));

		List.of(HumanoidPartKind.ARM_HAIR_LOT, HumanoidPartKind.CHEST_HAIR_DECENT, HumanoidPartKind.CHEST_HAIR_LOT,
				HumanoidPartKind.LEG_HAIR_LOT, HumanoidPartKind.STOMACH_HAIR_LOT)
				.forEach((hai) -> map.put(hai, hasMuchBodyHair));

		// handle inhuman types
		Function<IAvatar, Float> hasForeheadEye = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_FOREHEAD_EYE);

		map.put(HumanoidPartKind.THIRD_EYE_BLANK, and(hasNoPairEyes, hasForeheadEye));
		map.put(HumanoidPartKind.THIRD_EYE_PUPILLED, and(hasNoPairEyes, hasForeheadEye));

		Function<IAvatar, Float> hasFur = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_BODY_FUR);

		List.of(HumanoidPartKind.ARM_HAIR_FUR, HumanoidPartKind.CHEST_HAIR_FUR, HumanoidPartKind.LEG_HAIR_FUR,
				HumanoidPartKind.STOMACH_HAIR_FUR).forEach((hai) -> map.put(hai, hasFur));

		// horns
		Function<IAvatar, Float> hasHorns = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_HORNS);
		Function<IAvatar, Float> hasAntlers = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_ANTLERS);

		List.of(HumanoidPartKind.HORN_CURVE, HumanoidPartKind.HORN_S_CURVE, HumanoidPartKind.HORN_STRAIGHT)
				.forEach((ho) -> map.put(ho, hasHorns));
		map.put(HumanoidPartKind.HORN_ANTLER, hasAntlers);

		// wings
		Function<IAvatar, Float> birdWings = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_BIRD_WINGS);
		Function<IAvatar, Float> batWings = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_BAT_WINGS);
		Function<IAvatar, Float> butterflyWings = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_BUTTERFLY_WINGS);
		Function<IAvatar, Float> dragonflyWings = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_DRAGONFLY_WINGS);

		map.put(HumanoidPartKind.BIRD_WING, birdWings);
		map.put(HumanoidPartKind.BAT_WING, batWings);
		List.of(HumanoidPartKind.BUTTERFLY_WING_1, HumanoidPartKind.BUTTERFLY_WING_2, HumanoidPartKind.BUTTERFLY_WING_3,
				HumanoidPartKind.BUTTERFLY_WING_4).forEach((wi) -> map.put(wi, butterflyWings));
		map.put(HumanoidPartKind.DRAGONFLY_WING, dragonflyWings);

		// tails
		Function<IAvatar, Float> tuftTail = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_TUFT_TAIL);
		Function<IAvatar, Float> pointTail = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_POINT_TAIL);

		List.of(HumanoidPartKind.TAIL_FEATHER, HumanoidPartKind.TAIL_TUFT).forEach((ta) -> map.put(ta, tuftTail));
		map.put(HumanoidPartKind.TAIL_POINTY, pointTail);

		// handle wolfish type
		Function<IAvatar, Float> isWolf = allowedIfAllPresent(HumanoidSpeciesTrait.WOLFISH);
		Function<IAvatar, Float> wolfHead = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_WOLFISH_HEAD);
		Function<IAvatar, Float> wolfArms = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_WOLFISH_ARMS);
		Function<IAvatar, Float> wolfLegs = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_WOLFISH_LEGS);
		Function<IAvatar, Float> wolfTail = allowedIfAllPresent(HumanoidPhysicalTrait.HAS_WOLFISH_TAIL);

		map.put(HumanoidPartKind.HEAD_WOLFISH, wolfHead);
		map.put(HumanoidPartKind.EAR_WOLFISH, wolfHead);
		map.put(HumanoidPartKind.ARM_WOLFISH, wolfArms);
		map.put(HumanoidPartKind.HAND_WOLFISH, wolfArms);
		map.put(HumanoidPartKind.LEG_WOLFISH, wolfLegs);
		map.put(HumanoidPartKind.FOOT_WOLFISH, wolfLegs);
		map.put(HumanoidPartKind.TAIL_WOLFISH, wolfTail);
		map.put(HumanoidPartKind.FACE_WOLFISH, wolfHead);
		map.put(HumanoidPartKind.NOSE_WOLFISH, wolfHead);
		map.put(HumanoidPartKind.TORSO_WOLFISH, isWolf);

		PROFILE = new PartGenerator(map);
	}

}
