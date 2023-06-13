/* Created by: Hanz Nathan Po
* Date created: Sept 29, 2022
* Last updated: June 12, 2023
* Description: Simple bar graph with 3D bars, created using the Graphics class
*/

// Package imports
import java.awt.*;
import java.awt.geom.AffineTransform;
import javax.swing.JFrame;

// Definition of fourth class, inherits from Canvas
public class GraphicsAssignment4 extends Canvas {
	
	// Variable definitions
	int barWidth; // Width of the bars
	int barHeight; // Height of the bars
	int bottomY; // Y position where the bars start
	int startX; // X position where the bars start
	int barSpacing; // Spacing between the bars
	int scaleSpacing; // Space between the y scale and the first bar
	
	// Value limits
	int upperLimit; // Highest value that any of the bars can go + 1
	
	
	// Offsets for the labels
	int xLabelOffsetX; // Distance of the x labels from the border along the x axis
	int xLabelOffsetY; // Distance of the x labels from the border along the y axis
	int yLabelOffsetX; // Distance from the y border and the labels along the x axis
	int yLabelOffsetY; // Distance from the y border and the labels along the y axis
	
	
	int[] barValues; // Values of all the bars
	
	String[] xLabels; // Labels for all of the bars (should be extended along with barValues)
	
	int[][] barColours; // Colours to be used for each of the bars (MUST BE EXTENDED ALONG WITH barValues)
	
	Graphics2D g2; // Graphics2D instance, used to enable text antialiasing
	RenderingHints rh; // RenderingHints, used to change rendering settings

	public GraphicsAssignment4(String title) {
		JFrame frame = new JFrame(title); // Creates new JFrame instance
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Allows JFrame to be closed
		frame.setSize(450, 500); // Sets dimensions of JFrame
		frame.setVisible(true); // Allows JFrame to be visible
		frame.add(this); // Adds this instance of Canvas to the JFrame
	}
	
	public void init() {
		// Initialize all variables defined above
		barWidth = 30;
		barHeight = 30;
		bottomY = 320;
		startX = 100;
		barSpacing = 70;
		scaleSpacing = 40;
		
		upperLimit = 10;
		
		xLabelOffsetX = 60;
		xLabelOffsetY = 45;
		yLabelOffsetX = -30;
		yLabelOffsetY = 2;
		
		barValues = new int[]{2, 5, 7, 6};
		xLabels = new String[]{"Raptors", "Warriors", "Nets", "76ers"};
		
		barColours = new int[][]{ { 83, 238,  50},
		{255,  45,  24},
		{ 50,   0, 200},
		{234, 234,   0} };
	}
	
	// Program entry point
	public static void main(String[] args) {
		// Creates new instance of GraphicsAssignment4, a child class of Canvas
		GraphicsAssignment4 graphics4 = new GraphicsAssignment4("Bar Graph");
		// Calls method that initializes variables
		graphics4.init();
	}
	
	// Method that draws to the Canvas
	public void paint (Graphics g) {
		// Enables anti-aliasing on text when possible
		g2 = (Graphics2D)g;
		rh = new RenderingHints(
		RenderingHints.KEY_TEXT_ANTIALIASING,
		RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2.setRenderingHints(rh);
		
		g.setColor(new Color(165, 209, 221));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		// y scale and horizontal lines
		int z = 0;
		do {
			g.setColor(Color.white);
			g.setFont(new Font("Times New Roman", Font.PLAIN, 24));
			g.drawString(String.valueOf(z), startX - scaleSpacing + yLabelOffsetX, bottomY - (barHeight * z) + barHeight + yLabelOffsetY);
			g.drawLine(startX - scaleSpacing, bottomY - (barHeight * z), startX + (barSpacing * (barValues.length - 1)) + barWidth + scaleSpacing, bottomY - (barHeight * z));
			z++;
		} while (z < upperLimit);
		
		// Iterates through every item in barValues and creates bars
		for (int i = 0; i < barValues.length; i++) {
			// Sets colour based on the current bar in barValues and looks for the matching colour in barColours
			// Iterates through each value in the bar and creates a part of the bar until it reaches the correct value
			for (int j = 0; j < barValues[i]; j++) {
				g.setColor(new Color(barColours[i][0], barColours[i][1], barColours[i][2]));
				// Draws the actual bar
				g.fill3DRect(startX + (i * barSpacing), bottomY - (barHeight * j), barWidth, barHeight, true);
			}
		}
		
		// Draw edge borders
		g.setColor(Color.black);
		g.drawLine(startX - scaleSpacing, bottomY + barHeight, startX + (barSpacing * (barValues.length - 1)) + barWidth + scaleSpacing, bottomY + barHeight);
		g.drawLine(startX - scaleSpacing, bottomY + barHeight, startX - scaleSpacing, bottomY - (upperLimit * barHeight) + barHeight);
		
		
		// LABELS
		// Team labels
		g.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		for (int i = 0; i < xLabels.length; i++) {
			g.drawString(xLabels[i], scaleSpacing + (i * barSpacing) + xLabelOffsetX, bottomY + xLabelOffsetY);
		}
		
		// Title
		g.setFont(new Font("Times New Roman", Font.BOLD, 24));
		g.drawString("Favourite Basketball Teams", 80, 35);
		
		// X label
		g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		g.drawString("Basketball teams", 150, 390);
		
		// Y label
		AffineTransform affineTransform = new AffineTransform();
		affineTransform.rotate(Math.toRadians(-90), 0, 0);
		Font rotatedFont = g.getFont().deriveFont(affineTransform);
		g2.setFont(rotatedFont);
		g2.drawString("Number of people", 20, 300);
		
		// Clear resources
		g.dispose();
		
	} // End of paint method
} // End of GraphicsAssignment4 class
