package enigma;

import java.util.ArrayList;

public class RotorIV implements Rotor{

	private String turnoverNotch;
	private ArrayList<String> alphabet;
	private ArrayList<String> rotorWiring;
	 
	public RotorIV() {
		turnoverNotch = "K";
	}

	public String getTurnoverNotch() {
		return turnoverNotch;
	}

	public ArrayList<String> getAlphabet() {
		return alphabet;
	}

	public ArrayList<String> getRotorWiring() {
		return rotorWiring;
	}

	public String getConnection(String letter) {
		return null;
	}

}
