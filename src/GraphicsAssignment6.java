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
		g.setColor(new Color(241, 222, 179));
		g.fillOval(x, y, 450, 500);

		// Eyes
		g.setColor(Color.black);
		g.drawOval(x + 80, y + 100, 100, 100);
		g.drawOval(x + 270, y + 100, 100, 100);

		// Pupils
		g.fillOval(x + 90, y + 110, 50, 50);
		g.fillOval(x + 300, y + 150, 50, 50);

		// Eyebrows
		g.drawArc(x + 80, y + 80, 100, 50, 20, 130);
		g.drawArc(x + 270, y + 80, 100, 50, 20, 130);

		// Nose
		g.drawOval(x + 150, y + 220, 150, 100);
		g.fillOval(x + 160, y + 250, 50, 50);
		g.fillOval(x + 240, y + 250, 50, 50);

		// Mouth
		g.fillArc(x + 125, y + 270, 200, 150, 180, 180);

		// Teeth
		g.setColor(Color.white);
		g.fill3DRect(x + 220, y + 345, 40, 40, true);
		g.fill3DRect(x + 180, y + 345, 40, 40, true);

		// Hat
		g.setColor(Color.red);
		g.fillPolygon(new int[]{x, x + 225, x + 450}, new int[]{y + 50, y - 100, y + 50}, 3);
		g.fillRect(x, y, 450, 50);
		
		// Clears resources
		g.dispose();
	}
}
