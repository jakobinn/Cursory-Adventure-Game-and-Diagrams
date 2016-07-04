package game;

import java.awt.Color;
import java.awt.FlowLayout;  
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
//for button operation
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;  
import javax.swing.JButton;  
import javax.swing.JFrame;  
import javax.swing.JLabel;
import javax.swing.JPanel;

//import GUI.ModeSeleGUI;
 

/**
 * 
 * Class to display options on menu (used by IndexGUI)
 *
 */
public class Settings{  
   
 private JFrame frame = new JFrame("Cursory Adventure");
  
 private JPanel imagePanel;  
  
 private ImageIcon background;    
  
 public Settings() {  
  background = new ImageIcon("images/bg2.jpg");// background picture
  JLabel label = new JLabel(background);// put the picture in a label  
  // set the window the same size as the picture  
  label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());  
  // transfer the window to JPanel, otherwise cannot use setOpaque() to make the window transparent  
  imagePanel = (JPanel) frame.getContentPane();  
  imagePanel.setOpaque(false);  
  // the arrangement controller of the window is BorderLayout  
  imagePanel.setLayout(new FlowLayout()); 
  
  frame.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("images/fin.png").getImage(),new Point(10,20), null));
  
  
  // about button
  imagePanel.setLayout(null);
  JButton level = new JButton("New Game");
  level.setForeground(Color.BLACK);
  frame.add(level);//add button to the frame
  level.setOpaque(false);  
  level.setContentAreaFilled(false);  
  level.setHideActionText(false);
  level.setMargin(new Insets(0, 0, 0, 0)); 
  level.setBounds(455, 208, 100, 100);
  level.setFocusPainted(false);  
  level.setBorderPainted(false);  
  level.setBorder(null); 
  
  JButton mode = new JButton("Tutorial");
  mode.setForeground(Color.BLACK);
  frame.add(mode);//add button to the frame
  mode.setOpaque(false);  
  mode.setContentAreaFilled(false);  
  mode.setHideActionText(false);
  mode.setMargin(new Insets(0, 0, 0, 0)); 
  mode.setBounds(455, 330, 100, 100);
  mode.setFocusPainted(false);  
  mode.setBorderPainted(false);  
  mode.setBorder(null);
  
  /*JButton set = new JButton("Settings");
  set.setForeground(Color.WHITE);
  frame.add(set);//add button to the frame 
  set.setOpaque(false);  
  set.setContentAreaFilled(false);  
  set.setHideActionText(false);
  set.setMargin(new Insets(0, 0, 0, 0)); 
  set.setBounds(308, 305, 400, 400);
  set.setFocusPainted(false);  
  set.setBorderPainted(false);  
  set.setBorder(null);*/
  
  imagePanel.setLayout(null);
  JButton exit = new JButton("Exit");
  exit.setForeground(Color.BLACK);
  frame.add(exit);//add button to the frame
  exit.setOpaque(false);  
  exit.setContentAreaFilled(false);  
  exit.setHideActionText(false);
  exit.setMargin(new Insets(0, 0, 0, 0)); 
  exit.setBounds(455, 453, 100, 100);
  //exit.setBounds(308, 400, 400, 400);
  exit.setFocusPainted(false);  
  exit.setBorderPainted(false);  
  exit.setBorder(null); 
  
  level.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
    	  new LevelSelec();
    	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	  frame.dispose();
    	  frame.setVisible(false);
      }
  });
  
  mode.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
    	  new Tutorial();
    	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	  frame.dispose();
    	  frame.setVisible(false);
      }
  });
  
  exit.addActionListener(new ActionListener() {       
    @Override  
    public void actionPerformed(ActionEvent e) {  
        // TODO Auto-generated method stub  
        //System.out.println("Button Exit did it. Need to store the game state.");  
        System.exit(-1);  
    }  
});  
  
  frame.getLayeredPane().setLayout(null);  
  // make the background picture in the bottom level of the window  
  frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  frame.setSize(background.getIconWidth(), background.getIconHeight());  
  frame.setResizable(false);  
  frame.setVisible(true); 
  
}
 
 public static void main(String[] args) {  
	  new Settings();  
	 }
 
}  
