
/* Version -9999.9 :P
 * Faith Matthew
 */

import java.util.HashMap;
import java.util.Scanner;

public class RPGCharacterMaker {

	int pStrength;
	int pDexterity;
	int pWisdom;
	int pIntellect;
	int pCharisma;
	int pConstitution;
	
	String pClass;

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
	
	private static void listStats(RPGCharacterMaker obj){
			System.out.println("Charisma: " +obj.pCharisma); 
			System.out.println("Strength: " +obj.pStrength); System.out.println("Dex: " +obj.pDexterity);
			System.out.println("Wisdom: " +obj.pWisdom); 
			System.out.println("Constitution: " +obj.pConstitution); 
			System.out.println("Intellect: " +obj.pIntellect);
		
	}

	private static void assignRace(RPGCharacterMaker obj) {
		
		RPGCharacterMaker player = obj;

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
		
		System.out.println("Please select one of the races above ");
		
		Scanner sc= new Scanner(System.in);
		
		String chosenRace = sc.next();
		
	
		
		if(!chosenRace.isEmpty())
			System.out.println(races.get(chosenRace));
			System.out.println("\n Look at another class? Yes | No");
			String cont = sc.next();
				if(cont.equalsIgnoreCase("Yes")){
					assignRace(player);
				}
				
				if(cont.equalsIgnoreCase("no")){
					System.out.println("\n Select this class? [" + chosenRace+"]");
						String selectClass = sc.next();
						
						if(selectClass.equalsIgnoreCase("yes")){
							player.pClass=chosenRace;
							System.out.println("\n [" + chosenRace + "] has been selected as your class");
							raceStatModification(player);
						
						}
						
						if(selectClass.equalsIgnoreCase("no")){
							assignRace(player);
						}
				}
					
					
	}

	private static void raceStatModification(RPGCharacterMaker player) {
		
		System.out.println("\n Your previous stats were... ");
		listStats(player);
		
		switch(player.pClass.toLowerCase()){
		
		case "centaur":
				player.pStrength+=2;
				player.pWisdom+=1;
				break;
		
		
		case "bugbear":
				player.pStrength += 2;
				player.pDexterity +=1;
				break;
			
		case "aarakocra":
				player.pDexterity+=2;
				player.pWisdom+=1;
				break;
		
		case "aasimar": 
				player.pCharisma+=2;
				break;
		}
		
		System.out.println("\n Your new stats are... ");
		listStats(player);
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
				obj.pDexterity = stats[i];
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
		
		RPGCharacterMaker you = new RPGCharacterMaker();
		rollStats();
		 assignStats(stats, you);

		

		// assignClass();
		assignRace(you);
		System.out.println(you.pClass);

	}
}
