package in.himanshugawari.java.javaprogrammingmasterclass.concurrency.interruptandjoin;

public class Main {
	public static void main(String[] args) {
		System.out.println("in main thrad");

		Thread anotherThread = new AnotherThread();
		anotherThread.setName("--Another Thread--");
		anotherThread.start();

		System.out.println("After ANother thread in main thread");

		Thread myRunnable = new Thread(new MyRunnable() {
			@Override
			public void run() {
				super.run();
				try {
					anotherThread.join();
					System.out.println("Another Thred Terminated or times out. so i am running again");
				} catch (InterruptedException e) {
					System.out.println("I could not wait after all I was Interrupted");
				}
			}
		});
		myRunnable.start();
		// anotherThread.interrupt();

		System.out.println("Hello again from main Thread");

	}
}
