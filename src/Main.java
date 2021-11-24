import Character.*;
import Functionality.*;
import GamePlay.*;
import Items.*;
import Magic.*;

public class Main {
	public static void main(String[] args) {
		CharacterMain you = CharacterCreation.createChar();
		you.printSheet();
	}
}
