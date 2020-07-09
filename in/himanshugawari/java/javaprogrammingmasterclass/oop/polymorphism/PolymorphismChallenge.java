package in.himanshugawari.java.javaprogrammingmasterclass.oop.polymorphism;

/**
 * @author himanshu
 *
 */
public class PolymorphismChallenge {
	public static void main(String[] args) {
		Car car = new Car(8, "Base Car");
		System.out.println(car.startEngine());
		System.out.println(car.accelerate());
		System.out.println(car.brake());

		Mitsubushi mitsubushi = new Mitsubushi(6, "Outlander VRW 4WD");
		System.out.println(mitsubushi.startEngine());
		System.out.println(mitsubushi.accelerate());
		System.out.println(mitsubushi.brake());

		Ford ford = new Ford(5, "Ford Falcon");
		System.out.println(ford.startEngine());
		System.out.println(ford.accelerate());
		System.out.println(ford.brake());

		Holden holden = new Holden(6, "Holden Commodore");
		System.out.println(holden.startEngine());
		System.out.println(holden.accelerate());
		System.out.println(holden.brake());

	}
}

class Car {
	private int cylinders;
	private boolean engine;
	private String name;
	private int wheels;

	public Car(int cylinders, String name) {
		super();
		this.cylinders = cylinders;
		this.name = name;
		this.wheels = 4;
		this.engine = true;
	}

	public int getCylinders() {
		return cylinders;
	}

	public String getName() {
		return name;
	}

	public String startEngine() {
		return "Car -> startEngine()";
	}

	public String accelerate() {
		return "Car -> accelerate()";
	}

	public String brake() {
		return "Car -> brake()";
	}
}

class Mitsubushi extends Car {

	public Mitsubushi(int cylinders, String name) {
		super(cylinders, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String startEngine() {
		return getName() + " with " + getCylinders() + " cylinders" + " -> startEngine()";
	}

	@Override
	public String accelerate() {
		return getName() + " with " + getCylinders() + " cylinders" + " -> accelerate()";
	}

	@Override
	public String brake() {
		return getName() + " with " + getCylinders() + " cylinders" + " -> brake()";
	}
}

class Ford extends Car {

	public Ford(int cylinders, String name) {
		super(cylinders, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String startEngine() {
		return getName() + " with " + getCylinders() + " cylinders" + " -> startEngine()";
	}

	@Override
	public String accelerate() {
		return getName() + " with " + getCylinders() + " cylinders" + " -> accelerate()";
	}

	@Override
	public String brake() {
		return getName() + " with " + getCylinders() + " cylinders" + " -> brake()";
	}
}

class Holden extends Car {

	public Holden(int cylinders, String name) {
		super(cylinders, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String startEngine() {
		return getName() + " with " + getCylinders() + " cylinders" + " -> startEngine()";
	}

	@Override
	public String accelerate() {
		return getName() + " with " + getCylinders() + " cylinders" + " -> accelerate()";
	}

	@Override
	public String brake() {
		return getName() + " with " + getCylinders() + " cylinders" + " -> brake()";
	}
}
