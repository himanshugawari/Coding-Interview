package in.himanshugawari.java.javaprogrammingmasterclass.concurrency.synchronization.producerconsumer;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Message message = new Message();
		new Thread(new Writer(message)).start();
		new Thread(new Reader(message)).start();
	}
}

class Message {
	private String message;
	private boolean empty = true;

	synchronized public String read() {
		while (empty) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		empty = true;
		notifyAll();
		return message;
	}

	synchronized public void write(String message) {
		while (!empty) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		empty = false;
		this.message = message;
		notifyAll();
	}
}

class Writer implements Runnable {
	private Message message;

	public Writer(Message message) {
		super();
		this.message = message;
	}

	@Override
	public void run() {
		String[] messages = { "sam loves to code", "sam eat chicken after coding",
				"sam is lazy so he sleeps after filling his stomach", "sam sleeps late and wakes up late in afternoon" };

		Random random = new Random();

		for (int i = 0; i < messages.length; i++) {
			message.write(messages[i]);
			try {
				Thread.sleep(random.nextInt(2000));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		message.write("Finishes");
	}
}

class Reader implements Runnable {
	private Message message;

	public Reader(Message message) {
		super();
		this.message = message;
	}

	@Override
	public void run() {
		Random random = new Random();

		for (String latestMessage = message.read(); !latestMessage.equals("Finishes"); latestMessage = message.read()) {
			System.out.println(latestMessage);
			try {
				Thread.sleep(random.nextInt(2000));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}