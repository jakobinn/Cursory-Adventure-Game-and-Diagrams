/**
 * 
 */
package game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 *
 */
public class MovingObject extends GameObj {

	double x;
	double y;
	double w;
	double h;
	double cursorX;
	double cursorY;
	boolean active;
	double delta;
	public Cursor cursor;
	/**
	 * 
	 */
	public MovingObject(double xpos, double ypos, double width, double height) {
		x = xpos;
		y = ypos;
		w = width;
		h = height;
		active = true;
	}

	
	@Override
	void draw(Graphics g, JPanel obs) {
		//TODO make this draw an image instead of a rectangle
		if (active) {
			Color color = new Color(0, 0, 0);
			g.setColor(color);
			g.fillRect((int)x, (int)y, (int)w, (int)h);	
		}
	}
	
	
	@Override
	boolean isCollision(Cursor cursor){
		this.cursorX = cursor.mouseX;
		this.cursorY = cursor.mouseY;
		return cursor.mouseX >= x && cursor.mouseY >= y && cursor.mouseX <= x + w && cursor.mouseY <= y + h;
	}
	
	@Override
	void onTick(double delta) {
		if(cursorY > y) y = y+2;
		if(cursorY < y) y = y-2;
		if(cursorX > x) x = x+2;
		if(cursorX < x) x = x-2;
		this.delta = delta;
	}
	
	@Override
	boolean onCollision(Game game) {
		//game.activate();
		game.reloadLevel();
		return true;
		// deactivate start button
		//active = false;
		//return true;
	}
}
