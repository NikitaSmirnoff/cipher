package enigma;

import java.util.ArrayList;

public class RotorI implements Rotor{

	private String turnoverNotch;
	private ArrayList<String> alphabet;
	private ArrayList<String> rotorWiring;
	 
	public RotorI() {
		turnoverNotch = "R";
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
