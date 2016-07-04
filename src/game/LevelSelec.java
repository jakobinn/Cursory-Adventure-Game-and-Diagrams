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


/**
 * 
 * Level Select menu used in IndexGUI
 *
 */
public class LevelSelec { 
   
 private JFrame frame = new JFrame("Cursory Adventure");
  
 private JPanel imagePanel;  
  
 private ImageIcon background;    
  
 public LevelSelec() {  
  background = new ImageIcon("images/levelselec.jpg");// background picture
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
  JButton level = new JButton("Level 1");
  level.setForeground(Color.BLACK);
  frame.add(level);//add button to the frame
  level.setOpaque(false);  
  level.setContentAreaFilled(false);  
  level.setHideActionText(false);
  level.setMargin(new Insets(0, 0, 0, 0)); 
  level.setBounds(280, 180, 150, 150);
  level.setFocusPainted(false);  
  level.setBorderPainted(false);  
  level.setBorder(null); 

  
  imagePanel.setLayout(null);
  JButton back = new JButton("Back");
  back.setForeground(Color.BLACK);
  frame.add(back);//add button to the frame
  back.setOpaque(false);  
  back.setContentAreaFilled(false);  
  back.setHideActionText(false);
  back.setMargin(new Insets(0, 0, 0, 0)); 
  back.setBounds(312, 430, 400, 400);
  back.setFocusPainted(false);  
  back.setBorderPainted(false);  
  back.setBorder(null); 
  
  level.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
    	  //new App();
    	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	  frame.dispose();
    	  frame.setVisible(false);
      }
  });
  
//  level2.addActionListener(new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//    	  //new Level2();
//    	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    	  frame.dispose();
//    	  frame.setVisible(false);
//      }
//  });
//  
//  level3.addActionListener(new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//    	  //new Level3();
//    	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    	  frame.dispose();
//    	  frame.setVisible(false);
//      }
//  });
  
  back.addActionListener(new ActionListener() {       
    @Override  
    public void actionPerformed(ActionEvent e) {  
    	new Settings();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	  	frame.dispose();
  	  	frame.setVisible(false);  
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
	  new LevelSelec();  
	 }
 
}  
