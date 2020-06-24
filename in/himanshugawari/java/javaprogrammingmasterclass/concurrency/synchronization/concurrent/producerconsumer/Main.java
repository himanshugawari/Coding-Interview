package in.himanshugawari.java.javaprogrammingmasterclass.concurrency.synchronization.concurrent.producerconsumer;

import static in.himanshugawari.java.javaprogrammingmasterclass.concurrency.synchronization.concurrent.producerconsumer.Main.EOF;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	public static final String EOF = "EOF";

	public static void main(String[] args) {
		List<String> buffer = new ArrayList<String>();
		MyProducer producer = new MyProducer(buffer, "thread 1 ");
		MyConsumer consumer1 = new MyConsumer(buffer, "thread 2 ");
		MyConsumer consumer2 = new MyConsumer(buffer, "thread 3 ");

		new Thread(producer).start();
		new Thread(consumer1).start();
		new Thread(consumer2).start();
	}
}

class MyProducer implements Runnable {
	private List<String> buffer;
	private String name;

	public MyProducer(List<String> buffer, String name) {
		super();
		this.buffer = buffer;
		this.name = name;
	}

	@Override
	public void run() {
		Random random = new Random();
		String[] nums = { "1", "2", "3", "4", "5" };

		for (String num : nums) {
			try {
				System.out.println(name + " Adding number ... " + num);
				synchronized (buffer) {
					buffer.add(num);
				}

				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				System.out.println("Producer was Interrupted");
			}
		}
		System.out.println(name + " Adding EOF and exiting...");
		synchronized (buffer) {
			buffer.add("EOF");
		}
	}
}

class MyConsumer implements Runnable {

	private List<String> buffer;
	private String name;

	public MyConsumer(List<String> buffer, String name) {
		super();
		this.buffer = buffer;
		this.name = name;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (buffer) {
				if (buffer.isEmpty()) {
					continue;
				}
				if (buffer.get(0).equals(EOF)) {
					System.out.println(name + " Exiting");
					break;
				} else {
					System.out.println(name + " Removed " + buffer.remove(0));
				}
			}
		}
	}
}
