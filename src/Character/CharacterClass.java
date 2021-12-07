package Character;

import Functionality.CheckParse;
import Functionality.ReadFile;

import java.util.ArrayList;
import java.util.Scanner;

public class CharacterClass {
	private ArrayList<String> proficiency = new ArrayList<>();
	private ArrayList<String> resistance = new ArrayList<>();
	private ArrayList<String> immunity = new ArrayList<>();

	private int id;
	private String name;
	private int hitDice;

	public CharacterClass() {
		selectClass();
	}


	private void selectClass() {
		boolean done = false;
		ArrayList<String[]> oClass = ReadFile.readFile("./src/Character/listClass.txt");
		int selection = -1;

		while (!done) {
			Scanner input = new Scanner(System.in);
			System.out.println("Select a class:");
			for (int i = 0; i < oClass.size(); i++) {
				System.out.println(i + " " + oClass.get(i)[1]);
			}

			String line = input.nextLine();

			if (CheckParse.isInt(line)) {
				int option = Integer.parseInt(line);

				if (option >= oClass.size() || option < 0) {
					System.out.println("Not valid selection");
				} else {
					selection = option;
					done = true;
				}
			} else {
				System.out.println("Not valid selection");
			}

		}

		this.id = Integer.parseInt(oClass.get(selection)[0]);
		this.name = oClass.get(selection)[1];
		this.hitDice = Integer.parseInt(oClass.get(selection)[2]);

		//Proficiencies
		setProficiency();
		//Resistances

		//Immunities
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

	private void setProficiency() {
		ArrayList<String[]> input = ReadFile.readFile("./src/Character/listClassProficiency.txt", this.id + "");

		for (String[] item : input) {
			proficiency.add(item[1]);
		}
	}
}
