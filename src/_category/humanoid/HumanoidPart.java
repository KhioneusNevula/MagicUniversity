package _category.humanoid;

import avatar.parts.IPart;

/**
 * Standard part slots for something vaguely humanoid
 * 
 * @author borah
 *
 */
public enum HumanoidPart implements IPart {
	// SEGMENTS
	HEAD(1f / 8f), TORSO(3 * 1f / 8f), LOWER_EXTREMITY(4 * 1f / 8f),

	// HEAD
	FACE(HEAD, 1f), CROWN(HEAD, 1f / 4f), NECK(HEAD, 1f / 4f), EAR(HEAD, 1f / 4f, true, false),

	// FACE
	EYES(FACE, 1f / 7f, false, false), NOSE(FACE, 1f / 3f), CHEEK(FACE, 1f / 3f, true, false), MOUTH(FACE, 1f / 4f),
	FACIAL_HAIR(FACE, 1f / 3f),

	// NOSE
	EYE(EYES, 1f / 7f, true, false), THIRD_EYE(EYES, 1f / 7f, false, false),

	// MOUTH
	LIPS(MOUTH, 2f / 3f), TEETH(MOUTH, 1f / 3f), TONGUE(MOUTH, 1f / 3f),

	// CROWN
	HAIR(CROWN, 1f), HORN(CROWN, 2f, true, false),

	// NECK
	NAPE(NECK, 1f, false, true),

	// TORSO
	CHEST(TORSO, 2f / 5f), STOMACH(TORSO, 3f / 5f), BACK(TORSO, 1f, false, true), ARM(TORSO, 1f, true, false), //
	BREAST(CHEST, 1f, true, false), CHEST_HAIR(CHEST, 1f, false, false), NAVEL(STOMACH, 1f / 5f, false, false),
	STOMACH_HAIR(STOMACH, 1f, false, false), WING(BACK, 1f, true, true), //

	// ARM
	SHOULDER(ARM, 1f / 6f, true, false), ARM_HAIR(ARM, 1f, false, false), UPPER_ARM(ARM, 1f / 2f, true, false),
	FOREARM(ARM, 1f / 2f, true, false), HAND(ARM, 1f / 6f, true, false),

	// LOWER EXTREMITY
	BUTT(LOWER_EXTREMITY, 1f / 6f, false, true), TAIL(LOWER_EXTREMITY, 1f, false, true),
	GROIN(LOWER_EXTREMITY, 1f / 6f, false, false), HIP(LOWER_EXTREMITY, 1f / 6f, true, false),

	// LEG
	LEG(LOWER_EXTREMITY, 7f / 6f, true, false), THIGH(LEG, 1f / 2f, true, false), SHIN(LEG, 1f / 2f, true, false),
	FOOT(LEG, 1f / 7f, true, false), LEG_HAIR(LOWER_EXTREMITY, 1f, false, false),

	/*
	 * // MERMAID TAIL
	 * 
	 * FISH_TRUNK(LOWER_EXTREMITY, 5f / 6f, false, false),
	 * FISH_TAIL(LOWER_EXTREMITY, 1f / 6f, false, false),
	 * 
	 * // SNAKE TRUNK
	 * 
	 * SNAKE_TRUNK(LOWER_EXTREMITY, 1f, false, false)
	 */;

	private IPart parent;
	private boolean mirrored;
	private boolean backOnly;
	private float fsize;

	private HumanoidPart(float fsize) {
		parent = ROOT;
		this.fsize = fsize;
	}

	private HumanoidPart(float fsize, boolean m, boolean bonly) {
		mirrored = m;
		backOnly = bonly;
		this.fsize = fsize;
	}

	private HumanoidPart(IPart p, float fsize) {
		parent = p;
		this.fsize = fsize;
	}

	private HumanoidPart(IPart p, float fsize, boolean m, boolean bonly) {
		parent = p;
		mirrored = m;
		backOnly = bonly;
		this.fsize = fsize;
	}

	@Override
	public IPart parentSlot() {
		return parent;
	}

	@Override
	public boolean mirrored() {
		return mirrored;
	}

	@Override
	public boolean backOnly() {
		return backOnly;
	}

	@Override
	public float fractionalSize() {
		return fsize;
	}

}
