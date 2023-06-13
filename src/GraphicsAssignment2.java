/* Created by: Hanz Nathan Po
 * Date created: Sept 29, 2022
 * Last updated: Sept 29, 2022
 * Description: Simple program to test graphics in Java
 */

import java.awt.*;
import javax.swing.JFrame;

public class GraphicsAssignment2 extends Canvas {

	String tNR = "Times New Roman";

	public GraphicsAssignment2(String title) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 800);
		frame.setVisible(true);
		frame.add(this);
	}
	
	public void init() {
		
	}
	
	public static void main(String[] args) {
		GraphicsAssignment2 graphics2 = new GraphicsAssignment2("Random Squares and Circles");
		graphics2.init();
	}
	

	public void paint (Graphics g) {
		
		int minSize = 20;
		int maxSize = 80;
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 50; j++) {
				
				int shapeSize = (int) (minSize + ((maxSize - minSize) * Math.random()));
				int squareOrCircle = (int) Math.round(Math.random());
				int xLocation = (int) (Math.random() * (this.getWidth() - shapeSize));
				int yLocation = (int) (Math.random() * (this.getHeight() - shapeSize));
				
				int red = (int) (Math.random() * 256);
				int green = (int) (Math.random() * 256);
				int blue = (int) (Math.random() * 256);
				
				g.setColor(new Color(red, green, blue));
				
				if (squareOrCircle == 0) {
					g.fillRect(xLocation, yLocation, shapeSize, shapeSize);
				}
				else {
					g.fillOval(xLocation, yLocation, shapeSize, shapeSize);
				}
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			if (i == 0) {
				g.clearRect(0, 0, this.getWidth(), this.getHeight());
			}
		}
		
	}
}
