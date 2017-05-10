package enigma;

import java.util.Arrays;

public class Plugboard {
	
	private String[] alphabet;
	private String[] plugboard = new String[26];
	private String[] plugs;

	public Plugboard(String[] connections) {
		System.arraycopy("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""), 1, this.alphabet, 0, 26);
		this.plugs = connections;
		createPlugboard();
	}

	private void createPlugboard() {
		for(int i = 0; i < plugs.length; i++){
			this.plugboard[alphabet.toString().indexOf(plugs[i].charAt(0))] = plugs[i].substring(1, 2);
			this.plugboard[alphabet.toString().indexOf(plugs[i].charAt(1))] = plugs[i].substring(0, 1);
		}
	}

	public String[] getAlphabet() {
		return this.alphabet;
	}

	public String[] getPlugboard() {
		return this.plugboard;
	}
	
	public String[] getPlugs() {
		return this.plugs;
	}

	public String getConnection(String letter) {
		return this.plugboard[Arrays.asList(alphabet).indexOf(letter)];
	}
}
