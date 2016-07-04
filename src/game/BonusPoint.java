package game;
import java.awt.Color;
import java.math.*;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BonusPoint extends GameObj {
	/**
	 * 
	 */
	/**
	 * 
	 */
	double x;
	double y;
	double size;
	public boolean isActive;

	BonusPoint(double posx, double posy) {
		x = posx;
		y = posy;
		size = 75;
		isActive = true;
		// construct image to be drawn
		//constructImage();
	}
	
	
	@Override
	void draw(Graphics g, JPanel obs) {
		if (isActive) {
			g.drawImage(img, (int)x , (int)y, (int)size, (int)size, obs);
			//g.setColor (Color.yellow);
		    //g.fill3DRect((int)x, (int)y, (int)size, (int)size, true);
		}
	}
	
	@Override
	boolean isCollision(Cursor cursor){
		return cursor.mouseX >= x && cursor.mouseY >= y && cursor.mouseX <= x + size && cursor.mouseY <= y + size;
	}

	@Override
	boolean onCollision(Game game) {
		if (game.getGameState() == GameState.GAME_ACTIVE) {
			Level lvl = game.getLevel();
			--lvl.collectCount;
			game.objList.remove(this);
			if (lvl.collectCount == 0) {
				game.setGameState(GameState.GAME_INIT);
				game.nextLevel();
			}
			return true;
		}
		else return false;
	}
	
	@Override
	void onLoad(Level level) {
		++level.collectCount;
	}
	
	@Override
	protected void constructImage() {
		String pattern = "apple" ;
		int randomNum = (int) (Math.random()*12);
				switch(randomNum){
				case 0: pattern = "apple";
				break;
//				case 1: pattern = "blueb";
//				break;
//				case 2: pattern = "bramble";
//				break;
				case 3: pattern = "ccn";
				break;
				case 4: pattern = "cherry";
				break;
//				case 5: pattern = "grape";
//				break;
				case 6: pattern = "guava";
				break;
				case 7: pattern = "kiwi";
				break;
				case 8: pattern = "lm";
				break;
//				case 9: pattern = "mango";
//				break;
				case 10: pattern = "mg";
				break;
				case 11: pattern = "orange";
				break;
//				case 12: pattern = "peach";
//				break;
//				case 13: pattern = "pear";
//				break;
//				case 14: pattern = "pome";
//				break;
				case 1: pattern = "strab";
				break;
				case 2: pattern = "sz";
				break;
				case 5: pattern = "wm";
				break;
				case 9: pattern = "yt";
				break;
			}
	
	try {
	    File pathToFile = new File("images/" + pattern + ".png");
	    img = ImageIO.read(pathToFile);
	} catch (IOException ex) {
	    ex.printStackTrace();
	}
		    
	}
	
}
