package enigma2D;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GUI {
	
	public static int ReflectorWIDTH = 100;
	public static int ReflectorHEIGHT = 500;
	public static int ReflectorX = 20;
	public static int ReflectorY = 125;
	
	public static int RotorWIDTH = 180;
	public static int RotorHEIGHT = 500;
	public static int LeftRotorX = 180;
	public static int MiddleRotorX = LeftRotorX + 240;
	public static int RightRotorX = MiddleRotorX + 240;
	public static int RotorY = 125;
		
	public void tick(){
		
	}
	
	public void render(Graphics g){

		g.setColor(new Color(190, 211, 229)); 						// Background of Reflector
		g.fillRect(ReflectorX, ReflectorY, ReflectorWIDTH, ReflectorHEIGHT);
		g.setColor(Color.BLACK); 									// Border
		g.drawRect(ReflectorX, ReflectorY, ReflectorWIDTH, ReflectorHEIGHT);
		g.setColor(Color.BLACK); 									// Inside Border
		g.drawRect(ReflectorX, ReflectorY, (ReflectorWIDTH / 3) * 2, ReflectorHEIGHT);
		
		g.setColor(new Color(190, 211, 229)); 						// Background of LEFT Rotor
		g.fillRect(LeftRotorX, RotorY, RotorWIDTH, RotorHEIGHT);
		g.setColor(Color.BLACK); 									// Border
		g.drawRect(LeftRotorX, RotorY, RotorWIDTH, RotorHEIGHT);
		g.setColor(Color.BLACK); 									// Inside Border
		g.drawRect(230, RotorY, 80, RotorHEIGHT);
		
		g.setColor(new Color(190, 211, 229));						// Background of MIDDLE Rotor
		g.fillRect(MiddleRotorX, RotorY, RotorWIDTH, RotorHEIGHT);
		g.setColor(Color.BLACK); 									// Border
		g.drawRect(MiddleRotorX, RotorY, RotorWIDTH, RotorHEIGHT);
		g.setColor(Color.BLACK); 									// Inside Border
		g.drawRect(470, RotorY, 80, RotorHEIGHT);
		
		g.setColor(new Color(190, 211, 229)); 						// Background of RIGHT Rotor
		g.fillRect(RightRotorX, RotorY, RotorWIDTH, RotorHEIGHT);
		g.setColor(Color.BLACK); 									// Border
		g.drawRect(RightRotorX, RotorY, RotorWIDTH, RotorHEIGHT);
		g.setColor(Color.BLACK); 									// Inside Border
		g.drawRect(710, RotorY, 80, RotorHEIGHT);
		
//		g.setColor(Color.BLACK);
//		g.setFont(new Font("Courier", Font.BOLD,12));
//		g.drawString("Rotor", 30, 30);
	}
}
