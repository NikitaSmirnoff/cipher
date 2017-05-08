package enigma;

import java.util.Arrays;

public class Plugboard {
	
	private char[] alphabet;
	private char[] plugboard = new char[26];
	private String[] plugs;

	public Plugboard(String[] connections) {
		this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		this.plugs = connections;
		createPlugboard();
	}

	private void createPlugboard() {
		for(int i = 0; i < plugs.length; i++){
			this.plugboard[alphabet.toString().indexOf(plugs[i].charAt(0))] = plugs[i].charAt(1);
			this.plugboard[alphabet.toString().indexOf(plugs[i].charAt(1))] = plugs[i].charAt(0);
		}
	}

	public char[] getAlphabet() {
		return this.alphabet;
	}

	public char[] getPlugboard() {
		return this.plugboard;
	}
	
	public String[] getPlugs() {
		return this.plugs;
	}

	public char getConnection(String letter) {
		return this.plugboard[Arrays.asList(alphabet).indexOf(letter)];
	}
}
