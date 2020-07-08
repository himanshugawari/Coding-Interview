package in.himanshugawari.java.javaprogrammingmasterclass.oop.inheritance;

/**
 * @author himanshu
 *
 */
public class Animal {
	private String name;
	private int brain;
	private int body;
	private int size;
	private int weight;

	public Animal(String name, int brain, int body, int size, int weight) {
		this.name = name;
		this.body = body;
		this.brain = brain;
		this.size = size;
		this.weight = weight;
	}

	public void eat() {
		System.out.println("Animal.eat() called");
	}

	public void move(int speed) {
		System.out.println("Animal.move() called -> Animal is moving at speed " + speed);
	}

	public String getName() {
		return name;
	}

	public int getBrain() {
		return brain;
	}

	public int getBody() {
		return body;
	}

	public int getSize() {
		return size;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", brain=" + brain + ", body=" + body + ", size=" + size + ", weight=" + weight
				+ "]";
	}

}
