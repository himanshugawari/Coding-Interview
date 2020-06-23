package in.himanshugawari.java.javaprogrammingmasterclass.concurrency.runnable1;

/**
 * @author himanshu
 *
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("In main thread");

		// AnotherThread class extending Thread class
		Thread anotherThread = new AnotherThread();
		anotherThread.setName("--Another Thread--");
		anotherThread.start();

		System.out.println("After calling another THread in main Thread");

		new Thread() {
			public void run() {
				System.out.println("Anonymous thread called from main thread");
			};
		}.start();

		System.out.println("After anonymous thread in main thread");

		Thread myRunnableThread = new Thread(new MyRunnable());
		myRunnableThread.start();

		System.out.println("After MyRunnable thread in main thread");

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Anonymous thread implementing runnable called from main thread");
			}
		}).start();

		System.out.println("After Anonymous thread implementing runnable called from main thread");

		new Thread(new MyRunnable() {
			@Override
			public void run() {
				// calling MyRunnable run method
				// super.run();

				// overriding MyRunnable run method
				System.out.println("Overriden Myrunnable thread using runnable interface");
			}
		}).start();

		System.out.println("After Overriden Myrunnable thread using runnable interface");
	}
}
