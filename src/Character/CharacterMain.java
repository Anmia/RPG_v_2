package Character;

public class CharacterMain {
	private static String name;
	private static int[] attributes;
	private static CharacterClass characterClass;
	private static CharacterRace race;
	private static int xp = 0;
	private static int level = 1;
	private static int levelProcess = 1; //Usedto track what level up process should be used in case of multi-leveling

	private int maxHp;


	public CharacterMain(String name, int[] attributes, CharacterClass characterClass, CharacterRace race) {
		this.name = name;
		this.attributes = attributes;
		this.characterClass = characterClass;
		this.race = race;

		this.maxHp = this.characterClass.getHitDice() + this.attributes[3];
	}

	public void printSheet() {
		String blanks = "                       ";
		String[] stringAtr = new String[6];
		for (int i = 0; i < 6; i++) {
			stringAtr[i] = "" + attributes[i];
		}

		System.out.println(
				"╔═══════════════════╗\n" +
						"║ Name: " + name + blanks.substring(0, 12 - name.length()) + "║\n" +
						"╠═══════════════════╣\n" +
						"║ Name: " + race.getName() + blanks.substring(0, 12 - race.getName().length()) + "║\n" +
						"╠═══════════════════╣\n" +
						"║ Name: " + characterClass.getName() + blanks.substring(0, 12 - characterClass.getName().length()) + "║\n" +
						"╠═════════╦═════════╣\n" +
						"║ Str: " + blanks.substring(0, 2 - stringAtr[0].length()) + stringAtr[0] + " ║ Dex: " + blanks.substring(0, 2 - stringAtr[1].length()) + stringAtr[1] + " ║ \n" +
						"║ Str: " + blanks.substring(0, 2 - stringAtr[2].length()) + stringAtr[2] + " ║ Dex: " + blanks.substring(0, 2 - stringAtr[3].length()) + stringAtr[3] + " ║ \n" +
						"║ Str: " + blanks.substring(0, 2 - stringAtr[4].length()) + stringAtr[4] + " ║ Dex: " + blanks.substring(0, 2 - stringAtr[5].length()) + stringAtr[5] + " ║ \n" +
						"╠═════════╩═════════╣\n" +
						""
		);
	}

}
