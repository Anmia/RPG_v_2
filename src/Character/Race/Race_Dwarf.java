package Character.Race;

import Functionality.CheckParse;
import Functionality.ConfirmChoice;

import java.util.Scanner;


public class Race_Dwarf extends Race {
	public Race_Dwarf() {
		id = 101;
		name = "Dwarf";

		darkVision = true;
		darkVisionRange = 60;

		size = 'm';
		move = 25;

		proficiency.add("battleaxe");
		proficiency.add("handaxe");
		proficiency.add("light hammer");
		proficiency.add("warhammer");

		proficiencyOptions.add("smith's tools");
		proficiencyOptions.add("brewer's tools");
		proficiencyOptions.add("mason's tools");

		resistance.add("poison");

		int[] temp = {0, 0, 2, 0, 0, 0};
		setAttributes(temp);
		selectSubRace();
	}

	private void selectSubRace() {
		boolean done = false;
		while (!done) {
			Scanner input = new Scanner(System.in);
			System.out.println("Select a sub-race: \n" +
					"0: Hill Dwarf \n" +
					"1: Mountain Dwarf");


			String line = input.nextLine();

			if (CheckParse.isInt(line)) {
				int option = Integer.parseInt(line);

				switch (option) {
					case 0:
						System.out.println("You selected: Hill Dwarf");
						done = ConfirmChoice.confirmChoice();
						break;
					case 1:
						System.out.println("You selected: Mountain Dwarf");
						done = ConfirmChoice.confirmChoice();
						break;
					default:
						System.out.println("Not valid selection");
						break;
				}

				if(done) {
					switch (option) {
						case 0:
							name = "Hill Dwarf";
							attributes[4] = 1;
							hpBonus = 1;
							break;
						case 1:
							name = "Mountain Dwarf";
							attributes[0] = 2;
							proficiency.add("medium armour");
							proficiency.add("light armour");
							break;
						default:
							System.out.println("Not valid selection");
							break;
					}
				}
			} else {
				System.out.println("Not valid selection");
			}
		}
	}
}
