package Character.Classes;

import java.util.ArrayList;

public class CharacterClassFighter extends CharacterClass {
	public CharacterClassFighter() {
		super.id = 101;
		super.name = "Fighter";
		super.hitDice = 10;

		super.proficiency.add("light armour");
		super.proficiency.add("medium armour");
		super.proficiency.add("heavy armour");
		super.proficiency.add("shield");

		if (super.proficiencyOptions.size() != 0) {
			super.setProficiency();
		}
	}


}
