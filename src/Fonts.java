/* Created by: Hanz Nathan Po
 * Date created: Sept 29, 2022
 * Last updated: June 12, 2023
 * Description: Helper class that prints out all available fonts
 */

import java.awt.GraphicsEnvironment;


public class Fonts {

	public static void main(String[] args) {

		String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

		for (int i = 0; i < fonts.length; i++) {
			System.out.println(fonts[i]);
		}
	}

}
