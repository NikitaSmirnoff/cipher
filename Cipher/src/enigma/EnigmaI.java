package enigma;

public class EnigmaI {

	public static final int LEFT = 0; 
	public static final int MIDDLE = 1;
	public static final int RIGHT = 2;
	
	public static Rotor rotors[] = new Rotor[3];
	public static Plugboard plugboard;
	public static Reflector reflector;

	public EnigmaI(String[] plugs, int r1, String rs1, int r2, String rs2, int r3, String rs3, String ref) {
		plugboard = new Plugboard(plugs);
		rotors[LEFT] = new Rotor(r1, rs1);
		rotors[MIDDLE] = new Rotor(r2, rs2);
		rotors[RIGHT] = new Rotor(r3, rs3);
		reflector = new Reflector(ref);

	}
	
	public static void main(String[] args) {
		encodeChar("A");
	}

	private static void encodeChar(String letter) {
		rotors[RIGHT].incrementRotorSetting();
		
		if(rotors[RIGHT].getRotorSetting().equals(rotors[RIGHT].getSecondTurnoverNotch())){
			rotors[MIDDLE].incrementRotorSetting();
		} else {
			if(rotors[MIDDLE].getRotorSetting().equals(rotors[MIDDLE].getFirstTurnoverNotch())){
				rotors[MIDDLE].incrementRotorSetting();
			}
			if(rotors[MIDDLE].getRotorSetting().equals(rotors[MIDDLE].getSecondTurnoverNotch())){
				rotors[LEFT].incrementRotorSetting();
			}
		}
		
		String resultOfPlugboard = plugboard.getConnection(letter);
		
		String resultOfRotorRight = rotors[RIGHT].encodeLetter(resultOfPlugboard);
		String resultOfRotorMiddle = rotors[MIDDLE].encodeLetter(resultOfRotorRight);
		String resultOfRotorLeft = rotors[LEFT].encodeLetter(resultOfRotorMiddle);
		String resultOfReflector = reflector.getConnection(resultOfRotorLeft);
		
		
		
	}

}
