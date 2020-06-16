package in.himanshugawari.java.javaprogrammingmasterclass.abstracts.abstract2;

public abstract class Bird extends Animal implements CanFly {

	public Bird(String name) {
		super(name);
	}

	@Override
	public void eat() {
		System.out.println(getName() + " is pecking");
	}

	@Override
	public void breath() {
		System.out.println(getName() + " is breathing");
	}

	@Override
	public void fly() {
		System.out.println(getName() + " is flapping its wing");

	}

}