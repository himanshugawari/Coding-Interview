package in.himanshugawari.java.javaprogrammingmasterclass.streams;

/**
 * @author himanshu
 *
 */
public class Challange1 {
	public static void main(String[] args) {

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("------------------");
				String myString = "let's split this up into an array";
				String[] parts = myString.split(" ");
				for (String part : parts) {
					System.out.println(part);
				}
			}
		}).start();

		Runnable runnable1 = () -> {
			System.out.println("------------------");
			String myString = "let's split this up into an array";
			String[] parts = myString.split(" ");
			for (String part : parts) {
				System.out.println(part);
			}
		};
		new Thread(runnable1).start();
	}
}
