package in.himanshugawari.java.javaprogrammingmasterclass.collection.setsandhashset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author himanshu
 *
 */
public class SetTheoryMain {
	public static void main(String[] args) {

		Set<Integer> squares = new HashSet<>();
		Set<Integer> cubes = new HashSet<>();

		for (int i = 1; i <= 100; i++) {
			squares.add(i * i);
			cubes.add(i * i * i);
		}

		System.out.println("There are " + squares.size() + " squares and " + cubes.size() + " cubes.");

		// A U B
		Set<Integer> union = new HashSet<Integer>(squares);
		union.addAll(cubes);
		System.out.println("The union contains " + union.size() + " elements.");

		Set<Integer> intersection = new HashSet<Integer>(squares);
		intersection.retainAll(cubes);
		System.out.println("The intersection contains " + intersection.size() + " elements.");

		Set<String> words = new HashSet<String>();
		String sentence = "one day in the year of the fox";
		String[] arrayWords = sentence.split(" ");
		words.addAll(Arrays.asList(arrayWords));
		words.forEach(word -> System.out.println(word));

		Set<String> nature = new HashSet<String>();
		Set<String> divine = new HashSet<String>();
		String[] natureWords = { "all", "nature", "is", "but", "art", "unknown", "to", "thee" };
		nature.addAll(Arrays.asList(natureWords));
		String[] divineWords = { "to", "err", "is", "human", "to", "forgive", "divine" };
		divine.addAll(Arrays.asList(divineWords));
		System.out.println("nature - divine");
		Set<String> diff1 = new HashSet<String>(nature);
		diff1.removeAll(divine);
		print(diff1);
		System.out.println("divine - nature");
		Set<String> diff2 = new HashSet<String>(divine);
		diff2.removeAll(nature);
		print(diff2);

		Set<String> unionTest = new HashSet<String>(nature);
		unionTest.addAll(divine);
		Set<String> intersectionTest = new HashSet<String>(nature);
		intersectionTest.retainAll(divine);
		System.out.println("Symmetric difference");
		unionTest.removeAll(intersectionTest);
		print(unionTest);

		if (nature.containsAll(divine)) {
			System.out.println("divine is a subset of nature");
		}
		if (nature.containsAll(intersectionTest)) {
			System.out.println("intesection is a subset of nature");
		}
		if (divine.containsAll(intersectionTest)) {
			System.out.println("intesection is a subset of divine");
		}

	}

	private static void print(Set<String> set) {
		System.out.print("\t");
		set.forEach(s -> System.out.print(s + " "));
		System.out.println();
	}
}
