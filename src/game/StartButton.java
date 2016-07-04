/**
 * 
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 */
public class StartButton extends GameObj {

	double x;
	double y;
	double w;
	double h;
	double size;
	boolean active;
	/**
	 * 
	 */
	public StartButton(double xpos, double ypos, double width, double height) {
		x = xpos;
		y = ypos;
		w = width;
		h = height;
		size = 60;
		active = true;
	}

	
	@Override
	void draw(Graphics g, JPanel obs) {
		//TODO make this draw an image instead of a rectangle
		if (active) {
//			Color color = new Color(150, 20, 20);
//			g.setColor(color);
//			g.fillRect((int)x, (int)y, (int)w, (int)h);
			g.drawImage(img, (int)x , (int)y, (int)size, (int)size, obs);
		}
	}
	
	@Override
	boolean isCollision(Cursor cursor){
		return cursor.mouseX >= x && cursor.mouseY >= y && cursor.mouseX <= x + w && cursor.mouseY <= y + h;
	}
	
	@Override
	boolean onCollision(Game game) {
		game.activate();
		// deactivate start button
		active = false;
		return true;
	}
	
	@Override
	protected void constructImage() {
		try {
		    File pathToFile = new File("images/startbutton.png");
		    img = ImageIO.read(pathToFile);
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
	}
}
