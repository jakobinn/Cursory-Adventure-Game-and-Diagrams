/**
 * 
 */
package game;

import java.awt.Color;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * allowed to modify: none
 * modified by: none
 * reads objectList to display the graphics
 */
public class Display extends JPanel {

	private final Image image;
	private final List<GameObj> objectList;
	private Cursor cursorDisplay;
	// width and height for the display image
	//TODO make these non-constant
	static int IMAGE_WIDTH = 1000;
	static int IMAGE_HEIGHT = 708;
	// graphics object used to draw to image
	Graphics graphics;
	int i = 0;
	Image bg;
	
	Display(List<GameObj> objList, Cursor cursorDisplay) {
		this.objectList = objList;
		this.cursorDisplay = cursorDisplay;
		image = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
		graphics = image.getGraphics();
	    // * paint the image all white for its initial display
		graphics.setColor(new Color(0,0,0));
		graphics.fillRect(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);	
		bg = Toolkit.getDefaultToolkit().createImage("images/bg3.jpg");
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("images/fin.png").getImage(),new Point(10,20), null));
	}

	Display(List<GameObj> objList) throws IOException {
				  
	    int x=1+(int)(Math.random()*1000);//FIXME the width and height depends on the bg picture
		int y=1+(int)(Math.random()*708);//FIXME
		this.objectList = objList;
		bg = Toolkit.getDefaultToolkit().createImage("images/bg3.jpg");
		image = new BufferedImage(100, 100, 100);
		Graphics graphics = image.getGraphics();			
	}

	
	// function called every game tick to redraw the image and all objects with current values
	public void updateImage () {
		//graphics.setColor(new Color(255,255,255));
		//graphics.fillRect(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);	
		graphics.drawImage(bg, 0, 0, IMAGE_WIDTH, IMAGE_HEIGHT, this);
		
		// draw each object in the list
		ListIterator<GameObj> it = objectList.listIterator();
		while(it.hasNext()){	
			//go through objectList and draw it
			it.next().draw(graphics, this);
		}
		
		
		repaint();
		
	}

	
	
    @Override
    /*
     * Used here to render the full image to display on the screen (for each frame)
     */
    public void paintComponent( Graphics graphics )
    {
        super.paintComponent(graphics);
		graphics.drawImage(image, 0, 0, this);
    }
    
}
