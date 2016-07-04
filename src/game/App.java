/**
 * 
 */
package game;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * main class to contain all objects
 *
 */
public class App extends JFrame {

	private final Display display;
	private final Controller input;
	private final Game game;
	private final List<GameObj> objList;
	private final IndexGUI menu;
	private Cursor cursor;
	// difference in time between ticks
	//public double delta;
	
	// display window
	public JPanel imagePanel;   
	private ImageIcon background; 

	
	// initialize the game state, display, and input structures
	App() {
		objList = new LinkedList<GameObj>();
		cursor = new Cursor(0,0);
		display = new Display(objList, cursor);
		game = new Game(objList, cursor, 0);
		input = new Controller(objList, display, game, cursor);
		
		
		
        setTitle( "Cursory Adventure" );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                      
        add(display, BorderLayout.CENTER);
        
        Dimension dimension = new Dimension(1000, 708);
        setSize( dimension  );
        setPreferredSize( dimension );
        setVisible( true );

        // initialize menu
        menu = new IndexGUI();

	}
	
	long lastLoopTime = System.nanoTime();
	final long OPTIMAL_TIME = 1000000000 / 60; //divide with the fps.

	// function to run the game state
	// receives signals to determine what state the game is in (pause, quit, etc.)
	void run() {
		// TODO initialize 
		while(true) {
			game.gameTick(0);
			display.updateImage();
			
		    //long timeNow = System.nanoTime();
		    //long updateTime = timeNow - lastLoopTime;
		    //lastLoopTime = timeNow;
		    //delta = updateTime / ((double)OPTIMAL_TIME);
		
			// sleep the thread to limit the frames per second
			try {
				Thread.sleep(30);
			}
			catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
	
	public double getTime(){
		return 0;
	}
	
	/**
	 * Entry point here.
	 * @param args unused
	 */
	public static void main(String[] args) {
		//IndexGUI indexgui = new IndexGUI();
		App app = new App();
		app.run();
		//new IndexGUI();
	}

}
