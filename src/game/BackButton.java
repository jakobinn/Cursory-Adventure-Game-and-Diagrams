package game;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

	public class BackButton extends GameObj {

		double x;
		double y;
		double w;
		double h;
		double size;
		boolean active;
		/**
		 * 
		 */
		public BackButton(double xpos, double ypos, double width, double height) {
			x = xpos;
			y = ypos;
			w = width;
			h = height;
			size = 50;
			active = true;
		}

		
		@Override
		void draw(Graphics g, JPanel obs) {
			//TODO make this draw an image instead of a rectangle
			if (active) {
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
			active = false;
			new LevelSelec();
			return true;
		}
		
		@Override
		protected void constructImage() {
			try {
			    File pathToFile = new File("images/backbutton.png");
			    img = ImageIO.read(pathToFile);
			} catch (IOException ex) {
			    ex.printStackTrace();
			}
		}
}
