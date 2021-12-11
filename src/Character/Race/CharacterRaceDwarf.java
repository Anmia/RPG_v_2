package Character.Race;

public class CharacterRaceDwarf extends CharacterRace{
	public CharacterRaceDwarf() {
		super.id = 101;
		super.name = "Dwarf";
		super.size = 'm';

		super.proficiency.add("battleaxe");
		super.proficiency.add("handaxe");
		super.proficiency.add("light hammer");
		super.proficiency.add("warhammer");

		super.proficiencyOptions.add("smith-tools");
		super.proficiencyOptions.add("brewer-tools");
		super.proficiencyOptions.add("mason-tools");

		super.setProficiency();
	}
}
