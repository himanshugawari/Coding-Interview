package in.himanshugawari.java.javaprogrammingmasterclass.collection.maps;

import java.util.HashMap;
import java.util.Map;

/**
 * @author himanshu
 *
 */
public class MapExample {
	public static void main(String[] args) {

		// Key are unique
		Map<String, String> languages = new HashMap<>();
		languages.put("Java", "a java language");
		languages.put("Python", "a python language");
		languages.put("Algol", "an algorithmic language");
		System.out.println(languages.put("BASIC", "Bedinners BASIC language"));
		System.out.println(languages.put("Lisp", "There in lies madness"));

		if (languages.containsKey("Java")) {
			System.out.println("Java is alreay Present.");
		} else {
			languages.put("Java", "a java language overriden");
		}
		System.out.println(languages.get("Java"));
		System.out.println("========================================");

//		print(languages);
//		languages.remove("Lisp");
//		print(languages);

		if (languages.remove("Algol", "an algorithmic language")) {
			System.out.println("Algol removed");
		} else {
			System.out.println("Algol not removed, key/value pair not found");
		}
		print(languages);

		System.out.println(languages.replace("Lisp", "a funciotnal language"));
		System.out.println(languages.replace("Scala", "this will not be added"));
		print(languages);
	}

	public static void print(Map<String, String> map) {
		map.keySet().forEach(key -> System.out.println(key + " : " + map.get(key)));

//		for (String key : map.keySet()) {
//			System.out.println(key + " : " + map.get(key));
//		}

		System.out.println("=================================================");
	}
}
