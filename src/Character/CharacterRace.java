package Character;

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

			option = Integer.parseInt(input.nextLine());
			
			if (option >= races.size()) {
				System.out.println("Not valid selection");
			} else {
				selection = option;
				done = true;
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
}
