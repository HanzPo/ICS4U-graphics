/* Created by: Hanz Nathan Po
 * Date created: Sept 29, 2022
 * Last updated: June 12, 2023
 * Description: Basic pie chart, created using the Graphics class
 */

 // Package imports
import java.awt.*;
import javax.swing.JFrame;

// Definition of third class, inherits from Canvas
public class GraphicsAssignment3 extends Canvas {

	// Variable definitions
	int anchorPointX; // X coordinate that all shapes are set relative to
	int anchorPointY; // Y coordinate that all shapes are set relative to
	int pieX; // X coordinate that all pie shapes are set relative to
	int pieY; // Y coordinate that all pie shapes are set relative to
	int pieSize; // Stores size of the pie

	Graphics2D g2; // Graphics2D instance, used to enable text antialiasing
	RenderingHints rh; // RenderingHints, used to change rendering settings

	// Constructor
	public GraphicsAssignment3(String title) {
		JFrame frame = new JFrame(title); // Creates new JFrame instance
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Allows JFrame to be closed
		frame.setSize(800, 800); // Sets dimensions of JFrame
		frame.setVisible(true); // Allows JFrame to be visible
		frame.add(this); // Adds this instance of Canvas to the JFrame
	}
	
	// Init method, used to initalize variables
	public void init() {
		// Variables used to easily change the position and size of the pie chart all at once
		anchorPointX = 180;
		anchorPointY = 50;
		pieX = anchorPointX + 5;
		pieY = anchorPointY + 80;
		pieSize = 400;
	}
	
	// Program entry point
	public static void main(String[] args) {
		// Creates new instance of GraphicsAssignment3, a child class of Canvas
		GraphicsAssignment3 graphics3 = new GraphicsAssignment3("Market Share of Industry X");
		// Calls method that initializes variables
		graphics3.init();
	}
	
	// Method that draws to the Canvas
	public void paint (Graphics g) {
		
		// Enables anti-aliasing on text when possible
		g2 = (Graphics2D)g;
		rh = new RenderingHints(
	             RenderingHints.KEY_TEXT_ANTIALIASING,
	             RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	    g2.setRenderingHints(rh);
		
		// TITLE
		g.setFont(new Font("Times New Roman", Font.BOLD, 24));
		g.drawString("Market Shares of Companies in Industry X", anchorPointX, anchorPointY);
		
		// LABELS
		g.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		g.drawString("Company A (10%)", anchorPointX + 450, anchorPointY + 200);
		g.drawString("Company B (20%)", anchorPointX + 320, anchorPointY + 80);
		g.drawString("Company C (30%)", anchorPointX - 100, anchorPointY + 250);
		g.drawString("Company D (40%)", anchorPointX + 250, anchorPointY + 520);
		
		
		// Bounding box of pie, used for testing
		// g.drawRect(pieX, pieY, pieSize, pieSize);
		
		
		// ACTUAL PIE
		g.setColor(Color.green); // Sets colour to green
		g.fillArc(pieX, pieY, pieSize, pieSize, 0, 36);
		g.setColor(Color.red); // Sets colour to red
		g.fillArc(pieX, pieY, pieSize, pieSize, 36, 72);
		g.setColor(Color.blue); // Sets colour to blue
		g.fillArc(pieX, pieY, pieSize, pieSize, 108, 108);
		g.setColor(Color.yellow); // Sets colour to yellow
		g.fillArc(pieX, pieY, pieSize, pieSize, 216, 144);
		
		// Clears resources
		g.dispose();
	} // End of paint method
} // End of GraphicsAssignment3 class
