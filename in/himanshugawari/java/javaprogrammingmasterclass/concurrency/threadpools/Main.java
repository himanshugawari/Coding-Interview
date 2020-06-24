package in.himanshugawari.java.javaprogrammingmasterclass.concurrency.threadpools;

import static in.himanshugawari.java.javaprogrammingmasterclass.concurrency.threadpools.Main.EOF;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
	public static final String EOF = "EOF";

	public static void main(String[] args) {
		List<String> buffer = new ArrayList<String>();
		ReentrantLock bufferLock = new ReentrantLock();

		ExecutorService executorService = Executors.newFixedThreadPool(5);

		MyProducer producer = new MyProducer(buffer, "thread 1 ", bufferLock);
		MyConsumer consumer1 = new MyConsumer(buffer, "thread 2 ", bufferLock);
		MyConsumer consumer2 = new MyConsumer(buffer, "thread 3 ", bufferLock);

		executorService.execute(producer);
		executorService.execute(consumer1);
		executorService.execute(consumer2);

		Future<String> future = executorService.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println(Thread.currentThread().getName() + " I am being printed for the callable class");
				return "This is callable result";
			}
		});

		try {
			System.out.println(future.get());
		} catch (ExecutionException e) {
			System.out.println("something went wrong");
		} catch (InterruptedException e) {
			System.out.println("thread running the task was interrupted");
		}

		executorService.shutdown();
	}
}

class MyProducer implements Runnable {
	private List<String> buffer;
	private String name;
	private ReentrantLock reentrantLock;

	public MyProducer(List<String> buffer, String name, ReentrantLock reentrantLock) {
		super();
		this.buffer = buffer;
		this.name = name;
		this.reentrantLock = reentrantLock;
	}

	@Override
	public void run() {
		Random random = new Random();
		String[] nums = { "1", "2", "3", "4", "5" };

		for (String num : nums) {
			try {
				System.out.println(name + " Adding number ... " + num);
				reentrantLock.lock();
				try {
					buffer.add(num);
				} finally {
					reentrantLock.unlock();
				}

				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				System.out.println("Producer was Interrupted");
			}
		}
		System.out.println(name + " Adding EOF and exiting...");
		reentrantLock.lock();
		try {
			buffer.add("EOF");
		} finally {
			reentrantLock.unlock();
		}

	}
}

/*
 * class MyConsumer implements Runnable {
 * 
 * private List<String> buffer; private String name; private ReentrantLock
 * reentrantLock;
 * 
 * public MyConsumer(List<String> buffer, String name, ReentrantLock
 * reentrantLock) { super(); this.buffer = buffer; this.name = name;
 * this.reentrantLock = reentrantLock; }
 * 
 * @Override public void run() { while (true) { reentrantLock.lock(); try { if
 * (buffer.isEmpty()) { continue; } if (buffer.get(0).equals(EOF)) {
 * System.out.println(name + " Exiting"); break; } else {
 * System.out.println(name + " Removed " + buffer.remove(0)); } } finally {
 * reentrantLock.unlock(); }
 * 
 * } } }
 */

// using tryLock
class MyConsumer implements Runnable {

	private List<String> buffer;
	private String name;
	private ReentrantLock reentrantLock;

	public MyConsumer(List<String> buffer, String name, ReentrantLock reentrantLock) {
		super();
		this.buffer = buffer;
		this.name = name;
		this.reentrantLock = reentrantLock;
	}

	@Override
	public void run() {

		int counter = 0;

		while (true) {
			if (reentrantLock.tryLock()) {
				try {
					if (buffer.isEmpty()) {
						continue;
					}
					System.out.println(name + " The Counter Is = " + counter);
					if (buffer.get(0).equals(EOF)) {
						System.out.println(name + " Exiting");
						break;
					} else {
						System.out.println(name + " Removed " + buffer.remove(0));
					}
				} finally {
					reentrantLock.unlock();
				}
			} else {
				counter++;
			}

		}
	}
}
