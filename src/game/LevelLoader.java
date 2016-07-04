/**
 * 
 */
package game;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Steven Cabral
 *
 */
public class LevelLoader {

	static List<GameObj> objectList;

	List<GameObj> objList;
	public double delta;

	LevelLoader(List<GameObj> list) {
		objList = list;
	}

	/**
	 * Loads a level from the specified file into the list
	 * 
	 * @return Returns the filled list.
	 * 
	 */

	Level loadLevel(String filename) {
		Level retval = new Level(objList);
		FileInputStream fin;
		ObjectInputStream ois = null;
		GameObj curObj;
		try {
			fin = new FileInputStream(filename);
			ois = new ObjectInputStream(fin);
			while (true) {
				curObj = (GameObj) ois.readObject();
				objList.add(curObj);
				curObj.onLoad(retval);
			}
		} catch (EOFException e) {
			try {
				ois.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (Exception e) {
			//e.printStackTrace();
			return null; // level could not be loaded
		}
		retval.filename = filename;
		return retval;
	}

	/**
	 * Saves the level currently loaded into the specified file
	 */
	void saveLevel(String filename) {
		// used for reference:
		// http://www.mkyong.com/java/how-to-write-an-object-to-file-in-java/

		try {
			// initialize writer objects
			FileOutputStream fout = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fout);

			// iterate through to write to file
			ListIterator<GameObj> it = objList.listIterator();
			while (it.hasNext()) {
				oos.writeObject(it.next());
			}

			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Function used for testing the loader and creating levels
	 * 
	 * @param args unused
	 */

	/*Levels are currently prefixed in the main method, if more levels are added then they will be put into seperate folder*/
	public static void main(String[] args) {

		// initialize things
		List<GameObj> objectList = new LinkedList<GameObj>();
		LevelLoader loader = new LevelLoader(objectList);

		// place test objects into list
		objectList.add(new StartButton(480, 480, 30, 30));
//		objectList.add(new BackButton(900, 600, 30, 30));
		objectList.add(new BonusPoint(20,250));
		objectList.add(new BonusPoint(20, 460));
		objectList.add(new BonusPoint(200, 300));
		objectList.add(new BonusPoint(320, 100));
		objectList.add(new BonusPoint(450, 350));
		objectList.add(new BonusPoint(500, 160));
		objectList.add(new BonusPoint(720, 160));
		objectList.add(new BonusPoint(900, 70));
		objectList.add(new BonusPoint(900, 350));	
		objectList.add(new BonusPoint(800, 580));

		objectList.add(new Wall(0, 0, 10, 708));
		objectList.add(new Wall(0, 0, 1000, 10));
		objectList.add(new Wall(0, 676, 1000, 10));
		objectList.add(new Wall(990, 0, 10, 708));
//		objectList.add(new Wall(0, 663, 1000, 10));
//		objectList.add(new Wall(975, 0, 10, 708));
		
		objectList.add(new Wall(0, 400, 400, 10));
		objectList.add(new Wall(290, 100, 10, 300));
		objectList.add(new Wall(500, 150, 500, 10));
		objectList.add(new Wall(700, 150, 10, 300));
		objectList.add(new Wall(150, 550, 910, 10));
		
		objectList.add(new MovingObject(0, 0, 50, 50));	
		
		loader.saveLevel("levels/level1.level");
		
		objectList.clear();

		objectList.add(new StartButton(800, 605, 30, 30));
		objectList.add(new BonusPoint(50,20));
		
		objectList.add(new Wall(0, 0, 10, 708));
		objectList.add(new Wall(0, 0, 1000, 10));
		objectList.add(new Wall(0, 676, 1000, 10));
		objectList.add(new Wall(990, 0, 10, 708));
		objectList.add(new Wall(80, 585, 920, 10));
		objectList.add(new Wall(10, 500, 910, 10));
		objectList.add(new Wall(80, 400, 920, 10));
		objectList.add(new Wall(10, 300, 910, 10));
		objectList.add(new Wall(80, 200, 920, 10));
		objectList.add(new Wall(10, 100, 910, 10));
		objectList.add(new MovingObject(0, 0, 50, 50));	
		
		loader.saveLevel("levels/level2.level");		

		objectList.clear();
		objectList.add(new StartButton(900, 340, 30, 30));

		objectList.add(new BonusPoint(450,310));
		objectList.add(new BonusPoint(50,250));
		objectList.add(new BonusPoint(530,500));
		objectList.add(new BonusPoint(650,420));
		objectList.add(new BonusPoint(420,180));
		objectList.add(new BonusPoint(800,100));
		
		objectList.add(new Wall(0, 0, 10, 708));
		objectList.add(new Wall(0, 0, 1000, 10));
		objectList.add(new Wall(0, 676, 1000, 10));
		objectList.add(new Wall(990, 0, 10, 708));

		objectList.add(new Wall(10, 330, 120, 10));
		objectList.add(new Wall(130, 90, 10, 400));
		objectList.add(new Wall(130, 90, 240, 10));
		objectList.add(new Wall(130, 490, 240, 10));
		objectList.add(new Wall(120, 570, 720, 10));
		objectList.add(new Wall(840, 410, 10, 170));
		objectList.add(new Wall(750, 330, 240, 10));
		objectList.add(new Wall(660, 90, 240, 10));
		objectList.add(new Wall(900, 90, 10, 160));
		objectList.add(new Wall(250, 170, 650, 10));
		objectList.add(new Wall(250, 170, 10, 240));
		objectList.add(new Wall(500, 170, 10, 80));
		objectList.add(new Wall(500, 490, 10, 80));
		objectList.add(new Wall(750, 250, 10, 250));
		objectList.add(new Wall(130, 90, 10, 400));
		objectList.add(new Wall(370, 250, 10, 160));
		objectList.add(new Wall(370, 250, 240, 10));
		objectList.add(new Wall(370, 410, 380, 10));
		objectList.add(new Wall(500, 490, 260, 10));
		objectList.add(new Wall(610, 250, 10, 80));
		objectList.add(new MovingObject(0, 0, 50, 50));	
		objectList.add(new MovingObject(950, 0, 50, 50));
		
		loader.saveLevel("levels/level3.level");
		
		// now load it all back up into another list
		List<GameObj> testList = new LinkedList<GameObj>();
		LevelLoader emptyLoader = new LevelLoader(testList);
		emptyLoader.loadLevel("levels/level3.level");
		
	}

}
