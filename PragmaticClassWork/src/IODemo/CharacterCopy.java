package IODemo;

import java.io.*;

public class CharacterCopy {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		try(BufferedReader reader = new BufferedReader(new FileReader("resources/test.txt"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("resources/test_character_copy.txt"))) {
			int currentCharacter;
			while((currentCharacter = reader.read()) != -1) {
				writer.write(currentCharacter);
			}
		}
		
		
		
	}
}
