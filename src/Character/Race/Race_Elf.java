package Character.Race;

import Functionality.CheckParse;
import Functionality.ConfirmChoice;

import java.util.Scanner;

public class Race_Elf extends Race {
	public Race_Elf() {
		id = 102;
		name = "Elf";
		darkVision = true;
		darkVisionRange = 60;

		size = 'm';
		move = 30;

		int[] temp = {0, 2, 0, 0, 0, 0};
		setAttributes(temp);
		selectSubRace();
	}

	private void selectSubRace() {
		boolean done = false;
		while (!done) {
			Scanner input = new Scanner(System.in);
			System.out.println("Select a sub-race: \n" +
					"0: High Elf \n" +
					"1: Wood Elf \n" +
					"2: Drow");


			String line = input.nextLine();

			if (CheckParse.isInt(line)) {
				int option = Integer.parseInt(line);

				switch (option) {
					case 0:
						System.out.println("You selected: High Elf");
						done = ConfirmChoice.confirmChoice();
						break;
					case 1:
						System.out.println("You selected: Wood Elf");
						done = ConfirmChoice.confirmChoice();
						break;
					case 2:
						System.out.println("You selected: Drow");
						done = ConfirmChoice.confirmChoice();
						break;
					default:
						System.out.println("Not valid selection");
						break;
				}

				if(done) {
					switch (option) {
						case 0:
							name = "High Elf";
							attributes[5] = 1;
							proficiency.add("longsword");
							proficiency.add("shortsword");
							proficiency.add("shortbow");
							proficiency.add("longbow");
							break;
						case 1:
							name = "Wood Elf";
							attributes[4] = 2;
							move = 35;
							proficiency.add("longsword");
							proficiency.add("shortsword");
							proficiency.add("shortbow");
							proficiency.add("longbow");
							break;
						case 2:
							attributes[5] = 1;
							darkVisionRange = 120;
							proficiency.add("rapier");
							proficiency.add("shortsword");
							proficiency.add("crossbow");
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
