package Character.Classes;

import Functionality.CheckParse;
import Functionality.ReadFile;

import java.util.ArrayList;
import java.util.Scanner;

public class CharacterClass {
	protected ArrayList<String> proficiency = new ArrayList<>();
	protected ArrayList<String> proficiencyOptions = new ArrayList<>();
	protected ArrayList<String> resistance = new ArrayList<>();
	protected ArrayList<String> immunity = new ArrayList<>();

	protected int id;
	protected String name;
	protected int hitDice;


	public CharacterClass() {
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

	protected void setProficiency() {
		if (proficiencyOptions.size() != 0) {
			boolean done = false;
			while (!done) {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Select a proficiency from the below list:");

				for (int i = 0; i < proficiencyOptions.size(); i++) {
					System.out.println(i + " - " + proficiencyOptions.get(i));
				}

				String selection = scanner.nextLine();

				if (CheckParse.isInt(selection)) {
					if (-1 < Integer.parseInt(selection) &&  Integer.parseInt(selection) < proficiencyOptions.size()) {
						proficiency.add(proficiencyOptions.get(Integer.parseInt(selection)));
						done = true;
					} else {
						System.out.println("Please select a valid option!");
					}
				} else {
					System.out.println("Please select a valid option!");
				}

			}
		}

	}
}
