package in.himanshugawari.java.javaprogrammingmasterclass.immutable;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author himanshu
 *
 */
public class ImmutableClass {
	private final static Scanner sc = new Scanner(System.in);

	private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

	public static void main(String[] args) {
		Map<String, Integer> tempExit = new HashMap<String, Integer>();
		// if null is passed instead of tempExit
		// the program crashes with null pointer exception
		// locations.put(0, new Location(0, "You are sitting in front of your computer
		// learning java", null));

		locations.put(0, new Location(0, "You are sitting in front of your computer learning java", tempExit));

		tempExit = new HashMap<String, Integer>();
		tempExit.put("W", 2);
		tempExit.put("E", 3);
		tempExit.put("S", 4);
		tempExit.put("N", 5);
		locations.put(1,
				new Location(1, "You are standing at the end of a road before a small brick building", tempExit));

		tempExit = new HashMap<String, Integer>();
		tempExit.put("N", 5);
		locations.put(2, new Location(2, "You are at the top of a hill", tempExit));

		tempExit = new HashMap<String, Integer>();
		tempExit.put("W", 1);
		locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExit));

		tempExit = new HashMap<String, Integer>();
		tempExit.put("N", 1);
		tempExit.put("W", 2);
		locations.put(4, new Location(4, "You are in a valley beside a stream", tempExit));

		tempExit = new HashMap<String, Integer>();
		tempExit.put("S", 1);
		tempExit.put("W", 2);
		locations.put(5, new Location(5, "You are in a forest", tempExit));

		Map<String, String> vocabulary = new HashMap<String, String>();
		vocabulary.put("QUIT", "Q");
		vocabulary.put("NORTH", "N");
		vocabulary.put("SOUTH", "S");
		vocabulary.put("EAST", "E");
		vocabulary.put("WEST", "W");

		try {
			int loc = 1;
			while (true) {
				System.out.println(locations.get(loc).getDescription());
				if (loc == 0) {
					break;
				}
				Map<String, Integer> exits = locations.get(loc).getExits();
				System.out.print("Available exits are ");
				exits.keySet().forEach(exit -> System.out.print(exit + ", "));
				System.out.println();
				String direction = sc.nextLine().toUpperCase();
				if (direction.length() > 1) {
					String[] words = direction.split(" ");
					for (String word : words) {
						if (vocabulary.containsKey(word)) {
							direction = vocabulary.get(word);
							break;
						}
					}
				}
				if (exits.containsKey(direction)) {
					loc = exits.get(direction);
				} else {
					System.out.println("you cannot go in that direction");
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

	}
}

final class Location {
	private final int locationId;
	private final String description;
	private final Map<String, Integer> exits;

	public Location(int locationId, String description, Map<String, Integer> exits) {
		super();
		this.locationId = locationId;
		this.description = description;
		this.exits = new HashMap<String, Integer>(exits);
		this.exits.put("Q", 0);
	}

	public int getLocationId() {
		return locationId;
	}

	public String getDescription() {
		return description;
	}

	public Map<String, Integer> getExits() {
		return new HashMap<String, Integer>(exits);
	}

}
