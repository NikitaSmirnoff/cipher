package enigma;

import java.util.Arrays;

public class Rotor implements RotorInterface{

	private String turnoverNotchFirst;
	private String turnoverNotchSecond;
	private String rotorSetting;
	private String[] alphabet;
	private String[] rotorWiring;
	 
	public Rotor(int r, String rs) {
		
		this.rotorSetting = rs;
		this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
		
		if(r == 1){
			this.turnoverNotchFirst = "Q";
			this.turnoverNotchSecond = "R";
			this.rotorWiring = "EKMFLGDQVZNTOWYHXUSPAIBRCJ".split("");
		}
		if(r == 2){
			this.turnoverNotchFirst = "E";
			this.turnoverNotchSecond = "F";
			this.rotorWiring = "AJDKSIRUXBLHWTMCQGZNPYFVOE".split("");
		}
		if(r == 3){
			this.turnoverNotchFirst = "V";
			this.turnoverNotchSecond = "W";
			this.rotorWiring = "BDFHJLCPRTXVZNYEIWGAKMUSQO".split("");
		}
		if(r == 4){
			this.turnoverNotchFirst = "J";
			this.turnoverNotchSecond = "K";
			this.rotorWiring = "ESOVPZJAYQUIRHXLNFTGKDCMWB".split("");
		}
		if(r == 5){
			this.turnoverNotchFirst = "Z";
			this.turnoverNotchSecond = "A";
			this.rotorWiring = "VZBRGITYUPSDNHLXAWMJQOFECK".split("");
		}
	}

	public String getRotorSetting() {
		return this.rotorSetting;
	}
	
	public void setRotorSetting(String rs) {
		this.rotorSetting = rs;
	}
	
	public String incrementRotorSetting() {
		this.rotorSetting = this.alphabet[(getPos(this.rotorSetting) + 1) % 26];
		return this.rotorSetting;
	}
	
	public String decrementRotorSetting() {
		this.rotorSetting = this.alphabet[(getPos(this.rotorSetting) - 1) % 26];
		return this.rotorSetting;
	}
	
	public String getFirstTurnoverNotch() {
		return this.turnoverNotchFirst;
	}

	public String getSecondTurnoverNotch() {
		return this.turnoverNotchSecond;
	}
	
	public String[] getAlphabet() {
		return this.alphabet;
	}

	public String[] getRotorWiring() {
		return this.rotorWiring;
	}

	public String encodeLetter(String letter) {
		int relativePos = (getPos(letter) + getPos(this.rotorSetting) + 26) % 26;
		return getConnection(this.alphabet[relativePos]);
	}
	
	public String encodeLetterAfter(String letter, String previousRotorSetting) {
		int relativePos = (((getPos(letter) + getPos(this.rotorSetting) + 26) % 26) - getPos(previousRotorSetting) + 26) % 26;
		return getConnection(this.alphabet[relativePos]);
	}
	
	public String getConnection(String letter) {
		return this.rotorWiring[getPos(letter)];
	}

	private int getPos(String letter) {
		return Arrays.asList(alphabet).indexOf(letter);
	}
	
	public String encodeLetterBack(String letter) {
		int relativePos = (getPos(letter) + getPos(this.rotorSetting) + 26) % 26;
		return getConnectionBack(this.alphabet[relativePos]);
	}
	
	public String encodeLetterBackAfter(String letter, String previousRotorSetting) {
		int relativePos = (((getPos(letter) + getPos(this.rotorSetting) + 26) % 26) - getPos(previousRotorSetting) + 26) % 26;
		return getConnectionBack(this.alphabet[relativePos]);
	}
	
	public String getConnectionBack(String letter) {
		return this.alphabet[getPosBack(letter)];
	}

	private int getPosBack(String letter) {
		return Arrays.asList(rotorWiring).indexOf(letter);
	}

	

}
