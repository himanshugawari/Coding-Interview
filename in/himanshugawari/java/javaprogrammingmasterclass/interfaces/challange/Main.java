package in.himanshugawari.java.javaprogrammingmasterclass.interfaces.challange;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Player tim = new Player("tim", 10, 15);
		System.out.println(tim.toString());
		saveObject(tim);

		tim.setHitPoints(8);
		System.out.println(tim);
		tim.setWaepon("StormBringer");
		saveObject(tim);
		// loadObject(tim);
		System.out.println(tim);

		ISaveable warewolf = new Monster("warewolf", 20, 40);
		System.out.println(warewolf);
		System.out.println(((Monster) warewolf).getStrength());
		saveObject(warewolf);
		loadObject(warewolf);
		System.out.println(warewolf);

	}

	public static List<String> readValues() {
		List<String> values = new ArrayList<String>();

		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		@SuppressWarnings("unused")
		int index = 0;
		System.out.println("Choose \n" + "1 to enter a string \n" + "0 to quit");
		while (!quit) {
			System.out.println("Choose a option: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 0:
				quit = true;
				break;
			case 1:
				System.out.println("Enter a string: ");
				String s = sc.next();
				values.add(s);
				index++;
				break;
			}
		}
		sc.close();
		return values;
	}

	public static void saveObject(ISaveable objectToSave) {
		for (int i = 0; i < objectToSave.write().size(); i++) {
			System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
		}
	}

	public static void loadObject(ISaveable objectToLoad) {
		List<String> values = readValues();
		objectToLoad.read(values);
	}

}
