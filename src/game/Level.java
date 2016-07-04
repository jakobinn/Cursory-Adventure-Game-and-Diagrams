/**
 * 
 */
package game;

import java.util.List;
import java.util.ListIterator;

/**
 *
 */
public class Level {

	List<GameObj> objList;
	String filename;
	int collectCount;
	
	Level(List<GameObj> list) {
		objList = list;
		collectCount = 0;
	}
}
