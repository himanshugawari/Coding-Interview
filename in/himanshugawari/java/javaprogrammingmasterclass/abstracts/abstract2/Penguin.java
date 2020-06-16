package in.himanshugawari.java.javaprogrammingmasterclass.abstracts.abstract2;

public class Penguin extends Bird {

	public Penguin(String name) {
		super(name);
	}

	@Override
	public void fly() {
		super.fly();
		System.out.println(getName() + " i am not very good at flying");
	}

}
