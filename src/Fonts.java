

import java.awt.GraphicsEnvironment;


public class Fonts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

		for (int i = 0; i < fonts.length; i++) {
			System.out.println(fonts[i]);
		}
	}

}
