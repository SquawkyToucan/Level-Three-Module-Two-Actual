//not copyrighted because it's trash

package intro_to_file_io;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Decryption {
	static String key;
	static String encryptThis;
	Decryption(String key) {
		this.key = key;
	}
	public static void main(String[] args) {
		Encryption encrypt = new Encryption(JOptionPane.showInputDialog("Please create a jumbler with letters a through z."));
		System.out.println(findCipher());
		encryptThis = JOptionPane.showInputDialog("What text would you like to encrypt?");
		try {
			FileWriter write = new FileWriter("src/intro_to_file_io/Encrypted Result");
			write.write(cipher(encryptThis, findCipher()));
			write.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static int findCipher() {
		//Consonants move the wheel forward by their values.
		//Vowels move the wheel back.
		String keyToEncryptBy = key.toLowerCase();
		//Consonants: move up by alphabetical value
		//Vowels: by primes in orders of two
		/**
		 *  - A: -2
		 *  - E: -5
		 *  - I: -11
		 *  - O: -17
		 *  - U: -23
		 */
		char[] letters = keyToEncryptBy.toCharArray();
		int number = 0;
		for(int i = 0; i < letters.length; i++) {
			//Check if it's a consonant, vowel, or illegal character that was added by the user
			if(letters[i] != 'a'&&letters[i] != 'e'&&letters[i] != 'i'&&letters[i] != 'o'&&letters[i] != 'u') {
				//Consonants
				number = number + Character.getNumericValue(letters[i]) - 9;
				System.out.println(number);
			}
			else if(letters[i] == 'a'||letters[i] == 'e'&&letters[i] == 'i'&&letters[i] == 'o'&&letters[i] == 'u') {
				//Vowels
				if(letters[i] == 'a') {
					number = number - 2;
				}
				else if(letters[i] == 'e') {
					number = number - 5;
				}
				else if(letters[i] == 'i') {
					number = number - 11;
				}
				else if(letters[i] == 'o') {
					number = number - 17;
				}
				else if(letters[i] == 'u') {
					number = number - 23;
				}
				else {
					//Logic operator failure
				}
				System.out.println(number);
			}
			else {
				//Do nothing, as it was wrong.
			}
		}
		return Math.abs(number%26);
	}
	static String cipher(String msg, int shift){
	    String s = "";
	    int len = msg.length();
	    for(int x = 0; x < len; x++){
	        char c = (char)(msg.charAt(x) + shift);
	        if (c > 'z')
	            s += (char)(msg.charAt(x) - (26-shift));
	        else
	            s += (char)(msg.charAt(x) + shift);
	    }
	    return s;
	}

}