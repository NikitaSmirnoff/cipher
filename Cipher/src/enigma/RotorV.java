package enigma;

import java.util.Arrays;

public class RotorV implements Rotor{

	private String turnoverNotch;
	private char[] alphabet;
	private char[] rotorWiring;
	 
	public RotorV() {
		this.turnoverNotch = "A";
		this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		this.rotorWiring = "VZBRGITYUPSDNHLXAWMJQOFECK".toCharArray();
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
