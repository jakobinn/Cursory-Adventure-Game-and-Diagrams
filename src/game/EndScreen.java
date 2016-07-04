/**
 * 
 */
package game;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author Steven
 *
 */
public class EndScreen extends GameObj {

	private String imgName;

	public EndScreen(String filename) {
		imgName = filename;
	}

	@Override
	protected void constructImage() {
		imgName = "images/congradulation.jpg";
		try {
		    File pathToFile = new File(imgName);
		    img = ImageIO.read(pathToFile);
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
	}
	
	@Override
	void draw(Graphics g, JPanel obs) {
		g.drawImage(img, 0, 0, obs);
	}
	
}
