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
		public class ModeSeleGUI {
	   
	 private JFrame frame = new JFrame("Cursory Adventure");
	  
	 private JPanel imagePanel;  
	  
	 private ImageIcon background;    
	  
	 public void ModeSelec() {  
	  background = new ImageIcon("images/bg4.jpg");// background picture
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
	  level.setForeground(Color.WHITE);
	  frame.add(level);//add button to the frame
	  level.setOpaque(false);  
	  level.setContentAreaFilled(false);  
	  level.setHideActionText(false);
	  level.setMargin(new Insets(0, 0, 0, 0)); 
	  level.setBounds(150, 58, 400, 400);
	  level.setFocusPainted(false);  
	  level.setBorderPainted(false);  
	  level.setBorder(null); 
	  
	  JButton level2 = new JButton("Level 2");
	  level2.setForeground(Color.WHITE);
	  frame.add(level2);//add button to the frame
	  level2.setOpaque(false);  
	  level2.setContentAreaFilled(false);  
	  level2.setHideActionText(false);
	  level2.setMargin(new Insets(0, 0, 0, 0)); 
	  level2.setBounds(305, 58, 400, 400);
	  level2.setFocusPainted(false);  
	  level2.setBorderPainted(false);  
	  level2.setBorder(null);
	  
	  JButton level3 = new JButton("Level 3");
	  level3.setForeground(Color.WHITE);
	  frame.add(level3);//add button to the frame
	  level3.setOpaque(false);  
	  level3.setContentAreaFilled(false);  
	  level3.setHideActionText(false);
	  level3.setMargin(new Insets(0, 0, 0, 0)); 
	  level3.setBounds(460, 58, 400, 400);
	  level3.setFocusPainted(false);  
	  level3.setBorderPainted(false);  
	  level3.setBorder(null); 
	  
	  imagePanel.setLayout(null);
	  JButton back = new JButton("Back");
	  back.setForeground(Color.WHITE);
	  frame.add(back);//add button to the frame
	  back.setOpaque(false);  
	  back.setContentAreaFilled(false);  
	  back.setHideActionText(false);
	  back.setMargin(new Insets(0, 0, 0, 0)); 
	  back.setBounds(308, 305, 400, 400);
	  back.setFocusPainted(false);  
	  back.setBorderPainted(false);  
	  back.setBorder(null); 
	  
	  level.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	          //levelselection();
	    	  //new App();
	    	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	  frame.dispose();
	    	  frame.setVisible(false);
	      }
	  });
	  
	  level2.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	    	  //new Level2();
	    	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	  frame.dispose();
	    	  frame.setVisible(false);
	      }
	  });
	  
	  level3.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	    	  //new Level3();
	    	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	  frame.dispose();
	    	  frame.setVisible(false);
	      }
	  });
	  
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

