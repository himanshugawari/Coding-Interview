package in.himanshugawari.java.javaprogrammingmasterclass.streams;

import java.util.function.Function;

/**
 * @author himanshu
 *
 */
public class Challange3 {
	public static void main(String[] args) {
		Function<String, String> lambdaFunction = source -> {
			StringBuilder returnVAl = new StringBuilder();
			for (int i = 0; i < source.length(); i++) {
				if (i % 2 == 1) {
					returnVAl.append(source.charAt(i));
				}
			}
			return new String(returnVAl);
		};

		String result = eveySecondChar(lambdaFunction, "0123456789");
		System.out.println(result);
	}

	public static String eveySecondChar(Function<String, String> func, String source) {
		return func.apply(source);
	}
}
