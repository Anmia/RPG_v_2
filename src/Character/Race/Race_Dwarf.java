package Character.Race;

import Functionality.CheckParse;
import Functionality.ConfirmChoice;

import java.util.Scanner;


public class Race_Dwarf extends Race {
	public Race_Dwarf() {
		super.id = 101;
		super.name = "Dwarf";
		super.darkVision = true;
		super.size = 'm';
		super.move = 25;

		super.proficiency.add("longsword");
		super.proficiency.add("shortsword");
		super.proficiency.add("shortbow");
		super.proficiency.add("longbow");

		super.proficiencyOptions.add("smith-tools");
		super.proficiencyOptions.add("brewer-tools");
		super.proficiencyOptions.add("mason-tools");

		super.resistance.add("poison");

		selectSubRace();

		super.setProficiency();
		int[] temp = {0, 0, 2, 0, 0, 0};
		super.setAttributes(temp);


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
							super.name = "Hill Dwarf";
							this.attributes[4] = 1;
							super.hpBonus = 1;
							break;
						case 1:
							super.name = "Mountain Dwarf";
							this.attributes[2] = 2;
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
