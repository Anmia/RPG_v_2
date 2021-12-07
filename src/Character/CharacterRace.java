package Character;

import Functionality.CheckParse;
import Functionality.ReadFile;

import java.util.ArrayList;
import java.util.Scanner;

public class CharacterRace {
	private int id;
	private String name;
	private int[] attributes = new int[6];
	private boolean darkVision;
	private char size;

	private ArrayList<String> proficiency = new ArrayList<>();
	private ArrayList<String> resistance = new ArrayList<>();
	private ArrayList<String> immunity = new ArrayList<>();

	public CharacterRace() {
		selectRace();
	}

	private void selectRace() {
		boolean done = false;
		ArrayList<String[]> races = ReadFile.readFile("./src/Character/listRace.txt");
		int selection = -1;
		int option = 100;
		
		while (!done) {
			Scanner input = new Scanner(System.in);
			System.out.println("Select a race:");
			for (int i = 0; i < races.size(); i++) {
				System.out.println(i + " " + races.get(i)[1]);
			}

			String line = input.nextLine();

			if (CheckParse.isInt(line)) {
				option = Integer.parseInt(line);

				if (option >= races.size() || option < 0) {
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
		this.id = Integer.parseInt(races.get(selection)[0]);
		this.name = races.get(selection)[1];
		for (int i = 0; i < 6; i++) {
			this.attributes[i] = Integer.parseInt(races.get(selection)[i + 2]);
		}
		this.darkVision = 1 ==Integer.parseInt(races.get(selection)[8]);
		this.size = races.get(selection)[9].charAt(0);

		//Proficiencies
		setProficiency();
		//Resistances

		//Immunities
	}

	private static String selectProfOption(ArrayList<String[]> value) {
		String output = "";

		return output;
	}

	public String getName() {
		return name;
	}

	public int[] getAttributes() {
		return attributes;
	}

	public char getSize() {
		return size;
	}

	public boolean getDarkVision() {
		return darkVision;
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
		ArrayList<String[]> input = ReadFile.readFile("./src/Character/listRaceProficiency.txt", this.id + "");
		ArrayList<String[]> optional = new ArrayList<>();

		for (String[] item : input) {
			if (item[2].contains("1")) {
				proficiency.add(item[1]);
			} else {
				optional.add(item);
			}

		}

		if (optional.size() != 0) {
			boolean done = false;
			while (!done) {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Select a proficiency from the below list:");

				for (int i = 0; i < optional.size(); i++) {
					System.out.println(i + " - " + optional.get(i)[1]);
				}

				String selection = scanner.nextLine();

				if (CheckParse.isInt(selection)) {
					if (-1 < Integer.parseInt(selection) &&  Integer.parseInt(selection) < optional.size()) {
						proficiency.add(optional.get(Integer.parseInt(selection))[1]);
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
