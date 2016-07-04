/**
 * 
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 * Game object that acts as an obstacle for the cursor
 *
 */
public class Wall extends GameObj {
	double x;
	double y;
	double w;
	double h;
	double delta;

	Wall(double posx, double posy, double width, double height) {
		x = posx;
		y = posy;
		w = width;
		h = height;
	}
	
	@Override
	void draw(Graphics g, JPanel obs) {
		Color color = new Color(30, 70, 80);
		g.setColor(color);
		g.fillRect((int)x, (int)y, (int)w, (int)h);
	}
	
	
	@Override
	boolean isCollision(Cursor cursor){
		return cursor.mouseX >= x && cursor.mouseY >= y && cursor.mouseX <= x + w && cursor.mouseY <= y + h;
	}
	
	@Override
	void onTick(double delta) {
		this.delta = delta;
	}
	
	@Override
	boolean onCollision(Game game) {
		//game.setGameState(GameState.GAME_READY);
		game.reloadLevel();
		return true;
	}
	
}
