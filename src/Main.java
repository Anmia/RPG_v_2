import Character.*;
import Functionality.*;
import GamePlay.*;
import Items.*;
import Magic.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		CharacterMain you = CharacterCreation.createChar();
		you.printSheet();

	}
}
