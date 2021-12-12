package Character.Classes;

public class Class_Barbarian extends C_Jobb {
	public Class_Barbarian() {
		id = 101;
		name = "Barbarian";
		hitDice = 12;

		proficiency.add("light armour");
		proficiency.add("medium armour");
		proficiency.add("shield");
		proficiency.add("simple weapons");
		proficiency.add("martial weapons");

		savingThrows[0] = true;
		savingThrows[2] = true;

		skillOptions.add("animal handling");
		skillOptions.add("athletics");
		skillOptions.add("intimidation");
		skillOptions.add("nature");
		skillOptions.add("perception");
		skillOptions.add("survival");
	}
}
