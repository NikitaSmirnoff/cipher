package enigma;

import java.util.Arrays;

public class Reflector{

	private String[] alphabet;
	private String[] reflectorWiring;
	 
	public Reflector(String r) {
		
		this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
		
		if(r.equals("A")){
			this.reflectorWiring = "EJMZALYXVBWFCRQUONTSPIKHGD".split("");
		}
		if(r.equals("B")){
			this.reflectorWiring = "YRUHQSLDPXNGOKMIEBFZCWVJAT".split("");
		}
		if(r.equals("C")){
			this.reflectorWiring = "FVPJIAOYEDRZXWGCTKUQSBNMHL".split("");
		}
		
	}

	public String[] getAlphabet() {
		return this.alphabet;
	}

	public String[] getReflectorWiring() {
		return this.reflectorWiring;
	}
	
	public String encodeLetter(String letter, String previousRotorSetting) {
		int relativePos = (getPos(letter) - getPos(previousRotorSetting) + 26) % 26;
		return getConnection(this.alphabet[relativePos]);
	}

	public String getConnection(String letter) {
		return this.reflectorWiring[getPos(letter)];
	}
	
	private int getPos(String letter) {
		return Arrays.asList(alphabet).indexOf(letter);
	}
	
	public String getEncodeAfterInput(String letter, String previousRotorSetting){
		int relativePos = (getPos(letter) - getPos(previousRotorSetting) + 26) % 26;
		return this.alphabet[relativePos];
	}

}
