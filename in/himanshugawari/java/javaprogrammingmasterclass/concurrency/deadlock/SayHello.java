package in.himanshugawari.java.javaprogrammingmasterclass.concurrency.deadlock;

//Deadlock occurs in example

//Himanshu : Hardik has said hello to me!
//Hardik : Himanshu has said hello to me!

public class SayHello {
	public static void main(String[] args) {
		PolitePerson himanshu = new PolitePerson("Himanshu");
		PolitePerson hardik = new PolitePerson("Hardik");

		// In single thread i.e main thread there is no deadlock
//		System.out.println("E.g In single thread i.e main thread there is no deadlock\n");
//		himanshu.sayHello(hardik);
//		hardik.sayHello(himanshu);
//		System.out.println();

		System.out.println("E.g with multiple threads\n");
		// e.g for deadlock with multiple threads
		new Thread(new Runnable() {

			@Override
			public void run() {
				himanshu.sayHello(hardik);
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				hardik.sayHello(himanshu);
			}
		}).start();

	}

	private static class PolitePerson {
		private final String name;

		public PolitePerson(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		synchronized public void sayHello(PolitePerson person) {
			System.out.format("%s : %s " + "has said hello to me!%n", this.name, person.getName());
			person.sayHelloBack(this);
		}

		synchronized public void sayHelloBack(PolitePerson person) {
			System.out.format("%s : %s " + "has said hello back to me!%n", this.name, person.getName());
		}
	}
}
