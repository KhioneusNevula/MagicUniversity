package map;

/**
 * Generalization of what materials a part may be nmade of
 * 
 * @author borah
 *
 */
public enum Material implements IMaterial {
	/** For "empty slots" and placeholder things */
	NOTHING, WOOD, METAL, PLANT, STONE, AIR, WATER, FIRE, FLESH, BONE, HORN, HAIR, FAT, FUR, CARTILAGE, EYE_FLUID,
	SHADOW, LIGHT, OTHER
}