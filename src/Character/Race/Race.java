package Character.Race;

import Functionality.CheckParse;
import Functionality.ReadFile;

import java.util.ArrayList;
import java.util.Scanner;

public class Race {
	protected int id;
	protected String name;

	protected int[] attributes = new int[6];

	protected boolean darkVision;
	protected int darkVisionRange;

	protected int move;
	protected char size;

	protected int hpBonus = 0;

	protected ArrayList<String> proficiency = new ArrayList<>();
	protected ArrayList<String> proficiencyOptions = new ArrayList<>();
	protected ArrayList<String> resistance = new ArrayList<>();
	protected ArrayList<String> immunity = new ArrayList<>();

	public Race() {

	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int[] getAttributes() {
		return attributes;
	}

	public boolean getDarkVision() {
		return darkVision;
	}

	public int getDarkVisionRange() {
		return darkVisionRange;
	}

	public int getMove() {
		return move;
	}

	public char getSize() {
		return size;
	}

	public int getHpBonus() {
		return hpBonus;
	}

	public void setAttributes(int[] attributes) {
		this.attributes = attributes;
	}

	public ArrayList<String> getProficiency() {
		return proficiency;
	}

	public ArrayList<String> getProficiencyOptions() {
		return proficiencyOptions;
	}

	public ArrayList<String> getResistance() {
		return resistance;
	}

	public ArrayList<String> getImmunity() {
		return immunity;
	}



	public void setProficiency() {
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
