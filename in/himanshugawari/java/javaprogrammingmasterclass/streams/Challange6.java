package in.himanshugawari.java.javaprogrammingmasterclass.streams;

import java.util.Arrays;
import java.util.List;

//capitalize first character of every name in list and print sorted list using stream
/**
 * @author himanshu
 *
 */
public class Challange6 {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Amelia", "Olivia", "emily", "Isla", "Ava", "oliver", "Jack", "Charlie",
				"harry", "Jacob");

		System.out.println("-----USing Stream------");
		names.stream().map(name -> name.substring(0, 1).toUpperCase() + name.substring(1)).sorted(String::compareTo)
				.forEach(System.out::println);

		long namesBeginingWithA = names.stream().map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
				.filter(name -> name.startsWith("A")).count();
		System.out.println("Number of names begining with A is : " + namesBeginingWithA);

	}
}