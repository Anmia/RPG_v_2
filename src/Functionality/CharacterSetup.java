package Functionality;

import java.util.HashMap;
import java.util.Map;

public class CharacterSetup {
	public static Map<String, Boolean> skillProficiencyCreate() {
		Map<String, Boolean> output = new HashMap<>();
		output.put("athletics", false);

		output.put("acrobatics", false);
		output.put("sleight of hand", false);
		output.put("stealth", false);

		output.put("arcana", false);
		output.put("history", false);
		output.put("investigation", false);
		output.put("nature", false);
		output.put("religion", false);

		output.put("animal handling", false);
		output.put("insight", false);
		output.put("medicine", false);
		output.put("perception", false);
		output.put("survival", false);

		output.put("deception", false);
		output.put("intimidation", false);
		output.put("performance", false);
		output.put("persuasion", false);

		return output;
	}
}
