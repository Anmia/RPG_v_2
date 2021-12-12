package Character.Race;

public class Race_Elf extends Race {
	public Race_Elf() {
		super.id = 102;
		super.name = "Elf";
		super.darkVision = true;
		super.size = 'm';

		super.proficiency.add("battleaxe");
		super.proficiency.add("handaxe");
		super.proficiency.add("light hammer");
		super.proficiency.add("warhammer");

		super.proficiencyOptions.add("smith-tools");
		super.proficiencyOptions.add("brewer-tools");
		super.proficiencyOptions.add("mason-tools");

		super.setProficiency();
		int[] temp = {0, 2, 0, 0, 0, 0};
		super.setAttributes(temp);
	}
}
