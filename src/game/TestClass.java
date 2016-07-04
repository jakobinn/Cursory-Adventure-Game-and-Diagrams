package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

// class purely for learning about and testing properties of images
// does NOT implement any game functionality at all
// copied from http://www.java2s.com/Code/JavaAPI/java.awt/GraphicsdrawImageImageimgintxintyImageObserverob.htm
public class TestClass extends JPanel {

 public void paint(Graphics g) {
   Image img = createImage();
   Image img2 = createImage();
   g.drawImage(img, 20,20,this);
   g.drawImage(img2, 60, 60, this);
 }

 public static void main(String[] args) {
   JFrame frame = new JFrame();
   frame.getContentPane().add(new TestClass());

   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.setSize(200, 200);
   frame.setVisible(true);
 }
 
 private Image createImage(){
   BufferedImage bufferedImage = new BufferedImage(200,200,BufferedImage.TYPE_INT_RGB);
   Graphics g = bufferedImage.getGraphics();
   g.drawString("www.java2s.com", 20,20);
   
   return bufferedImage;
 }
}
