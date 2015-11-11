package IODemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CharacterLinesCopy {
	public static void main(String[] args) throws IOException {
        try(BufferedReader inputStream = new BufferedReader(new FileReader("resources/test.txt"));
        	PrintWriter outputStream = new PrintWriter(new FileWriter("resources/test_character_lines_copy.txt"))) {
        		
        	String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(l);
            }
        }
	}
}
