package enigma2D;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {

	public static int HEALTH = 100;
	private int greenValue;
		
	public void tick(){
		HEALTH = Game.clamp(HEALTH, 0, 100);
		greenValue = Game.clamp(greenValue, 0, 255);
		
		greenValue = HEALTH * 2;
		
	}
	
	public void render(Graphics g){
		g.setColor(Color.GRAY); // Background of Health bar
		g.fillRect(15, 15, 200, 32);
		
		g.setColor(new Color(75, greenValue, 0)); // Health meter
		g.fillRect(15, 15, HEALTH * 2, 32);
		
		g.setColor(new Color(0, 153, 76)); // Border of Health bar
		g.drawRect(15, 15, 200, 32);
		
		g.setColor(Color.BLACK); // Health bar text
		g.setFont(new Font("Courier", Font.BOLD,12));
		g.drawString("Health", 30, 30);
		g.drawString(HEALTH + " / 100", 30, 42);
	}
}
