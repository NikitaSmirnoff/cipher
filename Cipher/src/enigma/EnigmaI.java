package enigma;

import java.util.Arrays;

public class EnigmaI {

	public static final int LEFT = 0; 
	public static final int MIDDLE = 1;
	public static final int RIGHT = 2;
	public static final int INCREMENT = 0;
	public static final int DECREMENT = 1;
	
	public static Rotor rotors[] = new Rotor[3];
	public static Plugboard plugboard;
	public static Reflector reflector;
	public static EnigmaI enigma;
	
	// Encryption Results
	public String input;
	public String resultOfPlugboard;
	
	public String inputOfRotorRight;
	public String resultOfRotorRight;
	public String inputOfRotorMiddle;
	public String resultOfRotorMiddle;
	public String inputOfRotorLeft;
	public String resultOfRotorLeft;
	
	public String inputOfReflector;
	public String resultOfReflector;
	
	public String inputOfRotorLeftBack;
	public String resultOfRotorLeftBack;
	public String inputOfRotorMiddleBack;
	public String resultOfRotorMiddleBack;
	public String inputOfRotorRightBack;
	public String resultOfRotorRightBack;
	
	public String inputOfPlugboardBack;
	public String resultOfPlugboardBack;

	public EnigmaI(String[] plugs, int r1, String rs1, int r2, String rs2, int r3, String rs3, String ref) {
		plugboard = new Plugboard(plugs);
		rotors[LEFT] = new Rotor(r1, rs1);
		rotors[MIDDLE] = new Rotor(r2, rs2);
		rotors[RIGHT] = new Rotor(r3, rs3);
		reflector = new Reflector(ref);
		
//		System.out.println("--= Enigma Settings =-- ");
//		System.out.println("");
//		System.out.println("Plugboard: " + Arrays.toString(plugs));
//		System.out.println("Rotors: (" + rs1 + ") (" + rs2 + ") (" + rs3 + ")");
//		System.out.println("         " + r1 + "   " + r2 + "   " + r3);
//		System.out.println("Reflector: UKW-" + ref);
//		System.out.println("");
	}
	
	public static void main(String[] args) {
//		String[] plugs = {"AZ", "XY"};
//		enigma = new EnigmaI(plugs, 4, "P", 1, "D", 2, "R", "B");
//		enigma.encodePhrase("HELLO WORLD");
	}
	
	public void updateRotorSettings(int update) {
		if(update == INCREMENT){
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
		}
		if(update == DECREMENT){
			rotors[RIGHT].decrementRotorSetting();
			
			if(rotors[RIGHT].getRotorSetting().equals(rotors[RIGHT].getFirstTurnoverNotch())){
				rotors[MIDDLE].decrementRotorSetting();
			} else {
				if(rotors[MIDDLE].getRotorSetting().equals(rotors[MIDDLE].getSecondTurnoverNotch())){
					rotors[MIDDLE].decrementRotorSetting();
					
					if(rotors[MIDDLE].getRotorSetting().equals(rotors[MIDDLE].getFirstTurnoverNotch())){
						rotors[LEFT].decrementRotorSetting();
					}
				}
			}
		}
		
	}

	public String encodeChar(String letter) {
		updateRotorSettings(INCREMENT);
		
		this.input = letter;
		this.resultOfPlugboard = plugboard.getConnection(input.toUpperCase());
		
		this.inputOfRotorRight = rotors[RIGHT].getEncodeInput(this.resultOfPlugboard);
		this.resultOfRotorRight = rotors[RIGHT].encodeLetter(this.resultOfPlugboard);
		this.inputOfRotorMiddle = rotors[MIDDLE].getEncodeAfterInput(this.resultOfRotorRight, rotors[RIGHT].getRotorSetting());
		this.resultOfRotorMiddle = rotors[MIDDLE].encodeLetterAfter(this.resultOfRotorRight, rotors[RIGHT].getRotorSetting());
		this.inputOfRotorLeft = rotors[LEFT].getEncodeAfterInput(this.resultOfRotorMiddle, rotors[MIDDLE].getRotorSetting());
		this.resultOfRotorLeft = rotors[LEFT].encodeLetterAfter(this.resultOfRotorMiddle, rotors[MIDDLE].getRotorSetting());
		
		this.inputOfReflector = reflector.getEncodeAfterInput(this.resultOfRotorLeft, rotors[LEFT].getRotorSetting());
		this.resultOfReflector = reflector.encodeLetter(this.resultOfRotorLeft, rotors[LEFT].getRotorSetting());
		
		this.inputOfRotorLeftBack = rotors[LEFT].getEncodeInput(this.resultOfReflector);
		this.resultOfRotorLeftBack = rotors[LEFT].encodeLetterBack(this.resultOfReflector);
		this.inputOfRotorMiddleBack = rotors[MIDDLE].getEncodeAfterInput(this.resultOfRotorLeftBack, rotors[LEFT].getRotorSetting());
		this.resultOfRotorMiddleBack = rotors[MIDDLE].encodeLetterBackAfter(this.resultOfRotorLeftBack, rotors[LEFT].getRotorSetting());
		this.inputOfRotorRightBack = rotors[RIGHT].getEncodeAfterInput(this.resultOfRotorMiddleBack, rotors[MIDDLE].getRotorSetting());
		this.resultOfRotorRightBack = rotors[RIGHT].encodeLetterBackAfter(this.resultOfRotorMiddleBack, rotors[MIDDLE].getRotorSetting());
		
		this.inputOfPlugboardBack = plugboard.getEncodeAfterInput(this.resultOfRotorRightBack, rotors[RIGHT].getRotorSetting());
		this.resultOfPlugboardBack = plugboard.encodeLetterBack(this.resultOfRotorRightBack, rotors[RIGHT].getRotorSetting());
		
//		System.out.println("Rotor Settings: " + rotors[LEFT].getRotorSetting() + rotors[MIDDLE].getRotorSetting() + rotors[RIGHT].getRotorSetting());
//		System.out.println(letter.toUpperCase() + " > " + resultOfPlugboard + " | " + inputOfRotorRight + " > " + resultOfRotorRight + " > "
//				 + inputOfRotorMiddle + " > " + resultOfRotorMiddle + " > " + inputOfRotorLeft + " > " + resultOfRotorLeft + " > " + inputOfReflector + " > " + resultOfReflector + " > "
//				 + inputOfRotorLeftBack + " > " + resultOfRotorLeftBack + " > " + inputOfRotorMiddleBack + " > " + resultOfRotorMiddleBack + " > " + inputOfRotorRightBack + " > " + resultOfRotorRightBack + " | "
//				 + inputOfPlugboardBack + " > " + resultOfPlugboardBack);
		
		return resultOfPlugboardBack;
		
	}
	
	public String encodeWord(String word) {
		String result = "";
		
		if(word.length() > 0){
			for(int i = 0; i < word.length(); i++){
				result = result + encodeChar(word.substring(i, i + 1));
			}
		}
		
		return result;
	}
	
	public String encodePhrase(String phrase) {
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

	public Rotor getRotors(int rotor) {
		return this.rotors[rotor];
	}

	public void setRotors(Rotor[] rotors) {
		this.rotors = rotors;
	}

	public Plugboard getPlugboard() {
		return this.plugboard;
	}

	public void setPlugboard(Plugboard plugboard) {
		this.plugboard = plugboard;
	}

	public Reflector getReflector() {
		return this.reflector;
	}

	public void setReflector(Reflector reflector) {
		this.reflector = reflector;
	}

	public EnigmaI getEnigma() {
		return this.enigma;
	}

	public void setEnigma(EnigmaI enigma) {
		this.enigma = enigma;
	}

	public String getInput() {
		return this.input;
	}

	public String getResultOfPlugboard() {
		return this.resultOfPlugboard;
	}

	public String getInputOfRotorRight() {
		return this.inputOfRotorRight;
	}

	public String getResultOfRotorRight() {
		return this.resultOfRotorRight;
	}

	public String getInputOfRotorMiddle() {
		return this.inputOfRotorMiddle;
	}

	public String getResultOfRotorMiddle() {
		return this.resultOfRotorMiddle;
	}

	public String getInputOfRotorLeft() {
		return this.inputOfRotorLeft;
	}

	public String getResultOfRotorLeft() {
		return this.resultOfRotorLeft;
	}

	public String getInputOfReflector() {
		return this.inputOfReflector;
	}

	public String getResultOfReflector() {
		return this.resultOfReflector;
	}

	public String getInputOfRotorLeftBack() {
		return this.inputOfRotorLeftBack;
	}

	public String getResultOfRotorLeftBack() {
		return this.resultOfRotorLeftBack;
	}

	public String getInputOfRotorMiddleBack() {
		return this.inputOfRotorMiddleBack;
	}

	public String getResultOfRotorMiddleBack() {
		return this.resultOfRotorMiddleBack;
	}

	public String getInputOfRotorRightBack() {
		return this.inputOfRotorRightBack;
	}

	public String getResultOfRotorRightBack() {
		return this.resultOfRotorRightBack;
	}

	public String getInputOfPlugboardBack() {
		return this.inputOfPlugboardBack;
	}

	public String getResultOfPlugboardBack() {
		return this.resultOfPlugboardBack;
	}

}
