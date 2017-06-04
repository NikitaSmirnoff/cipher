package enigma2D;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GUI {
	
	public static int ReflectorWIDTH = 120;
	public static int ReflectorHEIGHT = 494;
	public static int ReflectorX = 50;
	public static int ReflectorY = 40;
	
	public static int RotorWIDTH = 180;
	public static int RotorHEIGHT = 494;
	public static int LeftRotorX = 210;
	public static int MiddleRotorX = LeftRotorX + 220;
	public static int RightRotorX = MiddleRotorX + 220;
	public static int RotorY = 40;
	
	public static int PlugboardWIDTH = 100;
	public static int PlugboardHEIGHT = 494;
	public static int PlugboardX = 870;
	public static int PlugboardY = 40;
	
	public static int LetterBoxWIDTH = 50;
		
	public void tick(){
		
	}
	
	public void render(Graphics g){

		g.setColor(new Color(237, 237, 237)); 						// Background of Reflector
		g.fillRect(ReflectorX, ReflectorY, ReflectorWIDTH, ReflectorHEIGHT);
		g.setColor(Color.BLACK); 									// Border
		g.drawRect(ReflectorX, ReflectorY, ReflectorWIDTH, ReflectorHEIGHT);
		g.setColor(Color.BLACK); 									// Inside Border
		g.drawRect(ReflectorX, ReflectorY, (ReflectorWIDTH - LetterBoxWIDTH), ReflectorHEIGHT);
		
		g.setColor(new Color(237, 237, 237)); 						// Background of LEFT Rotor
		g.fillRect(LeftRotorX, RotorY, RotorWIDTH, RotorHEIGHT);
		g.setColor(Color.BLACK); 									// Border
		g.drawRect(LeftRotorX, RotorY, RotorWIDTH, RotorHEIGHT);
		g.setColor(Color.BLACK); 									// Inside Border
		g.drawRect(LeftRotorX + LetterBoxWIDTH, RotorY, RotorWIDTH - (LetterBoxWIDTH * 2), RotorHEIGHT);
		
		g.setColor(new Color(237, 237, 237));						// Background of MIDDLE Rotor
		g.fillRect(MiddleRotorX, RotorY, RotorWIDTH, RotorHEIGHT);
		g.setColor(Color.BLACK); 									// Border
		g.drawRect(MiddleRotorX, RotorY, RotorWIDTH, RotorHEIGHT);
		g.setColor(Color.BLACK); 									// Inside Border
		g.drawRect(MiddleRotorX + LetterBoxWIDTH, RotorY, RotorWIDTH - (LetterBoxWIDTH * 2), RotorHEIGHT);
		
		g.setColor(new Color(237, 237, 237)); 						// Background of RIGHT Rotor
		g.fillRect(RightRotorX, RotorY, RotorWIDTH, RotorHEIGHT);
		g.setColor(Color.BLACK); 									// Border
		g.drawRect(RightRotorX, RotorY, RotorWIDTH, RotorHEIGHT);
		g.setColor(Color.BLACK); 									// Inside Border
		g.drawRect(RightRotorX + LetterBoxWIDTH, RotorY, RotorWIDTH - (LetterBoxWIDTH * 2), RotorHEIGHT);
		
		g.setColor(new Color(237, 237, 237)); 						// Background of Plugboard
		g.fillRect(PlugboardX, PlugboardY, PlugboardWIDTH, PlugboardHEIGHT);
		g.setColor(Color.BLACK); 									// Border
		g.drawRect(PlugboardX, PlugboardY, PlugboardWIDTH, PlugboardHEIGHT);
		g.setColor(Color.BLACK); 									// Inside Border
		g.drawRect(PlugboardX, PlugboardY, (PlugboardWIDTH / 2), PlugboardHEIGHT);
		
//		g.setColor(Color.BLACK);
//		g.setFont(new Font("Courier", Font.BOLD,12));
//		g.drawString("Rotor", 30, 30);
	}

	public static int getReflectorWIDTH() {
		return ReflectorWIDTH;
	}

	public static void setReflectorWIDTH(int reflectorWIDTH) {
		ReflectorWIDTH = reflectorWIDTH;
	}

	public static int getReflectorHEIGHT() {
		return ReflectorHEIGHT;
	}

	public static void setReflectorHEIGHT(int reflectorHEIGHT) {
		ReflectorHEIGHT = reflectorHEIGHT;
	}

	public static int getReflectorX() {
		return ReflectorX;
	}

	public static void setReflectorX(int reflectorX) {
		ReflectorX = reflectorX;
	}

	public static int getReflectorY() {
		return ReflectorY;
	}

	public static void setReflectorY(int reflectorY) {
		ReflectorY = reflectorY;
	}

	public static int getRotorWIDTH() {
		return RotorWIDTH;
	}

	public static void setRotorWIDTH(int rotorWIDTH) {
		RotorWIDTH = rotorWIDTH;
	}

	public static int getRotorHEIGHT() {
		return RotorHEIGHT;
	}

	public static void setRotorHEIGHT(int rotorHEIGHT) {
		RotorHEIGHT = rotorHEIGHT;
	}

	public static int getLeftRotorX() {
		return LeftRotorX;
	}

	public static void setLeftRotorX(int leftRotorX) {
		LeftRotorX = leftRotorX;
	}

	public static int getMiddleRotorX() {
		return MiddleRotorX;
	}

	public static void setMiddleRotorX(int middleRotorX) {
		MiddleRotorX = middleRotorX;
	}

	public static int getRightRotorX() {
		return RightRotorX;
	}

	public static void setRightRotorX(int rightRotorX) {
		RightRotorX = rightRotorX;
	}

	public static int getRotorY() {
		return RotorY;
	}

	public static void setRotorY(int rotorY) {
		RotorY = rotorY;
	}

	public static int getPlugboardWIDTH() {
		return PlugboardWIDTH;
	}

	public static void setPlugboardWIDTH(int plugboardWIDTH) {
		PlugboardWIDTH = plugboardWIDTH;
	}

	public static int getPlugboardHEIGHT() {
		return PlugboardHEIGHT;
	}

	public static void setPlugboardHEIGHT(int plugboardHEIGHT) {
		PlugboardHEIGHT = plugboardHEIGHT;
	}

	public static int getPlugboardX() {
		return PlugboardX;
	}

	public static void setPlugboardX(int plugboardX) {
		PlugboardX = plugboardX;
	}

	public static int getPlugboardY() {
		return PlugboardY;
	}

	public static void setPlugboardY(int plugboardY) {
		PlugboardY = plugboardY;
	}

	public static int getLetterBoxWIDTH() {
		return LetterBoxWIDTH;
	}

	public static void setLetterBoxWIDTH(int letterBoxWIDTH) {
		LetterBoxWIDTH = letterBoxWIDTH;
	}
	
}
