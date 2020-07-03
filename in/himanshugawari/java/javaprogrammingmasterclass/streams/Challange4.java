package in.himanshugawari.java.javaprogrammingmasterclass.streams;

import java.util.function.Supplier;

/**
 * @author himanshu
 *
 */
public class Challange4 {
	public static void main(String[] args) {
		Supplier<String> iLoveJava = () -> "I Love Java";

		Supplier<String> iLoveJava1 = () -> {
			return "I Love Java";
		};

		String supplierResult = iLoveJava.get();
		System.out.println(supplierResult);

		String supplierResult1 = iLoveJava1.get();
		System.out.println(supplierResult1);
	}
}
