package Character.Classes;

import Functionality.CharacterSetup;
import Functionality.CheckParse;
import Functionality.ConfirmChoice;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C_Jobb {
	protected ArrayList<String> proficiency = new ArrayList<>();
	protected ArrayList<String> proficiencyOptions = new ArrayList<>();
	protected ArrayList<String> resistance = new ArrayList<>();
	protected ArrayList<String> immunity = new ArrayList<>();

	protected boolean[] savingThrows = {false, false, false, false, false, false};

	protected Map<String, Boolean> skills = CharacterSetup.skillProficiencyCreate();
	protected ArrayList<String> skillOptions = new ArrayList<>();

	protected int id;
	protected String name;
	protected int hitDice;


	public C_Jobb() {
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

	public ArrayList<String> getProficiencyOptions() {
		return proficiencyOptions;
	}

	public ArrayList<String> getResistance() {
		return resistance;
	}

	public ArrayList<String> getImmunity() {
		return immunity;
	}

	public Map<String, Boolean> getSkills() {
		return skills;
	}

	public ArrayList<String> getSkillOptions() {
		return skillOptions;
	}

	public boolean[] getSavingThrows() {
		return savingThrows;
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
						done = ConfirmChoice.confirmChoice();
					} else {
						System.out.println("Please select a valid option!");
					}
				} else {
					System.out.println("Please select a valid option!");
				}
			}
		}

	}

	public void setSkills() {
		boolean done = false;
		while (!done) {
			int skill1 = 99;
			int skill2 = 99;

			boolean first = false;

			while (!first) {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Select first skill from the below list:");
				for (int i = 0; i < skillOptions.size(); i++) {
					System.out.println(i + " - " + skillOptions.get(i));
				}

				String selection = scanner.nextLine();

				if (CheckParse.isInt(selection)) {
					if (-1 < Integer.parseInt(selection) &&  Integer.parseInt(selection) < skillOptions.size()) {
						skill1 = Integer.parseInt(selection);
						first = true;
					} else {
						System.out.println("Please select a valid option!");
					}
				} else {
					System.out.println("Please select a valid option!");
				}
			}

			boolean second = false;

			while (!second) {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Select second skill from the below list:");

				for (int i = 0; i < skillOptions.size(); i++) {
					if (i != skill1) {
						System.out.println(i + " - " + skillOptions.get(i));
					}
				}

				String selection = scanner.nextLine();

				if (CheckParse.isInt(selection)) {
					if (-1 < Integer.parseInt(selection) &&  Integer.parseInt(selection) < skillOptions.size() && Integer.parseInt(selection) != skill1) {
						skill2 = Integer.parseInt(selection);
						second = true;
					} else {
						System.out.println("Please select a valid option!");
					}
				} else {
					System.out.println("Please select a valid option!");
				}
			}

			if (first && second) {
				System.out.println("You have selected: \n" +
						skillOptions.get(skill1) + "\n" +
						skillOptions.get(skill2));

				if (ConfirmChoice.confirmChoice()) {
					skills.replace(skillOptions.get(skill1), true);
					skills.replace(skillOptions.get(skill2), true);

					done = true;
				}
			}

		}
	}
}
