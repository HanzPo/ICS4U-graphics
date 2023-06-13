/* Created by: Hanz Nathan Po
 * Date created: Sept 29, 2022
 * Last updated: June 12, 2023
 * Description: Simple program that generates crosses at a random location with a random colour, using the Graphics class
 */

// Package imports
import java.awt.*;
import javax.swing.JFrame;

// Definition of fifth class, inherits from Canvas
public class GraphicsAssignment5 extends Canvas {
	
	// Variable declarations
	int sizeScaler; // Variable that allows shape to be scaled
	int x; // X location of current shape
	int y; // Y location of current shape
	int red; // R value of current shape's colour
	int green; // G value of current shape's colour
	int blue; // B value of current shape's colour

	// Stores vertices of polygon
	int[] xPt;
	int[] yPt;

	// Constructor
	public GraphicsAssignment5(String title) {
		JFrame frame = new JFrame(title); // Creates new JFrame instance
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Allows JFrame to be closed
		frame.setSize(1200, 800); // Sets dimensions of JFrame
		frame.setVisible(true); // Allows JFrame to be visible
		frame.add(this); // Adds this instance of Canvas to the JFrame
	}

	// Init method, used to initalize variables
	public void init() {
		sizeScaler = 5; // Set size multiplier to 5
	}

	// Program entry point
	public static void main(String[] args) {
		// Creates new instance of GraphicsAssignment5, a child class of Canvas
		GraphicsAssignment5 graphics5 = new GraphicsAssignment5("Random Crosses");
		// Calls method that initializes variables
		graphics5.init();
	}

	// Method that draws to the Canvas
	public void paint(Graphics g) {
		
		// Loops 10 times to draw 10 shapes
		for (int i = 0; i < 10; i++) {
			// Randomly generate position of current shape within the dimensions of the Canvas
			x = (int) (Math.random()*(this.getWidth() - (15 * sizeScaler)));
			y = (int) (Math.random()*(this.getHeight() - (10 * sizeScaler)));

			// Randomly generate colour 
			red = (int) (Math.random()*256);
			green = (int) (Math.random()*256);
			blue = (int) (Math.random()*256);
			g.setColor(new Color(red, green, blue));

			// Generate coordinates of shape based on randomly generated position and size scaler
			xPt = new int[]{x, x - (5 * sizeScaler), x - (5 * sizeScaler), x - (10 * sizeScaler), x - (10 * sizeScaler), x - (15 * sizeScaler), x - (15 * sizeScaler), x - (10 * sizeScaler), x - (10 * sizeScaler), x - (5 * sizeScaler), x - (5 * sizeScaler), x, x};
			yPt = new int[]{y, y, y - (5 * sizeScaler), y - (5 * sizeScaler), y, y, y + (5 * sizeScaler), y + (5 * sizeScaler), y + (15 * sizeScaler), y + (15 * sizeScaler), y + (5 * sizeScaler), y + (5 * sizeScaler), y};

			// Draw actual shape
			g.fillPolygon(xPt, yPt, xPt.length);
		}

		// Clears resources
		g.dispose();
	} // End of paint method
} // End of GraphicsAssignment5 class
