/* Created by: Hanz Nathan Po
 * Date created: Sept 29, 2022
 * Last updated: Sept 29, 2022
 * Description: Simple program to test graphics in Java
 */

import java.awt.*;
import javax.swing.JFrame;

public class GraphicsAssignment6 extends Canvas {

	public GraphicsAssignment6(String title) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setVisible(true);
		frame.add(this);
	}

	public void init() {

	}

	public static void main(String[] args) {
		GraphicsAssignment6 graphics6 = new GraphicsAssignment6("Funny Face");
		graphics6.init();
	}


	public void paint (Graphics g) {
		// Enables anti-aliasing on text when possible
		Graphics2D g2 = (Graphics2D)g;
		RenderingHints rh = new RenderingHints(
				RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2.setRenderingHints(rh);

		g.setFont(new Font("Times New Roman", Font.ITALIC + Font.BOLD, 36));
		g.drawString("~*~ FuNnY FaCe ~*~", 40, 40);
	}
}
