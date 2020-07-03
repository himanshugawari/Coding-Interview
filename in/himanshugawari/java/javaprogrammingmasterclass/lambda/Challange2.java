package in.himanshugawari.java.javaprogrammingmasterclass.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author himanshu
 *
 */
//capitalize first character of every name in list and print sorted list using stream
public class Challange2 {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Amelia", "Olivia", "emily", "Isla", "Ava", "oliver", "Jack", "Charlie",
				"harry", "Jacob");

		System.out.println("-----USing Stream------");
		names.stream().map(name -> name.substring(0, 1).toUpperCase() + name.substring(1)).sorted(String::compareTo)
				.forEach(System.out::println);
	}
}
