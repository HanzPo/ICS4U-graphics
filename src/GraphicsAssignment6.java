/* Created by: Hanz Nathan Po
 * Date created: Sept 29, 2022
 * Last updated: June 12, 2023
 * Description: Funny face, created using the Graphics Class
 */

// Package imports
import java.awt.*;
import javax.swing.JFrame;

// Definition of sixth class, inherits from Canvas
public class GraphicsAssignment6 extends Canvas {

	Graphics2D g2; // Graphics2D instance, used to enable text antialiasing
	RenderingHints rh; // RenderingHints, used to change rendering settings

	int x; // X position to anchor face to
	int y; // Y position to anchor face to

	// Constructor
	public GraphicsAssignment6(String title) {
		JFrame frame = new JFrame(title); // Creates new JFrame instance
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Allows JFrame to be closed
		frame.setSize(800, 800); // Sets dimensions of JFrame
		frame.setVisible(true); // Allows JFrame to be visible
		frame.add(this); // Adds this instance of Canvas to the JFrame
	}

	public void init() {
		// Initialize face position
		x = 150;
		y = 150;
	}

	public static void main(String[] args) {
		// Creates new instance of GraphicsAssignment6, a child class of Canvas
		GraphicsAssignment6 graphics6 = new GraphicsAssignment6("Funny Face");
		// Calls method that initializes variables
		graphics6.init();
	}


	public void paint (Graphics g) {
		// Enables anti-aliasing on text when possible
		g2 = (Graphics2D)g;
		rh = new RenderingHints(
				RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2.setRenderingHints(rh);

		// TITLE
		g.setFont(new Font("Times New Roman", Font.ITALIC + Font.BOLD, 36));
		g.drawString("~*~ FuNnY FaCe ~*~", 40, 40);

		// Head shape
		g.drawRect(x, y, 450, 500);
	}
}
