/* Created by: Hanz Nathan Po
* Date created: Sept 29, 2022
* Last updated: June 12, 2023
* Description: Program which generates random squares and circles on the user's screen, using the Graphics class
*/

// Package imports
import java.awt.*;
import javax.swing.JFrame;

// Definition of second class, inherits from Canvas
public class GraphicsAssignment2 extends Canvas {
	
	// Declarations
	int minSize; // Lower restriction of size of shape
	int maxSize; // Upper restriction of size of shape
	int shapeSize; // Actual size of shape
	int squareOrCircle; // Can only be 0 or 1, decides if shape is a square or circle
	int xLocation; // X location of current shape
	int yLocation; // Y location of current shape
	int red; // R value of current shape's colour
	int green; // G value of current shape's colour
	int blue; // B value of current shape's colour

	// Constructor
	public GraphicsAssignment2(String title) {
		JFrame frame = new JFrame(title); // Creates new JFrame instance
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Allows JFrame to be closed
		frame.setSize(1200, 800); // Sets dimensions of JFrame
		frame.setVisible(true); // Allows JFrame to be visible
		frame.add(this); // Adds this instance of Canvas to the JFrame
	}
	
	// Init method, used to initalize variables
	public void init() {
		// Initializes size restrictions for shape
		minSize = 20;
		maxSize = 80;
	}
	
	// Program entry point
	public static void main(String[] args) {
		// Creates new instance of GraphicsAssignment2, a child class of Canvas
		GraphicsAssignment2 graphics2 = new GraphicsAssignment2("Random Squares and Circles");
		// Calls method that initializes variables
		graphics2.init();
	}
	
	// Method that draws to the Canvas
	public void paint (Graphics g) {
		
		// This first loop can be changed depending on how many times the program should repeat
		for (int i = 0; i < 2; i++) {
			// Repeat until 50 shapes are drawn
			for (int j = 0; j < 50; j++) {
				
				// Randomly chooses size of shape, within provided constraints
				shapeSize = (int) (minSize + ((maxSize - minSize) * Math.random()));
				// Randomly chooses if the shape will be a circle or square
				squareOrCircle = (int) Math.round(Math.random());
				// Randomly finds x and y location on the screen for the shape
				xLocation = (int) (Math.random() * (this.getWidth() - shapeSize));
				yLocation = (int) (Math.random() * (this.getHeight() - shapeSize));
				
				// Randomly chooses a colour
				red = (int) (Math.random() * 256);
				green = (int) (Math.random() * 256);
				blue = (int) (Math.random() * 256);
				
				g.setColor(new Color(red, green, blue));
				
				// Draw shape based on randomly generated information
				if (squareOrCircle == 0) {
					g.fillRect(xLocation, yLocation, shapeSize, shapeSize);
				}
				else {
					g.fillOval(xLocation, yLocation, shapeSize, shapeSize);
				}
				
				// Sleep so that the draw effect is visible to the user
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			// Clear the screen but only on the first loop
			if (i == 0) {
				g.clearRect(0, 0, this.getWidth(), this.getHeight());
			}
		}
		
	} // End of paint method
} // End of GraphicsAssignment2 class
