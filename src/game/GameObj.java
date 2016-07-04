/**
 * 
 */
package game;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JPanel;

/**
 * @author Steven Cabral
 *
 */
public abstract class GameObj implements Serializable {
	Image img;

	GameObj() {
		constructImage();
	}
	
	// called by display to draw each individual object
	void draw(Graphics g, JPanel obs) {
		
	}

	void onTick(double delta) {
		
	}
	
	// called to check for collision for each individual object
	//TODO currently unimplemented
	boolean isCollision(Cursor cursor) {
		// TODO Auto-generated method stub
		return false;
	}
	
	// return value indicates whether iterations over the object list should terminate
	boolean onCollision(Game game) {
		return false;
	}
	
	void onLoad(Level level) {
		
	}
	
	// helper function to load in an image on object construction
	protected void constructImage() {
		img = null;
	}
	
	// serializer function
    private void writeObject(ObjectOutputStream os) throws IOException {
    	// don't attempt to serialize image
    	img = null;
    	os.defaultWriteObject();
    }
	
    // serializer function
    private void readObject(ObjectInputStream is) throws ClassNotFoundException, IOException {
    	is.defaultReadObject();
    	constructImage();
    }
    
}
