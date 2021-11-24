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
		this.name = races.get(selection)[1];
		for (int i = 0; i < 6; i++) {
			this.attributes[i] = Integer.parseInt(races.get(selection)[i + 2]);
		}
		this.darkVision = 1 ==Integer.parseInt(races.get(selection)[8]);
		this.size = races.get(selection)[9].charAt(0);
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
}
