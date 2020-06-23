package in.himanshugawari.java.javaprogrammingmasterclass.concurrency.interruptandjoin;

public class AnotherThread extends Thread {

	@Override
	public void run() {
		System.out.println("In " + currentThread().getName());

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("ANother Thread Woke Me UP!!!");
			return;
		}

		System.out.println("Threee Seconds have passed I am AWAKE");
	}
}
