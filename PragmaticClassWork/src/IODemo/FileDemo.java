package IODemo;

import java.io.*;

public class FileDemo {
	public static void main(String[] args) {
		File file = new File("resources/test");
		System.out.println("File: " + file.getName() + " has length of: "
				+ file.length());
	}
}
