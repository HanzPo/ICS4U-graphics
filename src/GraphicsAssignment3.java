/* Created by: Hanz Nathan Po
 * Date created: Sept 29, 2022
 * Last updated: Sept 29, 2022
 * Description: Simple program to test graphics in Java
 */

import java.awt.*;
import javax.swing.JFrame;

public class GraphicsAssignment3 extends Canvas {

	public GraphicsAssignment3(String title) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setVisible(true);
		frame.add(this);
	}
	
	public void init() {
		
	}
	
	public static void main(String[] args) {
		GraphicsAssignment3 graphics3 = new GraphicsAssignment3("Market Share of Industry X");
		graphics3.init();
	}
	

	public void paint (Graphics g) {
		
		// Enables anti-aliasing on text when possible
		Graphics2D g2 = (Graphics2D)g;
		RenderingHints rh = new RenderingHints(
	             RenderingHints.KEY_TEXT_ANTIALIASING,
	             RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	    g2.setRenderingHints(rh);
		
		// Variables used to easily change the position of multiple shapes at once
		int anchorPointX = 180;
		int anchorPointY = 50;
		int pieX = anchorPointX + 5;
		int pieY = anchorPointY + 80;
		int pieSize = 400;
		
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
		
		
		g.dispose();
	}
}
