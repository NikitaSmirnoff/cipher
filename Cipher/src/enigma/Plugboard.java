package enigma;

import java.util.Arrays;

public class Plugboard{
	
	private String[] alphabet;
	private String[] plugboard;
	private String[] plugs;
	private String abc;

	public Plugboard(String[] connections) {
		this.plugboard = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
		this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
		this.plugs = connections;
		this.abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		createPlugboard();
	}

	private void createPlugboard() {
		if(this.plugs == null){
			this.plugboard = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
		}else{
			for(int i = 0; i < plugs.length; i++){
				if(plugs[i].length() > 1){
					this.plugboard[this.abc.indexOf(plugs[i].charAt(0))] = plugs[i].substring(1);
					this.plugboard[this.abc.indexOf(plugs[i].charAt(1))] = plugs[i].substring(0, 1);
				}
			}
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
	
	public void setPlugs(String plug, int pos) {
		this.plugs[pos] = plug;
		for(int i = 0; i < plugs.length; i++){
			if(plugs[i].length() > 1){
				this.plugboard[this.abc.indexOf(plugs[i].charAt(0))] = plugs[i].substring(1);
				this.plugboard[this.abc.indexOf(plugs[i].charAt(1))] = plugs[i].substring(0, 1);
			}
		}
	}
	
	public void undoPlug(String plug){
		if(plug.length() > 1){
			this.plugboard[this.abc.indexOf(plug.charAt(0))] = plug.substring(0, 1);
			this.plugboard[this.abc.indexOf(plug.charAt(1))] = plug.substring(1);
		}
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
	
	public String encodeLetterBack(String letter, String previousRotorSetting) {
		int relativePos = (getPos(letter) - getPos(previousRotorSetting) + 26) % 26;
		return getConnectionBack(this.alphabet[relativePos]);
	}
	
	public String getEncodeAfterInput(String letter, String previousRotorSetting){
		int relativePos = (getPos(letter) - getPos(previousRotorSetting) + 26) % 26;
		return this.alphabet[relativePos];
	}
	
	
}
