package enigma2D;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GUI {
	
	public static int ReflectorWIDTH = 120;
	public static int ReflectorHEIGHT = 500;
	public static int ReflectorX = 50;
	public static int ReflectorY = 125;
	
	public static int RotorWIDTH = 180;
	public static int RotorHEIGHT = 500;
	public static int LeftRotorX = 210;
	public static int MiddleRotorX = LeftRotorX + 220;
	public static int RightRotorX = MiddleRotorX + 220;
	public static int RotorY = 125;
	
	public static int PlugboardWIDTH = 100;
	public static int PlugboardHEIGHT = 500;
	public static int PlugboardX = 870;
	public static int PlugboardY = 125;
		
	public void tick(){
		
	}
	
	public void render(Graphics g){

		g.setColor(new Color(237, 237, 237)); 						// Background of Reflector
		g.fillRect(ReflectorX, ReflectorY, ReflectorWIDTH, ReflectorHEIGHT);
		g.setColor(Color.BLACK); 									// Border
		g.drawRect(ReflectorX, ReflectorY, ReflectorWIDTH, ReflectorHEIGHT);
		g.setColor(Color.BLACK); 									// Inside Border
		g.drawRect(ReflectorX, ReflectorY, (ReflectorWIDTH - 50), ReflectorHEIGHT);
		
		g.setColor(new Color(237, 237, 237)); 						// Background of LEFT Rotor
		g.fillRect(LeftRotorX, RotorY, RotorWIDTH, RotorHEIGHT);
		g.setColor(Color.BLACK); 									// Border
		g.drawRect(LeftRotorX, RotorY, RotorWIDTH, RotorHEIGHT);
		g.setColor(Color.BLACK); 									// Inside Border
		g.drawRect(LeftRotorX + 50, RotorY, RotorWIDTH - 100, RotorHEIGHT);
		
		g.setColor(new Color(237, 237, 237));						// Background of MIDDLE Rotor
		g.fillRect(MiddleRotorX, RotorY, RotorWIDTH, RotorHEIGHT);
		g.setColor(Color.BLACK); 									// Border
		g.drawRect(MiddleRotorX, RotorY, RotorWIDTH, RotorHEIGHT);
		g.setColor(Color.BLACK); 									// Inside Border
		g.drawRect(MiddleRotorX + 50, RotorY, RotorWIDTH - 100, RotorHEIGHT);
		
		g.setColor(new Color(237, 237, 237)); 						// Background of RIGHT Rotor
		g.fillRect(RightRotorX, RotorY, RotorWIDTH, RotorHEIGHT);
		g.setColor(Color.BLACK); 									// Border
		g.drawRect(RightRotorX, RotorY, RotorWIDTH, RotorHEIGHT);
		g.setColor(Color.BLACK); 									// Inside Border
		g.drawRect(RightRotorX + 50, RotorY, RotorWIDTH - 100, RotorHEIGHT);
		
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
}
