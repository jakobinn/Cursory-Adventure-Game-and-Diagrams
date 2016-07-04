 /**
 * 
 */
package game;

/**
 * @author Steven Cabral
 *
 * allowed to modify: none
 * modified by: Game, Controller
 * 
 * Class to contain list of objects shared among Display, Controller, and Game
 */
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;

import java.io.File;
import java.io.IOException;
import java.lang.Math;
import java.util.List;
 

public class ObjectList { 
		  
		 private JPanel imagePanel;  
		  
		 private ImageIcon background;	
	
		 public ObjectList() {  
		  
	  
	  // about button
	  imagePanel.setLayout(null);
	  final JButton cherry = new JButton();
	  cherry.setIcon(new ImageIcon("images/cherry.png"));// set bg for the button
	  cherry.setOpaque(false);  
	  cherry.setContentAreaFilled(false);  
	  cherry.setHideActionText(false);
	  cherry.setMargin(new Insets(0, 0, 0, 0)); 
	  cherry.setBounds(308, 58, 400, 400);
	  cherry.setFocusPainted(false);  
	  cherry.setBorderPainted(false);  
	  cherry.setBorder(null); 
	  
	  cherry.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	    	  cherry.setVisible(false);
	      }
	  });
	 
	  
	}
	 
	
	 public static void main(String[] args) {  
		  new Settings();  
		 }
	 
	}