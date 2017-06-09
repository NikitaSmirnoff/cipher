package enigma2D;

import java.awt.Color;

import enigma.EnigmaI;

public class ColorTheme {
	
	public static final int CLASSIC = 0;
	public static final int COOL = 1;
	public static final int PEPE = 2;
	public static final int RUSTIC = 3;
	
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
			partColor = new Color(230, 218, 202);
			selectedAColor = new Color(162, 128, 91);
			selectedBColor = new Color(162, 128, 91);
			lineColor = Color.GRAY;
		}
		if(theme == PEPE){
			backgroundColor = new Color(100, 134, 105);
			letterColor = new Color(148, 189, 147);
			partColor = new Color(175, 213, 170);
			selectedAColor = new Color(89, 140, 124);
			selectedBColor = new Color(89, 140, 124);
			lineColor = new Color(58, 90, 64);
		}
		if(theme == RUSTIC){
			backgroundColor = new Color(222, 189, 158);
			letterColor = new Color(215, 206, 199);
			partColor = new Color(225, 216, 209);
			selectedAColor = new Color(148, 80, 93);
			selectedBColor = new Color(148, 80, 93);
			lineColor = new Color(86, 86, 86);
		}
	}

	public static int getColorTheme() {
		return currentTheme;
	}
	
}
