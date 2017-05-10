package enigma;

import java.util.Arrays;

public class Rotor implements RotorInterface{

	private String turnoverNotch;
	private String ringSetting;
	private String[] alphabet;
	private String[] rotorWiring;
	 
	public Rotor(int r, String rs) {
		
		this.ringSetting = rs;
		System.arraycopy("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""), 1, this.alphabet, 0, 26);
		
		if(r == 1){
			this.turnoverNotch = "R";
			System.arraycopy("EKMFLGDQVZNTOWYHXUSPAIBRCJ".split(""), 1, this.rotorWiring, 0, 26);
		}
		if(r == 2){
			this.turnoverNotch = "F";
			System.arraycopy("AJDKSIRUXBLHWTMCQGZNPYFVOE".split(""), 1, this.rotorWiring, 0, 26);
		}
		if(r == 3){
			this.turnoverNotch = "W";
			System.arraycopy("BDFHJLCPRTXVZNYEIWGAKMUSQO".split(""), 1, this.rotorWiring, 0, 26);
		}
		if(r == 4){
			this.turnoverNotch = "K";
			System.arraycopy("ESOVPZJAYQUIRHXLNFTGKDCMWB".split(""), 1, this.rotorWiring, 0, 26);
		}
		if(r == 5){
			this.turnoverNotch = "A";
			System.arraycopy("VZBRGITYUPSDNHLXAWMJQOFECK".split(""), 1, this.rotorWiring, 0, 26);
		}
	}

	public String getTurnoverNotch() {
		return this.turnoverNotch;
	}
	
	public String getRingSetting() {
		return this.ringSetting;
	}
	
	public String setRingSetting(String rs) {
		return this.ringSetting = rs;
	}
	
	public String incrementRingSetting() {
		return this.ringSetting = this.alphabet[Arrays.asList(alphabet).indexOf(this.ringSetting) + 1];
	}

	public String[] getAlphabet() {
		return this.alphabet;
	}

	public String[] getRotorWiring() {
		return this.rotorWiring;
	}

	public String getConnection(String letter) {
		return this.rotorWiring[Arrays.asList(alphabet).indexOf(letter)];
	}

}
