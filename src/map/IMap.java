package map;

import java.util.Collection;

import avatar.IAvatar;
import magic.ISpell;

/**
 * Interface representing the map map itself
 * 
 * @author borah
 *
 */
public interface IMap {

	/**
	 * Return all things in this map
	 * 
	 * @return
	 */
	public Collection<IAvatar> getAvatars();

	/**
	 * Return all spells that are currently tied to the map
	 * 
	 * @return
	 */
	public Collection<ISpell> getMapSpells();

	/**
	 * Return the weather state
	 * 
	 * @return
	 */
	public IWeatherState getWeather();

	/**
	 * Whether the given tile is exposed to the weather or not
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	public boolean isExposed(int x, int y, int z);

	/**
	 * Return the 2D table of what blocks form the wall-layer of this z layer.
	 * 
	 * @param zLayer
	 * @return
	 */
	public IMaterial[] getBlockTable(int zLayer);

	/**
	 * Return the 2D table of what blocks form the floor-layer of this z layer.
	 * 
	 * @param zLayer
	 * @return
	 */
	public IMaterial[] getFloorTable(int zLayer);

	/**
	 * Return the 2D table of what avatars inhabit each spot in this z layer. A
	 * jagged list, since multiple avatars can sometimes inhabit a spot (e.g. a
	 * chair and a person)
	 * 
	 * @param zLayer
	 * @return
	 */
	public IAvatar[][] getAvatarTable(int zLayer);
}
