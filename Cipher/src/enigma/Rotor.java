package enigma;

import java.util.ArrayList;

public interface Rotor {
	
	public String getTurnoverNotch();
	
	public ArrayList<String> getAlphabet();
	
	public ArrayList<String> getRotorWiring();
	
	public String getConnection(String letter);
	
	
}
