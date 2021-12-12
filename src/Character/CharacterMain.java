package Character;

import Character.Classes.C_Jobb;
import Character.Race.Race;
import Functionality.CharacterSetup;

import java.util.ArrayList;
import java.util.Map;

public class CharacterMain {
	private String name;

	private int[] attributes;
	private int[] attributesBonus = {0, 0, 0, 0, 0, 0};
	private int proficiencyBonus = 2;

	private Map<String, Boolean> skills = CharacterSetup.skillProficiencyCreate();

	private C_Jobb cClass;
	private Race race;

	private int xp = 15000; //Xp tracker
	private int level = 1; //Char level
	private int levelProcess = 1; //Used to track what level up process should be used in case of multi-leveling


	private final int hpBase;
	private int hp;
	private int hpTemp;

	private ArrayList<String> PROFICIENCIES = new ArrayList<>();
	private ArrayList<String> RESISTANCES = new ArrayList();
	private ArrayList<String> IMMUNITIES = new ArrayList<>();


	public CharacterMain(String name, int[] attributes, C_Jobb characterClass, Race race) {

		this.name = name;
		this.attributes = attributes;
		this.cClass = characterClass;
		this.race = race;

		{
			for (String item : race.getProficiency()) {
				if (!PROFICIENCIES.contains(item)) {
					PROFICIENCIES.add(item);
				}
			}

			for (String item : cClass.getProficiency()) {
				if (!PROFICIENCIES.contains(item)) {
					PROFICIENCIES.add(item);
				}
			}

			for (String item : race.getImmunity()) {
				if (!IMMUNITIES.contains(item)) {
					IMMUNITIES.add(item);
				}
			}

			for (String item : cClass.getImmunity()) {
				if (!IMMUNITIES.contains(item)) {
					IMMUNITIES.add(item);
				}
			}

			for (String item : race.getResistance()) {
				if (!RESISTANCES.contains(item)) {
					RESISTANCES.add(item);
				}
			}

			for (String item : cClass.getResistance()) {
				if (!RESISTANCES.contains(item)) {
					RESISTANCES.add(item);
				}
			}
		}

		hpBase = this.cClass.getHitDice() + this.attributesBonus[3] + this.race.getHpBonus();

		hp = hpBase;
		calculateAttributeBonus();

		setSkills(cClass.getSkills());
		// setSkills(race.getSkills()); // Not needed yet
	}

	private void setSkills(Map<String, Boolean> input) {
		for (Map.Entry<String, Boolean> item : input.entrySet()) {
			if (item.getValue()) {
				skills.replace(item.getKey(), true);
			}
		}
	}

	private void calculateAttributeBonus() {
		for (int i = 0; i < 6; i++) {
			switch (Math.abs(attributes[i] / 2)) {
				case 0:
					attributesBonus[i] = -5;
					break;
				case 1:
					attributesBonus[i] = -4;
					break;
				case 2:
					attributesBonus[i] = -3;
					break;
				case 3:
					attributesBonus[i] = -2;
					break;
				case 4:
					attributesBonus[i] = -1;
					break;
				case 5:
					attributesBonus[i] = 0;
					break;
				case 6:
					attributesBonus[i] = 1;
					break;
				case 7:
					attributesBonus[i] = 2;
					break;
				case 8:
					attributesBonus[i] = 3;
					break;
				case 9:
					attributesBonus[i] = 4;
					break;
				case 10:
					attributesBonus[i] = 5;
					break;
				case 11:
					attributesBonus[i] = 6;
					break;
				case 12:
					attributesBonus[i] = 7;
					break;
				case 13:
					attributesBonus[i] = 8;
					break;
				case 14:
					attributesBonus[i] = 9;
					break;
				case 15:
					attributesBonus[i] = 10;
					break;
			}
		}
	}

	public void increaseXP(int input) {
		this.xp += input;

		if (this.xp < 300) {
			level = 1;
			proficiencyBonus = 2;
		} else if (300 <= this.xp && this.xp < 900) {
			level = 2;
			proficiencyBonus = 2;
		} else if (900 <= this.xp && this.xp < 2700) {
			level = 3;
			proficiencyBonus = 2;
		} else if (2700 <= this.xp && this.xp < 6500) {
			level = 4;
			proficiencyBonus = 2;
		} else if (6500 <= this.xp && this.xp < 14000) {
			level = 5;
			proficiencyBonus = 3;
		} else if (14000 <= this.xp && this.xp < 23000) {
			level = 6;
		} else if (23000 <= this.xp && this.xp < 34000) {
			level = 7;
		} else if (34000 <= this.xp && this.xp < 48000) {
			level = 8;
		} else if (48000 <= this.xp && this.xp < 64000) {
			level = 9;
		} else if (64000 <= this.xp && this.xp < 85000) {
			level = 4;
		} else if (85000 <= this.xp && this.xp < 100000) {
			level = 10;
		} else if (100000 <= this.xp && this.xp < 120000) {
			level = 11;
		} else if (120000 <= this.xp && this.xp < 140000) {
			level = 12;
		} else if (140000 <= this.xp && this.xp < 165000) {
			level = 13;
		} else if (165000 <= this.xp && this.xp < 195000) {
			level = 14;
		} else if (195000 <= this.xp && this.xp < 225000) {
			level = 15;
		} else if (225000 <= this.xp && this.xp < 265000) {
			level = 16;
		} else if (265000 <= this.xp && this.xp < 305000) {
			level = 17;
		} else if (305000 <= this.xp && this.xp < 355000) {
			level = 18;
		} else if (355000 <= this.xp) {
			level = 19;
		}

		if (1 < level) {
			hp = hpBase + (level * ((cClass.getHitDice() / 2) + 1 + race.getHpBonus() + attributesBonus[2]));
		}
	}

	//Get functions for class


	public String getName() {
		return name;
	}

	public int[] getAttributes() {
		return attributes;
	}

	public int[] getAttributesBonus() {
		return attributesBonus;
	}

	public int getHp() {
		return hp;
	}

	// See if charcter has proficiency, immunity, or resistance
	public boolean hasProficiency(String input) {
		return PROFICIENCIES.contains(input);
	}

	public boolean hasImmunity(String input){
		return IMMUNITIES.contains(input);
	}

	public boolean hasResistance(String input){
		return RESISTANCES.contains(input);
	}

	public void printSheet() {
		String blanks = "                              ";
		String[] stringAtr = new String[6];
		for (int i = 0; i < 6; i++) {
			stringAtr[i] = "" + attributes[i];
		}

		String[] bonusAtr = new String[6];
		for (int i = 0; i < 6; i++) {
			if (attributesBonus[i] > -1 && attributesBonus[i] != 10) {
				bonusAtr[i] = " +" + attributesBonus[i];
			} else if (attributesBonus[i] == 10) {
				bonusAtr[i] = "+" + attributesBonus[i];
			} else {
				bonusAtr[i] = " " + attributesBonus[i];
			}
		}

		System.out.println(
				"╔═════════════════════════════╗\n" +
						"║ Name: " + this.name + blanks.substring(0, 22 - this.name.length()) + "║\n" +
						"╠═════════════════════════════╣\n" +
						"║ Race: " + this.race.getName() + blanks.substring(0, 22 - this.race.getName().length()) + "║\n" +
						"╠═════════════════════════════╣\n" +
						"║ Name: " + this.cClass.getName() + blanks.substring(0, 22 - this.cClass.getName().length()) + "║\n" +
						"╠══════════════╦══════════════╣\n" +
						"║ Str: " + blanks.substring(0, 2 - stringAtr[0].length()) + stringAtr[0] + "  " + bonusAtr[0] + " ║ Dex: " + blanks.substring(0, 2 - stringAtr[1].length()) + stringAtr[1] + "  " + bonusAtr[1] + " ║ \n" +
						"║ Con: " + blanks.substring(0, 2 - stringAtr[2].length()) + stringAtr[2] + "  " + bonusAtr[2] + " ║ Int: " + blanks.substring(0, 2 - stringAtr[3].length()) + stringAtr[3] + "  " + bonusAtr[3] + " ║ \n" +
						"║ Wis: " + blanks.substring(0, 2 - stringAtr[4].length()) + stringAtr[4] + "  " + bonusAtr[4] + " ║ Chr: " + blanks.substring(0, 2 - stringAtr[5].length()) + stringAtr[5] + "  " + bonusAtr[5] + " ║ \n" +
						"╠══════════════╩══════════════╣\n" +
						""
		);
	}

}
