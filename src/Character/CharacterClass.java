package Character;

import Functionality.ReadFile;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class CharacterClass {
	private ArrayList<String> proficiency = new ArrayList<>();
	private ArrayList<String> resistance = new ArrayList<>();
	private ArrayList<String> immunity = new ArrayList<>();

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

		ArrayList<String[]> profy = ReadFile.readFile("./src/Character/listClassProficiency.txt", "1:" + this.id);
		boolean hasOption = false;

		for (int i = 0; i < profy.size(); i++) {
			if (Integer.parseInt(profy.get(i)[3]) == 1) {
				this.proficiency.add(profy.get(i)[2]);
			}

			if (Integer.parseInt(profy.get(i)[3]) == 0) {
				hasOption = true;
			}
		}
		if (hasOption) {
			this.proficiency.add(selectProfOption(profy));
		}
	}

	private static String selectProfOption(ArrayList<String[]> value) {
		int option = 100;
		String output = "";
		boolean done = false;
		while (!done) {

			System.out.println("Select an optional proficiency:");
			int index = 0;
			for (String[] item : value) {
				if (Integer.parseInt(item[3]) == 0) {
					System.out.println(index + " " + item[2]);
				}
				index++;
			}

			Scanner input = new Scanner(System.in);
			option = Integer.parseInt(input.nextLine());
			if (option >= value.size()) {
				System.out.println("Not valid selection");
			} else {
				output = value.get(option)[2];
				done = true;
			}
		}

		return output;
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

	public ArrayList<String> getProficiency() {
		return proficiency;
	}

	public ArrayList<String> getResistance() {
		return resistance;
	}

	public ArrayList<String> getImmunity() {
		return immunity;
	}
}
