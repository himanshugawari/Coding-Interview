package in.himanshugawari.java.javaprogrammingmasterclass.abstracts.abstract2;

public abstract class Animal {
	private String name;

	public Animal(String name) {
		super();
		this.name = name;
	}

	public abstract void eat();

	public abstract void breath();

	public String getName() {
		return name;
	}

}
