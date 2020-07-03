package in.himanshugawari.java.javaprogrammingmasterclass.streams;

import java.util.function.Function;

/**
 * @author himanshu
 *
 */
public class Challange2 {
	public static void main(String[] args) {

		System.out.println(eveySecondChar("0123456789"));

		Function<String, String> ans = source -> {
			StringBuilder returnVAl = new StringBuilder();
			for (int i = 0; i < source.length(); i++) {
				if (i % 2 == 1) {
					returnVAl.append(source.charAt(i));
				}
			}
			return new String(returnVAl);
		};
		System.out.println(ans.apply("0123456789"));
	}

	public static String eveySecondChar(String source) {
		StringBuilder returnVAl = new StringBuilder();
		for (int i = 0; i < source.length(); i++) {
			if (i % 2 == 1) {
				returnVAl.append(source.charAt(i));
			}
		}
		return new String(returnVAl);
	}
}
