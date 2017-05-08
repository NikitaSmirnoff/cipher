package enigma;

import java.util.Arrays;

public class RotorI implements Rotor{

	private String turnoverNotch;
	private char[] alphabet;
	private char[] rotorWiring;
	 
	public RotorI(int r) {
		
		this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		
		if(r == 1){
			this.turnoverNotch = "R";
			this.rotorWiring = "EKMFLGDQVZNTOWYHXUSPAIBRCJ".toCharArray();
		}
		if(r == 2){
			this.turnoverNotch = "F";
			this.rotorWiring = "AJDKSIRUXBLHWTMCQGZNPYFVOE".toCharArray();
		}
		if(r == 3){
			this.turnoverNotch = "W";
			this.rotorWiring = "BDFHJLCPRTXVZNYEIWGAKMUSQO".toCharArray();
		}
		if(r == 4){
			this.turnoverNotch = "K";
			this.rotorWiring = "ESOVPZJAYQUIRHXLNFTGKDCMWB".toCharArray();
		}
		if(r == 5){
			this.turnoverNotch = "A";
			this.rotorWiring = "VZBRGITYUPSDNHLXAWMJQOFECK".toCharArray();
		}
		
//		this.turnoverNotch = "R";
//		this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
//		this.rotorWiring = "EKMFLGDQVZNTOWYHXUSPAIBRCJ".toCharArray();
	}

	public String getTurnoverNotch() {
		return this.turnoverNotch;
	}

	public char[] getAlphabet() {
		return this.alphabet;
	}

	public char[] getRotorWiring() {
		return this.rotorWiring;
	}

	public char getConnection(String letter) {
		return this.rotorWiring[Arrays.asList(alphabet).indexOf(letter)];
	}

}
