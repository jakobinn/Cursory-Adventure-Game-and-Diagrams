/**
 * 
 */
package game;

import java.util.List;
import java.util.ListIterator;

/**
 *
 * Class to run game logic
 * allowed to modify: ObjectList
 * modified by: Controller
 */

public class Game {

	// gamestate stores the state of the game (which affects how the game is running)
	private GameState gamestate;
	public final List<GameObj> objList;
	private final Cursor cursor;
	private LevelLoader loader;
	public static final int MAX_LEVEL = 3;
	private int currentLevel;
	public double delta;
	private Level level;
	
	Level getLevel() { return level; }
	void setLevel(Level l) { level = l; }
	
	Game(List<GameObj> list, Cursor cursor, double delta) {
		gamestate = GameState.GAME_INIT;
		currentLevel = 0;
		this.objList = list;
		this.cursor = cursor;
		this.delta = delta;
		loader = new LevelLoader(objList);
	}
	
	GameState getGameState() { return gamestate; }
	void setGameState(GameState newstate) { gamestate = newstate; }
	
	// this function runs a 'tick' of game logic - this function should be called every game loop iteration
	void gameTick(double delta) {
		ListIterator<GameObj> it = objList.listIterator();
		GameObj next;
		switch (gamestate) {
		case GAME_ACTIVE:
			// TODO this is where the game is actually running (so collision is active)
			while(it.hasNext()) {
				next = it.next();
				next.onTick(delta);
			}
			it = objList.listIterator();
			while(it.hasNext()) {
				next = it.next();
				if(next.isCollision(cursor)) {
					if (next.onCollision(this)) break;
				}
			}
			break;
		case GAME_INIT:
			if (currentLevel <= MAX_LEVEL) {
				// load the current level, replacing the previous level
				nextLevel();
			}
			else { // game complete
				objList.clear();
				EndScreen newbg = new EndScreen("images/congradulation.jpg");
				objList.add(newbg);
				gamestate = GameState.GAME_READY;
			}
			break;
		case GAME_PAUSED:
			// do nothing
			break;
		case GAME_READY:
			// wait for user to press the start button before the game itself begins
			// game should be paused, but still displayed (maybe moving?)
			it = objList.listIterator();
			while(it.hasNext()) {
				next = it.next();
				if((next instanceof StartButton) && next.isCollision(cursor)) {
					next.onCollision(this);
				}
			}
			break;
		default:
			break;
		}
	}
	
	// restarts a level
	void reloadLevel() {
		objList.clear();
		level = loader.loadLevel(level.filename);
		gamestate = GameState.GAME_READY;

		// make sure only appropriate objects display
		ListIterator<GameObj> it = objList.listIterator();
		while (it.hasNext()) {
			GameObj obj = it.next();
			if (obj instanceof BonusPoint) {
				((BonusPoint) obj).isActive = false;
			}
		}
	}
	
	// moves game to the next level
	void nextLevel() {
		++currentLevel;
		objList.clear();
		level = loader.loadLevel("levels/level" + currentLevel + ".level");
		
		// make sure only appropriate objects display
		ListIterator<GameObj> it = objList.listIterator();
		while (it.hasNext()) {
			GameObj obj = it.next();
			if (obj instanceof BonusPoint) {
				((BonusPoint) obj).isActive = false;
			}
		}
		
		if (level == null) {
			gameComplete();
		}
		else {
			gamestate = GameState.GAME_READY;
		}
	}

	// does all actions to set gamestate to active
	void activate() {
		ListIterator<GameObj> it = objList.listIterator();
		while (it.hasNext()) {
			GameObj obj = it.next();
			if (obj instanceof BonusPoint) {
				((BonusPoint) obj).isActive = true;
			}
		}
		gamestate = GameState.GAME_ACTIVE;
	}
	
	// does end of game behavior
	void gameComplete() {
		//TODO
	}
}
