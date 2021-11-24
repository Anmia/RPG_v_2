package Functionality;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {

	/*
	Params: fileName - path from src and name of file
	 */
	public static ArrayList<String[]> readFile(String fileName) {
		ArrayList<String[]> list = new ArrayList<>();

		try {
			File file = new File(fileName);
			Scanner fetch = new Scanner(file);
			while (fetch.hasNextLine()) {
				list.add(fetch.nextLine().split(":"));
			}
			fetch.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred! :(");
			e.printStackTrace();
		}

		return list;
	}
}
