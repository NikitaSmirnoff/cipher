package enigma;

import java.util.Arrays;

public class EnigmaI {

	public static final int LEFT = 0; 
	public static final int MIDDLE = 1;
	public static final int RIGHT = 2;
	
	public static Rotor rotors[] = new Rotor[3];
	public static Plugboard plugboard;
	public static Reflector reflector;
	public static EnigmaI enigma;

	public EnigmaI(String[] plugs, int r1, String rs1, int r2, String rs2, int r3, String rs3, String ref) {
		plugboard = new Plugboard(plugs);
		rotors[LEFT] = new Rotor(r1, rs1);
		rotors[MIDDLE] = new Rotor(r2, rs2);
		rotors[RIGHT] = new Rotor(r3, rs3);
		reflector = new Reflector(ref);
		
		System.out.println("--= Enigma Settings =-- ");
		System.out.println("");
		System.out.println("Plugboard: " + Arrays.toString(plugs));
		System.out.println("Rotors: (" + rs1 + ") (" + rs2 + ") (" + rs3 + ")");
		System.out.println("         " + r1 + "   " + r2 + "   " + r3);
		System.out.println("Reflector: UKW-" + ref);
		System.out.println("");
	}
	
	public static void main(String[] args) {
		String[] plugs = {"AZ", "XY"};
		enigma = new EnigmaI(plugs, 4, "P", 1, "D", 2, "R", "B");
		enigma.encodePhrase("HELLO WORLD");
	}

	private String encodeChar(String letter) {
		rotors[RIGHT].incrementRotorSetting();
		
		if(rotors[RIGHT].getRotorSetting().equals(rotors[RIGHT].getSecondTurnoverNotch())){
			rotors[MIDDLE].incrementRotorSetting();
		} else {
			if(rotors[MIDDLE].getRotorSetting().equals(rotors[MIDDLE].getFirstTurnoverNotch())){
				rotors[MIDDLE].incrementRotorSetting();
				
				if(rotors[MIDDLE].getRotorSetting().equals(rotors[MIDDLE].getSecondTurnoverNotch())){
					rotors[LEFT].incrementRotorSetting();
				}
			}
		}
		
		String resultOfPlugboard = plugboard.getConnection(letter.toUpperCase());
		
		String resultOfRotorRight = rotors[RIGHT].encodeLetter(resultOfPlugboard);
		String resultOfRotorMiddle = rotors[MIDDLE].encodeLetterAfter(resultOfRotorRight, rotors[RIGHT].getRotorSetting());
		String resultOfRotorLeft = rotors[LEFT].encodeLetterAfter(resultOfRotorMiddle, rotors[MIDDLE].getRotorSetting());
		
		String resultOfReflector = reflector.encodeLetter(resultOfRotorLeft, rotors[LEFT].getRotorSetting());
		
		String resultOfRotorLeftBack = rotors[LEFT].encodeLetterBack(resultOfReflector);
		String resultOfRotorMiddleBack = rotors[MIDDLE].encodeLetterBackAfter(resultOfRotorLeftBack, rotors[LEFT].getRotorSetting());
		String resultOfRotorRightBack = rotors[RIGHT].encodeLetterBackAfter(resultOfRotorMiddleBack, rotors[MIDDLE].getRotorSetting());
		
		String resultOfPlugboardBack = plugboard.encodeLetterBack(resultOfRotorRightBack, rotors[RIGHT].getRotorSetting());
		
		System.out.println("Rotor Settings: " + rotors[LEFT].getRotorSetting() + rotors[MIDDLE].getRotorSetting() + rotors[RIGHT].getRotorSetting());
		System.out.println(letter + " | " + resultOfPlugboard + " > " + resultOfRotorRight + " > "
				 + resultOfRotorMiddle + " > " + resultOfRotorLeft + " > " + resultOfReflector + " > "
				 + resultOfRotorLeftBack + " > " + resultOfRotorMiddleBack + " > " + resultOfRotorRightBack + " | "
				 + resultOfPlugboardBack);
		
		return resultOfPlugboardBack;
		
	}
	
	private String encodeWord(String word) {
		String result = "";
		
		for(int i = 0; i < word.length(); i++){
			result = result + encodeChar(word.substring(i, i + 1));
		}
		
		return result;
	}
	
	private String encodePhrase(String phrase) {
		String result = "";
		String[] phraseArray = phrase.split(" ");
		
		for(int i = 0; i < phraseArray.length; i++){
			result = result + encodeWord(phraseArray[i]) + " ";
		}
		
		System.out.println("");
		System.out.println("Input:  " + phrase.toUpperCase());
		System.out.println("Output: " + result);
		return result;
	}

}
