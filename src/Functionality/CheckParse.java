package Functionality;

public class CheckParse {
	public static boolean isInt(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isLong(String input) {
		try {
			Long.parseLong(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isDouble(String input) {
		try {
			Double.parseDouble(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isByte(String input) {
		try {
			Byte.parseByte(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
