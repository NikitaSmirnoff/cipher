package enigma;

import java.util.Arrays;

public class RotorII implements Rotor{

	private String turnoverNotch;
	private char[] alphabet;
	private char[] rotorWiring;
	 
	public RotorII() {
		this.turnoverNotch = "F";
		this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		this.rotorWiring = "AJDKSIRUXBLHWTMCQGZNPYFVOE".toCharArray();
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
