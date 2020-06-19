package in.himanshugawari.java.javaprogrammingmasterclass.concurrency.thread1;

import static in.himanshugawari.java.javaprogrammingmasterclass.concurrency.thread1.ThreadColor.ANSI_GREEN;

public class SecondThread extends Thread {
	@Override
	public void run() {
		System.out.println(ANSI_GREEN + "I'm in second thread");

	}
}
