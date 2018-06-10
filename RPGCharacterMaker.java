package charMaker;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Scanner;

public class RPGCharacterMaker {

	int pStrength;
	int pDex;
	int pWisdom;
	int pIntellect;
	int pCharisma;
	int pConstitution;

	private static int[] stats = new int[6];
	private static int[] stat = new int[4];

	private static void assignClass() {
		String[] classes = { "Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue",
				"Sorcerer", "Warlock", "Wizard" };

		System.out.println("Select one of the following classes. (Enter verbatim) ");
		for (int i = 0; i < classes.length; i++) {
			System.out.println(classes[i]);
		}
		Scanner sc = new Scanner(System.in);
		String chosenClass = sc.next();
	}

	private static void assignRace(RPGCharacterMaker obj) {

		HashMap<String, String> races = new HashMap<>();

		races.put("Aarakocra",
				"Sequestered in high mountains atop tall"
						+ "trees, the aarakocra, sometimes called birdfolk, evoke fear and wonder. ("
						+ "+2 Dexterity, +1 Wisdom)");
		races.put("Aasimar",
				"Aasimar are placed in the world to serve as guardians of "
						+ "law and good. Their patrons expect them to strike at evil, lead by "
						+ "example, and further the cause of justice. (+2 Charisma)");
		races.put("Bugbear",
				"Bugbears feature in the nightmare tales of many "
						+ "races — great, hairy beasts that creep through the shadows as "
						+ "quiet as cats. (+2 Strength, +1 Dexterity)");
		races.put("Centaur",
				"Roamers at heart, centaurs love open spaces and the " + "freedom to travel. (+2 Strength, +1 Wisdom)");
		// races.put(arg0, arg1)

		System.out.println(races.keySet());
	}

	private static void assignStats(int arr[], RPGCharacterMaker obj) {
		Scanner sc = new Scanner(System.in);

		// to be used for Quality of Life later. Allows user to know what stats
		// they havent assigned yet
		String[] statCats = { "strength", "dex", "charisma", "intellect", "constitution", "wisdom" };

		for (int i = 0; i < stats.length; i++) {
			System.out.println("What stat would you like to assign " + stats[i]
					+ " to? (Please type stat name correctly and in all lowercase letters");
			String chosenStat = sc.next();

			switch (chosenStat) {

			case "charisma":
				obj.pCharisma = stats[i];
				break;
			case "intellect":
				obj.pIntellect = stats[i];
				break;
			case "constitution":
				obj.pConstitution = stats[i];
				break;
			case "strength":
				obj.pStrength = stats[i];
				break;
			case "dex":
				obj.pDex = stats[i];
				break;
			case "wisdom":
				obj.pWisdom = stats[i];
				break;

			}
		}

	}

	private static int[] rollStats() {

		for (int k = 0; k < stats.length; k++) {
			int min = 6;
			int sum = 0;

			for (int i = 0; i < stat.length; i++) { // rolls 4 die, drops lowest
													// roll, and returns total
				stat[i] = (int) (Math.random() * 6 + 1); // of remaining rolls
				sum += stat[i];
				if (stat[i] < min)
					min = stat[i];
				System.out.print(stat[i]);
			}

			System.out.println("\n DROPPING LOWEST ROLL WHICH IS: " + min);
			System.out.println("YOUR STAT IS " + (sum - min));

			stats[k] = (sum - min);
		}
		System.out.print("Your unassigned stats are ");
		for (int i = 0; i < stats.length; i++) { // inputs newly computed stat
													// into stats arrau

			System.out.print(stats[i] + ", ");
		}
		return stats;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RPGCharacterMaker you = new RPGCharacterMaker();
		// rollStats();
		// assignStats(stats, you);

		/*
		 * System.out.println("Charisma: " +you.pCharisma); System.out.println(
		 * "Strength: " +you.pStrength); System.out.println("Dex: " +you.pDex);
		 * System.out.println("Wisdom: " +you.pWisdom); System.out.println(
		 * "Constitution: " +you.pConstitution); System.out.println(
		 * "Intellect: " +you.pIntellect);
		 */

		// assignClass();
		assignRace(you);

	}
}
