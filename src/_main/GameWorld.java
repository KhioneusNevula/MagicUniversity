package _main;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

import character.ICharacter;
import magic.ISpell;
import map.IMap;
import outer_world.IOuterWorld;

/**
 * The game world in its entirety
 * 
 * @author borah
 *
 */
public class GameWorld {

	private IMap university;
	private IOuterWorld outerWorld;
	private Map<UUID, ICharacter> characters;

	public GameWorld() {

	}

}
