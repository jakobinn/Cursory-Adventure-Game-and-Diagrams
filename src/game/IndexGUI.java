package game;

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

  
public class IndexGUI{  
   
 private JFrame frame = new JFrame("Cursory Adventure");
  
 private JPanel imagePanel;  
  
 private ImageIcon background;    
  
 /**
  *  Class that initializes and displays a menu
  */
 public IndexGUI() {  
  background = new ImageIcon("images/bg1.jpg");// background picture
  JLabel label = new JLabel(background);// put the picture in a label  
  // set the window the same size as the picture  
  label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());  
  // transfer the window to JPanel, otherwise cannot use setOpaque() to make the window transparent  
  imagePanel = (JPanel) frame.getContentPane();  
  imagePanel.setOpaque(false);  
  // the arrangement controller of the window is BorderLayout  
  imagePanel.setLayout(new FlowLayout()); 
  
  frame.getLayeredPane().setLayout(null);  
  // make the background picture in the bottom level of the window  
  frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  frame.setSize(background.getIconWidth(), background.getIconHeight());  
  frame.setResizable(false);  
  frame.setVisible(true); 
  
  frame.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("images/fin.png").getImage(),new Point(10,20), null));
  
  // about button
  //imagePanel.add(new JButton("Start", new ImageIcon(ImageView.class.getResource("10.png"))));
  imagePanel.setLayout(null);
  JButton enter = new JButton();  
  frame.add(enter);//add button to the frame
  enter.setIcon(new ImageIcon("images/enter.png"));// set bg for the button
  enter.setOpaque(false);  
  enter.setContentAreaFilled(false);  
  enter.setHideActionText(false);
  enter.setMargin(new Insets(0, 0, 0, 0)); 
  enter.setBounds(300, 290, 400, 400);
  enter.setFocusPainted(false);  
  enter.setBorderPainted(false);  
  enter.setBorder(null); 
  enter.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
    	  try{
    		  Thread.sleep(100);
    	  }catch(InterruptedException e1) {
		e1.printStackTrace();
	}
    	  new Settings();//enter the settings selection interface 
    	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	  frame.dispose();
    	  frame.setVisible(false);
      }
  }); 
 }
 
 // tests the standalone menu
 public static void main(String[] args) {  
	 	new IndexGUI();  
	 }
 
}  
