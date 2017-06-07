package enigma2D;

import java.awt.Color;

import enigma.EnigmaI;

public class ColorTheme {
	
	public static final int CLASSIC = 0;
	public static final int COOL = 1;
	public static final int MODERN = 2;
	public static final int WARM = 3;
	
	public static Color backgroundColor;
	public static Color letterColor;
	public static Color partColor;
	public static Color selectedAColor;
	public static Color selectedBColor;
	public static Color lineColor;
	
	public static int currentTheme;
	
	public static void changeColorTheme(int theme){
		currentTheme = theme;
		
		if(theme == CLASSIC){
			backgroundColor = Color.WHITE;
			letterColor = new Color(247, 247, 247);
			partColor = new Color(237, 237, 237);
			selectedAColor = Color.RED;
			selectedBColor = Color.GREEN;
			lineColor = Color.GRAY;
		}
		if(theme == COOL){
			backgroundColor = new Color(244, 244, 244);
			letterColor = new Color(220, 208, 192);
			partColor = new Color(210, 198, 182);
			selectedAColor = new Color(192, 178, 131);
			selectedBColor = new Color(192, 178, 131);
			lineColor = Color.GRAY;
		}
//		if(theme == MODERN){
//			backgroundColor = new Color();
//			letterColor = new Color();
//			partColor = new Color();
//			selectedAColor = new Color();
//			selectedBColor = new Color();
//			lineColor = new Color();
//		}
		if(theme == WARM){
			backgroundColor = new Color(86, 86, 86);
			letterColor = new Color(215, 206, 199);
			partColor = new Color(205, 196, 189);
			selectedAColor = new Color(118, 50, 63);
			selectedBColor = new Color(118, 50, 63);
			lineColor = new Color(192, 159, 128);
		}
	}

	public static int getColorTheme() {
		return currentTheme;
	}
	
}
