package in.himanshugawari.java.javaprogrammingmasterclass.concurrency.thread1;

import static in.himanshugawari.java.javaprogrammingmasterclass.concurrency.thread1.ThreadColor.ANSI_BLUE;
import static in.himanshugawari.java.javaprogrammingmasterclass.concurrency.thread1.ThreadColor.ANSI_PURPLE;

public class Main {
	public static void main(String[] args) {
		System.out.println(ANSI_BLUE + "I'm in main thread");

		SecondThread secondThread = new SecondThread();
		secondThread.start();

		Thread secondThread1 = new SecondThread();
		secondThread1.start();

		// using anonymous class
		new Thread() {
			public void run() {
				System.out.println(ANSI_PURPLE + "I'm anonymous thread");
			};
		}.start();

		Thread thirdThread = new Thread() {
			public void run() {
				System.out.println("Testing!!!!!!");
			};
		};
		thirdThread.start();

		System.out.println(ANSI_BLUE + "Hi, I'm in main thread");
	}
}
