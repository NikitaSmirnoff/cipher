package enigma;

public class EnigmaI {

	public static Rotor rotors[] = new Rotor[3];
	public static Plugboard plugboard;

	public EnigmaI(String[] plugs, int r1, int r2, int r3, char reflector) {
		plugboard = new Plugboard(plugs);
		rotors[0] = new RotorI(r1);
		rotors[1] = new RotorI(r2);
		rotors[2] = new RotorI(r3);

	}

}
