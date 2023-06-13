/* Created by: Hanz Nathan Po
 * Date created: Sept 29, 2022
 * Last updated: June 12, 2023
 * Description: Cover page of a fictional book named Harry Potter and the Java Runtime Error, using the Graphics class
 */

// Package imports
import java.awt.*;
import javax.swing.JFrame;

// Definition of first class, inherits from Canvas
public class GraphicsAssignment1 extends Canvas {

	// Definitions
	int bookXPosition; // X position used as a reference point for all shapes used for the book cover. Makes moving the book cover easier if needed.
	int bookYPosition; // Y position used as a reference point for all shapes used for the book cover. Makes moving the book cover easier if needed.
	Graphics2D g2; // Graphics2D instance, used to enable text antialiasing
	RenderingHints rh; // RenderingHints, used to change rendering settings

	// Constructor
	public GraphicsAssignment1(String title) {
		JFrame frame = new JFrame(title); // Creates new JFrame instance
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Allows JFrame to be closed
		frame.setSize(600, 800); // Sets dimensions of JFrame
		frame.setVisible(true); // Allows JFrame to be visible
		frame.add(this); // Adds this instance of Canvas to the JFrame
	}
	
	// Init method, used to initalize variables
	public void init() {
		// Initializes book cover position
		bookXPosition = 100;
		bookYPosition = 80;

		// Sets antialiasing settings
		rh = new RenderingHints(
	             RenderingHints.KEY_TEXT_ANTIALIASING,
	             RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	}
	
	// Program entry point
	public static void main(String[] args) {
		// Creates new instance of GraphicsAssignment1, a child class of Canvas
		GraphicsAssignment1 graphics1 = new GraphicsAssignment1("Java Book Title Page");
		// Calls method that initializes variables
		graphics1.init();
	}
	
	// Method that draws to the Canvas
	public void paint (Graphics g) {
		// Enables text antialiasing when available
		g2 = (Graphics2D) g;
	    g2.setRenderingHints(rh);
		
		// Book cover
		g.setColor(Color.getHSBColor(0.9f, 1.0f, 0.2f));
		g.fillRect(bookXPosition, bookYPosition, 400, 600);
		
		// Author
		g.setFont(new Font("Times New Roman", Font.PLAIN, 42));
		g.setColor(Color.white);
		g.drawString("Hanz Po", bookXPosition + 120, bookYPosition + 50);
		
		// Title
		g.setFont(new Font("Curlz MT", Font.BOLD, 64));
		g.drawString("Harry Potter", bookXPosition + 40, bookYPosition + 120);
		
		g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		g.drawString("and the", bookXPosition + 175, bookYPosition + 150);
		g.drawString("Java Runtime Error" , bookXPosition + 130, bookYPosition + 170);
		
		// Head
		g.setColor(Color.getHSBColor(0.08f, 0.53f, 0.74f));
		g.fillOval(bookXPosition + 180, bookYPosition + 250, 40, 40);
		
		// Hat
		g.setColor(Color.red);
		g.fillRect(bookXPosition + 180, bookYPosition + 250, 40, 10);
		g.fillPolygon(new int[] {bookXPosition + 185, bookXPosition + 200, bookXPosition + 215}, new int[] {bookYPosition + 250, bookYPosition + 220, bookYPosition + 250}, 3);
		
		// Clothes
		g.setColor(Color.darkGray);
		g.fillRect(bookXPosition + 175, bookYPosition + 290, 50, 100);
		g.fillRect(bookXPosition + 175, bookYPosition + 390, 20, 100);
		g.fillRect(bookXPosition + 205, bookYPosition + 390, 20, 100);
		
		// Arms
		g.fillRect(bookXPosition + 110, bookYPosition + 295, 190, 20);

		// Clears resources
		g.dispose();
	} // End of paint method
} // End of GraphicsAssignment1 class
