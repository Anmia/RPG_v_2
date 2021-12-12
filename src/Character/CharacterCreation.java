package Character;

import Character.Classes.CharacterClass;
import Character.Classes.CharacterClassFighter;
import Character.Race.Race;
import Character.Race.Race_Dwarf;
import Functionality.CheckParse;
import Functionality.ConfirmChoice;
import Functionality.Sort;

import java.util.*;

public class CharacterCreation {
	ArrayList<String> proficienciesList = new ArrayList<>();

	public static CharacterMain createChar() {
		Race race = selectRace();
		CharacterClass oClass = selectClass();




		String name = selectName();

		int[] attributes = attributes(race);


		CharacterMain you = new CharacterMain(
				name,
				attributes,
				oClass,
				race
		);
		return you;
	}

	private static CharacterClass selectClass() {
		boolean done = false;
		CharacterClass output = new CharacterClass();
		while (!done) {
			Scanner input = new Scanner(System.in);
			System.out.println("Select a class:\n" +
					"0: Fighter");


			String line = input.nextLine();

			if (CheckParse.isInt(line)) {
				int option = Integer.parseInt(line);

				switch (option) {
					case 0:
						output = new CharacterClassFighter();
						System.out.println("You chose class: Fighter");
						done = ConfirmChoice.confirmChoice();
						break;
					default:
						System.out.println("Not valid selection");
						break;
				}
			} else {
				System.out.println("Not valid selection");
			}
		}
		return output;
	}

	private static Race selectRace() {
		boolean done = false;

		Race output = new Race();

		while (!done) {
			Scanner input = new Scanner(System.in);
			System.out.println("Select a race: \n" +
					"0: Dwarf");


			String line = input.nextLine();

			if (CheckParse.isInt(line)) {
				int option = Integer.parseInt(line);

				switch (option) {
					case 0:
						System.out.println("You selected: Dwarf");
						done = ConfirmChoice.confirmChoice();
						output = new Race_Dwarf();
						break;
					default:
						System.out.println("Not valid selection");
						break;
				}
			} else {
				System.out.println("Not valid selection");
			}

		}

		return output;
	}

	private static String selectName() {
		boolean done = false;
		String name = "";
		while (!done) {
			Scanner input = new Scanner(System.in);
			System.out.println("Enter character name:");

			name = input.nextLine();

			System.out.println("Chosen name is: " + name);
			if (name.length() > 10) {
				System.out.println("Name has max length of 10!");
			} else {
				done = ConfirmChoice.confirmChoice();
			}


		}
		return name;
	}

	private static int[] attributes(Race race){
		boolean done = false;
		int[] output = new int[6];
		while (!done) {
			Scanner input = new Scanner(System.in);
			System.out.println("Select method: \n" +
					"1: Random \n" +
					"2: Input");

			switch (input.nextLine()) {
				case "1":
					output = randomArray();
					done = true;
					break;
				case "2":
					output = inputArray();
					done = true;
					break;
				default:
					System.out.println("Not valid selection!");
					break;
			}
		}

		for (int i = 0; i < 6; i++) {
			output[i] = output[i] + race.getAttributes()[i];
		}

		return output;
	}

	private static int[] randomArray() {
		boolean done = false;
		int [] output = new int[6];
		while (!done) {
			Random rand = new Random();
			String[] names = {"Str", "Dex", "Con", "Int", "Wis", "Cha"};
			int [] roll = {0, 0, 0, 0};



			for (int i = 0; i < 6; i++) {
				output[i] = 0;
				for (int j = 0; j < 4; j++) {
					roll[j] = rand.nextInt(6) + 1;
				}
				roll = Sort.bubblesort(roll);
				for (int j = 0; j < 3; j++) {
					output[i] += roll[j];
				}

				if (output[i] < 8) {
					output[i] = 0;
					i--;
				}
			}

			System.out.println("Your result is:");
			for (int i = 0; i < 6; i++) {
				System.out.println(names[i] + ": " + output[i]);
			}
			done = ConfirmChoice.confirmChoice();
		}
		return output;
	}

	private static int[] inputArray() {
		boolean done = false;
		int [] array = new int[6];

		while (!done) {
			String[] names = {"Str", "Dex", "Con", "Int", "Wis", "Cha"};
			for (int i = 0; i < 6; i++) {
				boolean atrDone = false;
				while (!atrDone) {
					Scanner atrInput = new Scanner(System.in);
					System.out.println("Input your " + names[i]);
					if (atrInput.hasNextInt()) {
						array[i] = Integer.parseInt(atrInput.nextLine());
						atrDone = true;
					} else {
						System.out.println("Valid input please!");
					}
				}
			}
			System.out.println("Your result is:");
			for (int i = 0; i < 6; i++) {
				System.out.println(names[i] + ": " + array[i]);
			}
			done = ConfirmChoice.confirmChoice();
		}
		return array;
	}

	private static void proficiencies (ArrayList<String> input) {

	}
}
