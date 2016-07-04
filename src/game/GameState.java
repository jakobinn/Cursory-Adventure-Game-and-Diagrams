package game;

// code references http://stackoverflow.com/questions/8108980/java-using-enum-with-switch-statement

/**
  * 
  * Enum passed among classes to determine behavior within certain states of the game
  */
public enum GameState {
	GAME_INIT(1),
	GAME_PAUSED(2),
	GAME_READY(3),
	GAME_ACTIVE(4);
	
	private int value;
	private GameState(int v) {
		this.value = v;
	}
	public int getValue() {
		return value;
	}
}
