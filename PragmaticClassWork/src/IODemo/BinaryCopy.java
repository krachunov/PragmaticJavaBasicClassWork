package IODemo;


import java.io.*;

public class BinaryCopy {
	public static void main(String[] args) throws IOException, FileNotFoundException {
		
		/*
		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		try {
			inputStream = new FileInputStream("resources/test.txt");
			outputStream = new FileOutputStream("resources/test_binary_copy.txt");
			
			int currentByte;
			while((currentByte = inputStream.read()) != -1) {
				outputStream.write(currentByte);
			}
		} finally {
			if(inputStream != null) {
				inputStream.close();
			}
			if(outputStream != null) {
				outputStream.close();
			}
		}
		*/
		
		try (FileInputStream inputStream = new FileInputStream(
				"resources/test.txt");
				FileOutputStream outputStream = new FileOutputStream(
						"resources/test_binary_copy.txt");) {

			int currentByte;
			while ((currentByte = inputStream.read()) != -1) {
				outputStream.write(currentByte);
			}
		}
	}
}
