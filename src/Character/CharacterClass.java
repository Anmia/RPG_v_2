package Character;

import Functionality.ReadFile;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class CharacterClass {
	private ArrayList<Map<String, String>> proficiency = new ArrayList<>();
	private ArrayList<Map<String, String>> resistance = new ArrayList<>();
	private ArrayList<Map<String, String>> immunity = new ArrayList<>();

	private int id;
	private String name;
	private int hitDice;

	public CharacterClass() {
		selectClass();;
	}


	private void selectClass() {
		boolean done = false;
		ArrayList<String[]> oClass = ReadFile.readFile("./src/Character/listClass.txt");
		int selection = -1;
		int option = 100;

		while (!done) {
			Scanner input = new Scanner(System.in);
			System.out.println("Select a class:");
			for (int i = 0; i < oClass.size(); i++) {
				System.out.println(i + " " + oClass.get(i)[1]);
			}

			if (input.hasNextInt()) {
				option = Integer.parseInt(input.nextLine());

				if (option >= oClass.size()) {
					System.out.println("Not valid selection");
				} else {
					selection = option;
					done = true;
				}
			} else {
				System.out.println("Not valid selection");
			}

		}

		if (selection == -1) {
			System.out.println("SHIT!");
			return;
		}
		this.id = Integer.parseInt(oClass.get(selection)[0]);
		this.name = oClass.get(selection)[1];
		this.hitDice = Integer.parseInt(oClass.get(selection)[2]);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getHitDice() {
		return hitDice;
	}
}
