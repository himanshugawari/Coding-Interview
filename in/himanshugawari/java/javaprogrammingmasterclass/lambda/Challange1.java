package in.himanshugawari.java.javaprogrammingmasterclass.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author himanshu
 *
 */

//capitalize first character of every name in list and print sorted list
public class Challange1 {
	public static void main(String[] args) {

		List<String> names = Arrays.asList("Amelia", "Olivia", "emily", "Isla", "Ava", "oliver", "Jack", "Charlie",
				"harry", "Jacob");

		List<String> newNames = new ArrayList<String>();
		names.forEach(name -> newNames.add(name.substring(0, 1).toUpperCase() + name.substring(1)));

		System.out.println("----Before Sorting-------");
		for (String name : newNames) {
			System.out.println(name);
		}

		System.out.println("----After Sorting-------");
		// newNames.sort((s1, s2) -> s1.compareTo(s2));
		// newNames.forEach(s -> System.out.println(s));
		// OR
		newNames.sort(String::compareTo);
		newNames.forEach(System.out::println);

		System.out.println("-----USing Stream------");
		names.stream().map(name -> name.substring(0, 1).toUpperCase() + name.substring(1)).sorted(String::compareTo)
				.forEach(System.out::println);

	}
}
