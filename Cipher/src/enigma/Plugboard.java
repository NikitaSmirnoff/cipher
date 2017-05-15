package enigma;

import java.util.Arrays;

public class Plugboard{
	
	private String[] alphabet;
	private String[] plugboard = new String[26];
	private String[] plugs;
	private String abc;

	public Plugboard(String[] connections) {
		this.plugs = connections;
		this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
		this.abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		createPlugboard();
	}

	private void createPlugboard() {
		
		for(int i = 0; i < plugs.length; i++){
			this.plugboard[this.abc.indexOf(plugs[i].charAt(0))] = plugs[i].substring(1);
			this.plugboard[this.abc.indexOf(plugs[i].charAt(1))] = plugs[i].substring(0, 1);
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
		return this.plugboard[getPos(letter)];
	}
	
	private int getPos(String letter) {
		return Arrays.asList(alphabet).indexOf(letter);
	}
	
	public String getConnectionBack(String letter) {
		return this.alphabet[getPosBack(letter)];
	}
	
	private int getPosBack(String letter) {
		return Arrays.asList(plugboard).indexOf(letter);
	}
}
