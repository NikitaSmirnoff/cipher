package enigma;

public class EnigmaI {

	public static Rotor rotors[] = new Rotor[3];
	public static Plugboard plugboard;
	public static Reflector reflector;

	public EnigmaI(String[] plugs, int r1, String rs1, int r2, String rs2, int r3, String rs3, String ref) {
		plugboard = new Plugboard(plugs);
		rotors[0] = new Rotor(r1, rs1);
		rotors[1] = new Rotor(r2, rs2);
		rotors[2] = new Rotor(r3, rs3);
		reflector = new Reflector(ref);

	}
	
	public static void main(String[] args) {
		encodeChar("A");
	}

	private static void encodeChar(String letter) {
		String resultOfPlugboard = plugboard.getConnection(letter);
		String resultOfRotorRight = rotors[2].getConnection(resultOfPlugboard);
		String resultOfRotorMiddle = rotors[1].getConnection(resultOfRotorRight);
		String resultOfRotorLeft = rotors[0].getConnection(resultOfRotorMiddle);
		String resultOfReflector = reflector.getConnection(resultOfRotorLeft);
		
		
		
	}

}
