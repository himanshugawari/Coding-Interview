package in.himanshugawari.java.javaprogrammingmasterclass.oop.inheritance;

/**
 * @author himanshu
 *
 */
public class Dog extends Animal {

	private int eyes;
	private int legs;
	private int tail;
	private int teeth;
	private String coat;

	public Dog(String name, int size, int weight, int eyes, int legs, int tail, int teeth, String coat) {
		super(name, 1, 1, size, weight);
		this.eyes = eyes;
		this.legs = legs;
		this.tail = tail;
		this.teeth = teeth;
		this.coat = coat;
	}

	@Override
	public void eat() {
		System.out.println("Dog.eat() called");
		chew();
		super.eat();
	}

	public void chew() {
		System.out.println("Dog.chew() called");
	}

	@Override
	public void move(int speed) {
		System.out.println("Dog.move() called");
		moveLegs(speed);
		super.move(speed);
	}

	private void moveLegs(int speed) {
		System.out.println("Dog.moveLegs() called");
	}

	public void walk() {
		System.out.println("Dog.walk() called");
		move(5);
	}

	public void run() {
		System.out.println("Dog.run() called");
		move(10);
	}

	public int getEyes() {
		return eyes;
	}

	public int getLegs() {
		return legs;
	}

	public int getTail() {
		return tail;
	}

	public int getTeeth() {
		return teeth;
	}

	public String getCoat() {
		return coat;
	}

	@Override
	public String toString() {
		return "Dog [eyes=" + eyes + ", legs=" + legs + ", tail=" + tail + ", teeth=" + teeth + ", coat=" + coat
				+ ", Animal.toString()=" + super.toString() + "]";
	}

}
