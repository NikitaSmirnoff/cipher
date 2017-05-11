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
		System.arraycopy("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""), 1, this.alphabet, 0, 26);
		
		if(r == 1){
			this.turnoverNotchFirst = "Q";
			this.turnoverNotchSecond = "R";
			System.arraycopy("EKMFLGDQVZNTOWYHXUSPAIBRCJ".split(""), 1, this.rotorWiring, 0, 26);
		}
		if(r == 2){
			this.turnoverNotchFirst = "E";
			this.turnoverNotchSecond = "F";
			System.arraycopy("AJDKSIRUXBLHWTMCQGZNPYFVOE".split(""), 1, this.rotorWiring, 0, 26);
		}
		if(r == 3){
			this.turnoverNotchFirst = "V";
			this.turnoverNotchSecond = "W";
			System.arraycopy("BDFHJLCPRTXVZNYEIWGAKMUSQO".split(""), 1, this.rotorWiring, 0, 26);
		}
		if(r == 4){
			this.turnoverNotchFirst = "J";
			this.turnoverNotchSecond = "K";
			System.arraycopy("ESOVPZJAYQUIRHXLNFTGKDCMWB".split(""), 1, this.rotorWiring, 0, 26);
		}
		if(r == 5){
			this.turnoverNotchFirst = "Z";
			this.turnoverNotchSecond = "A";
			System.arraycopy("VZBRGITYUPSDNHLXAWMJQOFECK".split(""), 1, this.rotorWiring, 0, 26);
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
		int relativePos = (getPos(letter) + getPos(this.rotorSetting)) % 26;
		return getConnection(this.alphabet[relativePos]);
	}
	
	public String getConnection(String letter) {
		return this.rotorWiring[getPos(letter)];
	}

	private int getPos(String letter) {
		return Arrays.asList(alphabet).indexOf(letter);
	}

	@Override
	public String getTurnoverNotch() {
		// TODO Auto-generated method stub
		return null;
	}

}
