package _category.humanoid;

import avatar.parts.IPart;
import avatar.parts.IPartKind;
import map.IMaterial;
import map.Material;

public enum HumanoidPartKind implements IPartKind {
	/** Standard humanoid body */
	BODY(HumanoidPart.ROOT, Material.FLESH),
	/** Standard humanoid lower extremity */
	LOWER_EXTREMITY(HumanoidPart.LOWER_EXTREMITY, Material.FLESH),
	/** Human head */
	HEAD_HUMAN(HumanoidPart.HEAD, Material.FLESH),
	/** Wolfman head */
	HEAD_WOLFISH(HEAD_HUMAN),
	/** A masculine-shaped torso */
	TORSO_HUMANOID_MASCULINE(HumanoidPart.TORSO, Material.FLESH),
	/** A feminine-shaped torso */
	TORSO_HUMANOID_FEMININE(TORSO_HUMANOID_MASCULINE),
	/** An androgynously-shaped torso */
	TORSO_HUMANOID_ANDROGYNOUS(TORSO_HUMANOID_MASCULINE),
	/** A wolfish torso */
	TORSO_WOLFISH(TORSO_HUMANOID_MASCULINE),
	/** A set of faces */
	FACE_1(HumanoidPart.FACE, Material.FLESH), FACE_2(FACE_1), FACE_3(FACE_1), FACE_4(FACE_1),
	/** wolfy face **/
	FACE_WOLFISH(FACE_1),
	/** Just the crown of the head */
	CROWN(HumanoidPart.CROWN, Material.FLESH),
	/** Some mild neck variants */
	NECK(HumanoidPart.NECK, Material.FLESH),
	/** A standard round human ear */
	EAR_HUMAN(HumanoidPart.EAR, Material.CARTILAGE),
	/** Pointy ears */
	EAR_SMALL_POINT(EAR_HUMAN), EAR_LONG_POINT(EAR_HUMAN),
	/** Doggy ears */
	EAR_WOLFISH(EAR_HUMAN),
	/** A standard human eye */
	EYES_HUMAN(HumanoidPart.EYES, Material.EYE_FLUID),
	/** Snake eyes */
	EYES_SERPENTINE(EYES_HUMAN),
	/** Featureless eye */
	EYES_BLANK(EYES_HUMAN),
	/** Wolf eyes */
	EYES_WOLFISH(EYES_HUMAN),
	/** default singular eye (matches general eye texture) */
	EYE(HumanoidPart.EYE, Material.EYE_FLUID),
	/** third eye with dark vibes */
	THIRD_EYE_BLANK(HumanoidPart.THIRD_EYE, Material.EYE_FLUID),
	/** third eye with light vibes */
	THIRD_EYE_PUPILLED(THIRD_EYE_BLANK),
	/** A set of noses */
	NOSE_1(HumanoidPart.NOSE, Material.CARTILAGE), NOSE_2(NOSE_1), NOSE_3(NOSE_1), NOSE_4(NOSE_1),
	/** an inhhuman nose */
	NOSE_SERPENTINE(HumanoidPart.NOSE, Material.CARTILAGE),
	/** wolfy nose **/
	NOSE_WOLFISH(NOSE_1),
	/** a cheek */
	CHEEK(HumanoidPart.CHEEK, Material.FLESH),
	/** A regular mouth */
	MOUTH(HumanoidPart.MOUTH, Material.FLESH),
	/** A set of lips */
	LIPS_1(HumanoidPart.LIPS, Material.FLESH), LIPS_2(LIPS_1), LIPS_3(LIPS_1), LIPS_4(LIPS_1),
	/** Regular human teeth */
	TEETH_HUMAN(HumanoidPart.TEETH, Material.BONE),
	/** Vampiric fangs */
	TEETH_FANGS(TEETH_HUMAN),
	/** Shark teeth */
	TEETH_SHARK(TEETH_HUMAN),
	/** Human tongue */
	TONGUE_HUMAN(HumanoidPart.TONGUE, Material.FLESH),
	/** Forked tongue */
	TONGUE_SERPENTINE(TONGUE_HUMAN),
	/** Antler horns */
	HORN_ANTLER(HumanoidPart.HORN, Material.HORN),
	/** Curved horns */
	HORN_CURVE(HumanoidPart.HORN, Material.HORN),
	/** S-shaped horns */
	HORN_S_CURVE(HumanoidPart.HORN, Material.HORN),
	/** Straight horns */
	HORN_STRAIGHT(HumanoidPart.HORN, Material.HORN),
	/** Nape of neck */
	NAPE(HumanoidPart.NAPE, Material.FLESH),
	/** The chest */
	CHEST(HumanoidPart.CHEST, Material.FLESH),
	/** Masculine breast */
	BREAST_MASCULINE(HumanoidPart.BREAST, Material.FLESH),
	/** Feminine breast */
	BREAST_FEMININE(HumanoidPart.BREAST, Material.FLESH),
	/** Human stomach */
	STOMACH(HumanoidPart.STOMACH, Material.FLESH),
	/** Navel styles */
	NAVEL_INNIE(HumanoidPart.NAVEL, Material.FLESH), NAVEL_OUTIE(NAVEL_INNIE),
	/** Humanoid back */
	BACK(HumanoidPart.BACK, Material.FLESH),
	/** Angelic bird wing */
	BIRD_WING(HumanoidPart.WING, Material.FLESH),
	/** Demonic bat wing */
	BAT_WING(BIRD_WING),
	/** Fairy butterfly wing styles */
	BUTTERFLY_WING_1(BIRD_WING), BUTTERFLY_WING_2(BIRD_WING), BUTTERFLY_WING_3(BIRD_WING), BUTTERFLY_WING_4(BIRD_WING),
	/** Fairy dragonfly wing */
	DRAGONFLY_WING(BIRD_WING),
	/** Standard arm */
	ARM(HumanoidPart.ARM, Material.FLESH),
	/** wolfish arm */
	ARM_WOLFISH(HumanoidPart.ARM, Material.FLESH),
	/** Shoulder */
	SHOULDER(HumanoidPart.SHOULDER, Material.FLESH),
	/** upper arm */
	UPPER_ARM(HumanoidPart.UPPER_ARM, Material.FLESH),
	/** lower arm */
	FOREARM(HumanoidPart.FOREARM, Material.FLESH),
	/** hand */
	HAND_HUMAN(HumanoidPart.HAND, Material.FLESH),
	/** Wolf paw */
	HAND_WOLFISH(HAND_HUMAN),
	/** Webbed hand */
	HAND_WEBBED(HAND_HUMAN),
	/** Booty */
	BUTT(HumanoidPart.BUTT, Material.FLESH),
	/** Groin (...divide into masculine and feminine...?) */
	GROIN_MASCULINE(HumanoidPart.GROIN, Material.FLESH), GROIN_FEMININE(GROIN_MASCULINE),
	/** Hip */
	HIP(HumanoidPart.HIP, Material.FLESH),
	/** Tuft tail */
	TAIL_TUFT(HumanoidPart.TAIL, Material.FLESH), TAIL_FEATHER(TAIL_TUFT),
	/** Point tail */
	TAIL_POINTY(TAIL_TUFT),
	/** Wolfy tail */
	TAIL_WOLFISH(TAIL_TUFT),
	/** regular human leg */
	LEG_HUMAN(HumanoidPart.LEG, Material.FLESH),
	/** Goatlike legs */
	LEG_GOAT(LEG_HUMAN),
	/** Invisible genie legs */
	LEG_FADE(LEG_HUMAN),
	/** Wolfish leg */
	LEG_WOLFISH(LEG_HUMAN),
	/** Regular thigh */
	THIGH(HumanoidPart.THIGH, Material.FLESH),
	/** Regular shin */
	SHIN(HumanoidPart.SHIN, Material.FLESH),
	/** Regular foot */
	FOOT(HumanoidPart.FOOT, Material.FLESH),
	/** A wolf paw foot */
	FOOT_WOLFISH(FOOT),
	/** Hair textures */
	/** no hair */
	HAIR_BALD(HumanoidPart.HAIR, null), HAIR_1(HumanoidPart.HAIR, Material.HAIR), HAIR_2(HAIR_1), HAIR_3(HAIR_1),
	/** Facial hair textures */
	/** No facial hair */
	FACIAL_HAIR_NONE(HumanoidPart.FACIAL_HAIR, null), FACIAL_HAIR_1(HumanoidPart.FACIAL_HAIR, Material.HAIR),
	FACIAL_HAIR_2(FACIAL_HAIR_1), FACIAL_HAIR_3(FACIAL_HAIR_1),
	/** WOlf fur */
	FACIAL_FUR_WOLFISH(HumanoidPart.FACIAL_HAIR, Material.FUR),
	/** Chest hair patterns */
	/** No chest hair */
	CHEST_HAIR_NONE(HumanoidPart.CHEST_HAIR, null), CHEST_HAIR_SPARSE(HumanoidPart.CHEST_HAIR, Material.HAIR),
	CHEST_HAIR_LINE(CHEST_HAIR_SPARSE), CHEST_HAIR_DECENT(CHEST_HAIR_SPARSE), CHEST_HAIR_LOT(CHEST_HAIR_SPARSE),
	/** Wolf chest hair */
	CHEST_HAIR_FUR(HumanoidPart.CHEST_HAIR, Material.FUR),
	/** Stomach hair patterns */
	/** No stomach hair */
	STOMACH_HAIR_NONE(HumanoidPart.STOMACH_HAIR, null), STOMACH_HAIR_SPARSE(HumanoidPart.STOMACH_HAIR, Material.HAIR),
	STOMACH_HAIR_TRAIL(STOMACH_HAIR_SPARSE), STOMACH_HAIR_LOT(STOMACH_HAIR_SPARSE),
	/** Wolf stomach hair */
	STOMACH_HAIR_FUR(HumanoidPart.STOMACH_HAIR, Material.FUR),
	/** Arm hair */
	/** No arm hair */
	ARM_HAIR_NONE(HumanoidPart.ARM_HAIR, null), ARM_HAIR_SPARSE(HumanoidPart.ARM_HAIR, Material.HAIR),
	ARM_HAIR_DECENT(ARM_HAIR_SPARSE), ARM_HAIR_LOT(ARM_HAIR_SPARSE),
	/** Wolf arm fur */
	ARM_HAIR_FUR(HumanoidPart.ARM_HAIR, Material.FUR),
	/** Leg hair */
	/** No leg hair */
	LEG_HAIR_NONE(HumanoidPart.LEG_HAIR, null), LEG_HAIR_SPARSE(HumanoidPart.LEG_HAIR, Material.HAIR),
	LEG_HAIR_DECENT(LEG_HAIR_SPARSE), LEG_HAIR_LOT(LEG_HAIR_SPARSE),
	/** Wolf leg fur */
	LEG_HAIR_FUR(HumanoidPart.LEG_HAIR, Material.FUR);

	private IPart slot;
	private IMaterial material;
	private boolean isNothing;

	private HumanoidPartKind(HumanoidPartKind copier) {
		this.slot = copier.slot;
		this.material = copier.material;
	}

	/**
	 * If Material is "null", make a null part
	 * 
	 * @param slot
	 * @param material
	 */

	private HumanoidPartKind(IPart slot, IMaterial material) {
		this.slot = slot;
		this.material = material == null ? Material.NOTHING : material;
		this.isNothing = material == null;
	}

	@Override
	public IPart slot() {
		return slot;
	}

	@Override
	public IMaterial material() {
		return material;
	}

	@Override
	public boolean isNone() {
		return isNothing;
	}

}
