package Character;

import java.util.ArrayList;

public class CharacterMain {
	private String name;
	private int[] attributes;
	private CharacterClass characterClass;
	private CharacterRace race;
	private int xp = 0;
	private int level = 1;
	private int levelProcess = 1; //Usedto track what level up process should be used in case of multi-leveling

	private int maxHp;


	public CharacterMain(String name, int[] attributes, CharacterClass characterClass, CharacterRace race) {
		this.name = name;
		this.attributes = attributes;
		this.characterClass = characterClass;
		this.race = race;

		this.maxHp = this.characterClass.getHitDice() + this.attributes[3];
	}

	public boolean hasProficiency(String proficiency) {
		boolean output = false;
		ArrayList<String> raceProf = race.getProficiency();
		for (String item : raceProf) {
			if (item.contains(proficiency)){
				output = true;
			}
		}
		ArrayList<String> classProf = characterClass.getProficiency();
		for (String item : classProf) {
			if (item.contains(proficiency)){
				output = true;
			}
		}
		return output;
	}

	public void printSheet() {
		String blanks = "                       ";
		String[] stringAtr = new String[6];
		for (int i = 0; i < 6; i++) {
			stringAtr[i] = "" + attributes[i];
		}

		System.out.println(
				"╔═══════════════════╗\n" +
						"║ Name: " + this.name + blanks.substring(0, 12 - this.name.length()) + "║\n" +
						"╠═══════════════════╣\n" +
						"║ Name: " + this.race.getName() + blanks.substring(0, 12 - this.race.getName().length()) + "║\n" +
						"╠═══════════════════╣\n" +
						"║ Name: " + this.characterClass.getName() + blanks.substring(0, 12 - this.characterClass.getName().length()) + "║\n" +
						"╠═════════╦═════════╣\n" +
						"║ Str: " + blanks.substring(0, 2 - stringAtr[0].length()) + stringAtr[0] + " ║ Dex: " + blanks.substring(0, 2 - stringAtr[1].length()) + stringAtr[1] + " ║ \n" +
						"║ Str: " + blanks.substring(0, 2 - stringAtr[2].length()) + stringAtr[2] + " ║ Dex: " + blanks.substring(0, 2 - stringAtr[3].length()) + stringAtr[3] + " ║ \n" +
						"║ Str: " + blanks.substring(0, 2 - stringAtr[4].length()) + stringAtr[4] + " ║ Dex: " + blanks.substring(0, 2 - stringAtr[5].length()) + stringAtr[5] + " ║ \n" +
						"╠═════════╩═════════╣\n" +
						""
		);
	}

}
