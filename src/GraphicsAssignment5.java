/* Created by: Hanz Nathan Po
 * Date created: Sept 29, 2022
 * Last updated: Sept 29, 2022
 * Description: Simple program to test graphics in Java
 */

import java.awt.*;
import javax.swing.JFrame;

public class GraphicsAssignment5 extends Canvas {
	
	public GraphicsAssignment5(String title) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 800);
		frame.setVisible(true);
		frame.add(this);
	}

	public void init() {

	}

	public static void main(String[] args) {
		GraphicsAssignment5 graphics5 = new GraphicsAssignment5("Random Crosses");
		graphics5.init();
	}


	public void paint(Graphics g) {
		
		int sizeScaler = 5;
		
		for (int i = 0; i < 10; i++) {
			int x = (int) (Math.random()*(this.getWidth()));
			int y = (int) (Math.random( )*(this.getHeight()));
			int red = (int) (Math.random()*256);
			int green = (int) (Math.random()*256);
			int blue = (int) (Math.random()*256);
			g.setColor(new Color(red, green, blue));

			int[] xPt = {x, x - (5 * sizeScaler), x - (5 * sizeScaler), x - (10 * sizeScaler), x - (10 * sizeScaler), x - (15 * sizeScaler), x - (15 * sizeScaler), x - (10 * sizeScaler), x - (10 * sizeScaler), x - (5 * sizeScaler), x - (5 * sizeScaler), x, x};
			int[] yPt = {y, y, y - (5 * sizeScaler), y - (5 * sizeScaler), y, y, y + (5 * sizeScaler), y + (5 * sizeScaler), y + (15 * sizeScaler), y + (15 * sizeScaler), y + (5 * sizeScaler), y + (5 * sizeScaler), y};
			g.fillPolygon(xPt, yPt, xPt.length);
		}
	}
}
