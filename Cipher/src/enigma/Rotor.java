package enigma;


public interface Rotor {
	
	public String getTurnoverNotch();
	
	public char[] getAlphabet();
	
	public char[] getRotorWiring();
	
	public char getConnection(String letter);
	
	
}
