package enigma;

import java.util.Arrays;

public class Reflector {

	private String[] alphabet;
	private String[] reflectorWiring;
	 
	public Reflector(String r) {
		
		System.arraycopy("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""), 1, this.alphabet, 0, 26);
		
		if(r.equals("A")){
			System.arraycopy("EJMZALYXVBWFCRQUONTSPIKHGD".split(""), 1, this.reflectorWiring, 0, 26);
		}
		if(r.equals("B")){
			System.arraycopy("YRUHQSLDPXNGOKMIEBFZCWVJAT".split(""), 1, this.reflectorWiring, 0, 26);
		}
		if(r.equals("C")){
			System.arraycopy("FVPJIAOYEDRZXWGCTKUQSBNMHL".split(""), 1, this.reflectorWiring, 0, 26);
		}
		
	}

	public String[] getAlphabet() {
		return this.alphabet;
	}

	public String[] getReflectorWiring() {
		return this.reflectorWiring;
	}

	public String getConnection(String letter) {
		return this.reflectorWiring[Arrays.asList(alphabet).indexOf(letter)];
	}

}
