package in.himanshugawari.java.javaprogrammingmasterclass.concurrency.runnable1;

/**
 * @author himanshu
 *
 */
public class AnotherThread extends Thread {

	@Override
	public void run() {
		System.out.println("In " + currentThread().getName());

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Another Thread Woke Me Up");
		}

		System.out.println("Threee second have passed and I am AWAKE");
	}
}
