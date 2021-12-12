package Character.Classes;

public class Class_Fighter extends C_Jobb {
	public Class_Fighter() {
		id = 105;
		name = "Fighter";
		hitDice = 10;

		proficiency.add("light armour");
		proficiency.add("medium armour");
		proficiency.add("heavy armour");
		proficiency.add("shield");
		proficiency.add("simple weapons");
		proficiency.add("martial weapons");

		savingThrows[0] = true;
		savingThrows[2] = true;

		skillOptions.add("acrobatics");
		skillOptions.add("animal handling");
		skillOptions.add("athletics");
		skillOptions.add("history");
		skillOptions.add("insight");
		skillOptions.add("intimidation");
		skillOptions.add("perception");
		skillOptions.add("survival");
	}


}
