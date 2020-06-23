package in.himanshugawari.java.javaprogrammingmasterclass.concurrency.synchronization;

public class Main {
	public static void main(String[] args) {

		CountDown countDown = new CountDown();

		CountDownThread t1 = new CountDownThread(countDown);
		t1.setName("Thread 1");

		CountDownThread t2 = new CountDownThread(countDown);
		t2.setName("Thread 2");

		CountDownThread t3 = new CountDownThread(countDown);
		t3.setName("Thread 3");

		t1.start();
		t2.start();
		t3.start();
	}
}

class CountDown {

	/*
	 * public void doCountDown() { for (int i = 10; i > 0; i--) {
	 * System.out.println(Thread.currentThread().getName() + " : i = " + i); } }
	 */

	private int i;

	// synchronized method
	/*
	 * synchronized public void doCountDown() { for (i = 10; i > 0; i--) {
	 * System.out.println(Thread.currentThread().getName() + " : i = " + i); } }
	 */

	// synchronized block
	public void doCountDown() {
		synchronized (this) {
			for (i = 10; i > 0; i--) {
				System.out.println(Thread.currentThread().getName() + " : i = " + i);
			}
		}
	}

}

class CountDownThread extends Thread {
	private CountDown threadCOuntDown;

	public CountDownThread(CountDown threadCOuntDown) {
		super();
		this.threadCOuntDown = threadCOuntDown;
	}

	@Override
	public void run() {
		threadCOuntDown.doCountDown();
	}
}