package in.himanshugawari.java.javaprogrammingmasterclass.abstracts.abstract1;

public class Parrot extends Bird {

	public Parrot(String name) {
		super(name);
	}

	@Override
	public void fly() {
		System.out.println(getName()+ " flying from branch to branch");
	}

}
