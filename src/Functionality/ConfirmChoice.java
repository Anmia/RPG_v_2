package Functionality;

import java.util.Scanner;

public class ConfirmChoice {
	public static boolean confirmChoice() {
		boolean done = false;
		boolean result = true;
		while (!done) {
			Scanner input = new Scanner(System.in);
			System.out.println("Confirm choice? (y/n)");

			switch (input.nextLine()) {
				case "y":
					result = true;
					done = true;
					break;
				case "n":
					result = false;
					done = true;
					break;
				default:
					System.out.println("Not a valid choice;");
					break;
			}
		}
		return result;
	}
}
