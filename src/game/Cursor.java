/**
 * 
 */
package game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * Class that is updated to hold the current mouse coordinates.
 * 
 * Modified by: Controller
 *
 */

public class Cursor {
	/**
	 * 
	 */
	int test;
	public int mouseX;
	public int mouseY;
	
	Cursor(int mouseX, int mouseY) {
		this.mouseX = mouseX;
		this.mouseY = mouseY;
		//super.typeStr = "Cursor";
		//test = a;
	}

}
