package enigma;

import java.util.Arrays;

public class RotorIV implements Rotor{

	private String turnoverNotch;
	private char[] alphabet;
	private char[] rotorWiring;
	 
	public RotorIV() {
		this.turnoverNotch = "K";
		this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		this.rotorWiring = "ESOVPZJAYQUIRHXLNFTGKDCMWB".toCharArray();
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
