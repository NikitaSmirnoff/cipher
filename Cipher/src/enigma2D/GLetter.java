package enigma2D;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import enigma.EnigmaI;

public class GLetter extends GameObject{
	
	public static final int LEFT = 0;
	public static final int MIDDLE = 1;
	public static final int RIGHT = 2;
	public static final int REFLECTOR = 3;
	public static final int PLUGBOARD = 4;
	
	public int x;
	public int y;
	public int side;
	public int part;
	public String letter;
	public boolean result = false;
	public boolean position = false;
	public Handler handler;
	public EnigmaI enigma;
	public Color resultColor;
	
	public GLetter(int x, int y, int side, int part, ID id, String letter, Handler handler, EnigmaI enigma){
		super(x, y, id);
		this.x = x;
		this.y = y;
		this.side = side;
		this.part = part;
		this.letter = letter;
		this.handler = handler;
		this.enigma = enigma;
	}
	
	public void tick(){
		if(this.part == PLUGBOARD){
			if(this.side == RIGHT){
				if(enigma.getInput().equals(letter)){
					result = true;
					resultColor = Color.RED;
				} else {
					if(enigma.getResultOfPlugboardBack().equals(letter)){
						result = true;
						resultColor = Color.GREEN;
					} else {
						result = false;
					}
				}
				
			}
			if(this.side == LEFT){
				if(enigma.getResultOfPlugboard().equals(letter)){
					result = true;
					resultColor = Color.RED;
				} else {
					if(enigma.getInputOfPlugboardBack().equals(letter)){
						result = true;
						resultColor = Color.GREEN;
					} else {
						result = false;
					}
				}
				
			}
		}
		
		if(this.part == LEFT || this.part == MIDDLE || this.part == RIGHT){
			if(this.side == RIGHT){
				if(enigma.getRotors(this.part).getRotorSetting().equals(letter)){
					position = true;
				} else {
					position = false;
				}
				if(this.part == RIGHT){
					if(enigma.getInputOfRotorRight().equals(letter)){
						result = true;
						resultColor = Color.RED;
					} else {
						if(enigma.getResultOfRotorRightBack().equals(letter)){
							result = true;
							resultColor = Color.GREEN;
						} else {
							result = false;
						}
					}
				}
				if(this.part == MIDDLE){
					if(enigma.getInputOfRotorMiddle().equals(letter)){
						result = true;
						resultColor = Color.RED;
					} else {
						if(enigma.getResultOfRotorMiddleBack().equals(letter)){
							result = true;
							resultColor = Color.GREEN;
						} else {
							result = false;
						}
					}
				}
				if(this.part == LEFT){
					if(enigma.getInputOfRotorLeft().equals(letter)){
						result = true;
						resultColor = Color.RED;
					} else {
						if(enigma.getResultOfRotorLeftBack().equals(letter)){
							result = true;
							resultColor = Color.GREEN;
						} else {
							result = false;
						}
					}
				}
			}
			
			if(this.side == LEFT){
				if(this.part == RIGHT){
					if(enigma.getResultOfRotorRight().equals(letter)){
						result = true;
						resultColor = Color.RED;
					} else {
						if(enigma.getInputOfRotorRightBack().equals(letter)){
							result = true;
							resultColor = Color.GREEN;
						} else {
							result = false;
						}
					}
				}
				if(this.part == MIDDLE){
					if(enigma.getResultOfRotorMiddle().equals(letter)){
						result = true;
						resultColor = Color.RED;
					} else {
						if(enigma.getInputOfRotorMiddleBack().equals(letter)){
							result = true;
							resultColor = Color.GREEN;
						} else {
							result = false;
						}
					}
				}
				if(this.part == LEFT){
					if(enigma.getResultOfRotorLeft().equals(letter)){
						result = true;
						resultColor = Color.RED;
					} else {
						if(enigma.getInputOfRotorLeftBack().equals(letter)){
							result = true;
							resultColor = Color.GREEN;
						} else {
							result = false;
						}
					}
				}
			}
		}
		
		if(this.part == REFLECTOR){
			if(this.side == RIGHT){
				if(enigma.getInputOfReflector().equals(letter)){
					result = true;
					resultColor = Color.RED;
				} else {
					if(enigma.getResultOfReflector().equals(letter)){
						result = true;
						resultColor = Color.GREEN;
					} else {
						result = false;
					}
				}
			}
		}
	}
	
	public void render(Graphics g){
		
		if(result){
			g.setColor(resultColor); 									// Background if the letter is a part of the encryption
			g.fillRect(this.x, this.y, GUI.getLetterBoxWIDTH(), GUI.getRotorHEIGHT() / 26);
		} else {
			if(position){
				g.setColor(new Color(207, 207, 207)); 					// Background if the letter is the rotor's current position
				g.fillRect(this.x, this.y, GUI.getLetterBoxWIDTH(), GUI.getRotorHEIGHT() / 26);
			} else {
				g.setColor(new Color(247, 247, 247)); 					// Background
				g.fillRect(this.x, this.y, GUI.getLetterBoxWIDTH(), GUI.getRotorHEIGHT() / 26);
			}
		}
		
		g.setColor(Color.BLACK); 									// Border
		g.drawRect(this.x, this.y, GUI.getLetterBoxWIDTH(), GUI.getRotorHEIGHT() / 26);
		g.setColor(Color.BLACK);									// Letter
		g.setFont(new Font("Courier", Font.BOLD,12));
		if(this.side == LEFT){
			g.drawString(this.letter, this.x + ((GUI.getLetterBoxWIDTH() / 10) * 7), this.y + (GUI.getRotorHEIGHT() / 32));
		}
		if(this.side == RIGHT){
			g.drawString(this.letter, this.x + ((GUI.getLetterBoxWIDTH() / 10) * 2), this.y + (GUI.getRotorHEIGHT() / 32));
		}
		
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
