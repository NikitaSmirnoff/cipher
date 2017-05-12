package enigma;

import java.util.Arrays;

public class Plugboard{
	
	private String[] alphabet;
	private String[] plugboard = new String[26];
	private String[] plugs;

	public Plugboard(String[] connections) {
		this.plugs = connections;
		this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
		createPlugboard();
	}

	private void createPlugboard() {
		System.out.println(Arrays.toString(alphabet).indexOf(plugs[0].charAt(1)));
		
		for(int i = 0; i < plugs.length; i++){
			this.plugboard[Arrays.toString(alphabet).indexOf(plugs[i].charAt(0))] = plugs[i].substring(1);
			this.plugboard[Arrays.toString(alphabet).indexOf(plugs[i].charAt(1))] = plugs[i].substring(0, 1);
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
