package enigma2D;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class GLetter extends GameObject{
	
	public int x;
	public int y;
	public String letter;
	public boolean result = false;
	public Handler handler;
	
	public GLetter(int x, int y, ID id, String letter, Handler handler){
		super(x, y, id);
		this.x = x;
		this.y = y;
		this.letter = letter;
		this.handler = handler;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		
		if(result){
			g.setColor(new Color(207, 207, 207)); 						// Background if a result
			g.fillRect(this.x, this.y, GUI.getLetterBoxWIDTH(), GUI.getRotorHEIGHT() / 26);g.setColor(new Color(237, 237, 237)); 						// Background
		} else {
			g.setColor(new Color(237, 237, 237)); 						// Background
			g.fillRect(this.x, this.y, GUI.getLetterBoxWIDTH(), GUI.getRotorHEIGHT() / 26);
		}
		g.fillRect(this.x, this.y, GUI.getLetterBoxWIDTH(), GUI.getRotorHEIGHT() / 26);
		g.setColor(Color.BLACK); 									// Border
		g.drawRect(this.x, this.y, GUI.getLetterBoxWIDTH(), GUI.getRotorHEIGHT() / 26);
		g.setColor(Color.BLACK);									// Letter
		g.setFont(new Font("Courier", Font.BOLD,12));
		g.drawString(this.letter, this.x + ((GUI.getLetterBoxWIDTH() / 10) * 7), this.y + (GUI.getRotorHEIGHT() / 32));
		
	}
	
	public String getLetter(){
		return this.letter;
	}
	
	public void setLetter(String letter){
		this.letter = letter;
	}

	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
