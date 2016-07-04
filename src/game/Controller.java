/**
 * 
 */
package game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;

/**
 *
 * Class to manage user input and output
 * 
 * allowed to modify: Game
 * modified by: none (user input only)
 */
public class Controller implements MouseMotionListener {
	private final Display window;
	private final List<GameObj> objList;
	private final Game game;
	private Cursor cursor;
	
	Controller(List<GameObj> list, Display frame, Game game, Cursor cursor) {
		this.objList = list;
		this.window = frame;
		this.game = game;
		this.cursor = cursor;
		window.addMouseMotionListener(this);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		cursor.mouseX = e.getX();
		cursor.mouseY = e.getY();
		// TODO Auto-generated method stub
	}
}
