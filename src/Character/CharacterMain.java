package Character;

import Character.Classes.CharacterClass;
import Character.Race.Race;
import Functionality.ReadFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CharacterMain {
	private String name;
	private int[] attributes;
	private CharacterClass characterClass;
	private Race race;
	private int xp = 0; //Xp tracker
	private int level = 1; //Char level
	private int levelProcess = 1; //Used to track what level up process should be used in case of multi-leveling

	private int maxHp;

	private Map<String, Boolean> PROFICIENCIES = new HashMap<>();
	private Map<String, Boolean> RESISTANCES = new HashMap<>();
	private Map<String, Boolean> IMMUNITIES = new HashMap<>();


	public CharacterMain(String name, int[] attributes, CharacterClass characterClass, Race race) {

		this.name = name;
		this.attributes = attributes;
		this.characterClass = characterClass;
		this.race = race;

		this.fillProficienciesMap();

		this.maxHp = this.characterClass.getHitDice() + this.attributes[3];
	}

	private void fillProficienciesMap() {
		ArrayList<String> raceList = this.race.getProficiency();
		ArrayList<String> classList = this.characterClass.getProficiency();

		for (String item : raceList) {
			try {
				this.PROFICIENCIES.put(item, true);
			} catch (Exception e) {

			}

		}

		for (String item : classList) {
			try {
				this.PROFICIENCIES.put(item, true);
			} catch (Exception e) {

			}
		}
	}

	public void increaseXP(int input) {
		this.xp += input;

		if (this.xp < 300) {
			level = 1;
		} else if (300 <= this.xp && this.xp < 900) {
			level = 2;
		} else if (900 <= this.xp && this.xp < 2700) {
			level = 3;
		} else if (2700 <= this.xp && this.xp < 6500) {
			level = 4;
		}

	}

	public boolean hasProficiency(String input) {
		try {
			return PROFICIENCIES.get(input);
		} catch (Exception e) {
			return false;
		}
	}

	public void printSheet() {
		String blanks = "                       ";
		String[] stringAtr = new String[6];
		for (int i = 0; i < 6; i++) {
			stringAtr[i] = "" + attributes[i];
		}

		System.out.println(PROFICIENCIES.toString());

		System.out.println(
				"╔═══════════════════╗\n" +
						"║ Name: " + this.name + blanks.substring(0, 12 - this.name.length()) + "║\n" +
						"╠═══════════════════╣\n" +
						"║ Race: " + this.race.getName() + blanks.substring(0, 12 - this.race.getName().length()) + "║\n" +
						"╠═══════════════════╣\n" +
						"║ Name: " + this.characterClass.getName() + blanks.substring(0, 12 - this.characterClass.getName().length()) + "║\n" +
						"╠═════════╦═════════╣\n" +
						"║ Str: " + blanks.substring(0, 2 - stringAtr[0].length()) + stringAtr[0] + " ║ Dex: " + blanks.substring(0, 2 - stringAtr[1].length()) + stringAtr[1] + " ║ \n" +
						"║ Con: " + blanks.substring(0, 2 - stringAtr[2].length()) + stringAtr[2] + " ║ Int: " + blanks.substring(0, 2 - stringAtr[3].length()) + stringAtr[3] + " ║ \n" +
						"║ Wis: " + blanks.substring(0, 2 - stringAtr[4].length()) + stringAtr[4] + " ║ Chr: " + blanks.substring(0, 2 - stringAtr[5].length()) + stringAtr[5] + " ║ \n" +
						"╠═════════╩═════════╣\n" +
						""
		);
	}

}
