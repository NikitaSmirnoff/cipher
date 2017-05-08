package enigma;

import java.util.Arrays;

public class RotorIII implements Rotor{

	private String turnoverNotch;
	private char[] alphabet;
	private char[] rotorWiring;
	 
	public RotorIII() {
		this.turnoverNotch = "W";
		this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		this.rotorWiring = "BDFHJLCPRTXVZNYEIWGAKMUSQO".toCharArray();
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
