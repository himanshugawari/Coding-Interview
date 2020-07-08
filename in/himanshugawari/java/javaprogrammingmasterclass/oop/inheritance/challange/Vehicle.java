package in.himanshugawari.java.javaprogrammingmasterclass.oop.inheritance.challange;

/**
 * @author himanshu
 *
 */
public class Vehicle {

	private String name;
	private String size;

	private int currentDirection;
	private int currentVelocity;

	public Vehicle(String name, String size) {
		super();
		this.name = name;
		this.size = size;
		this.currentDirection = 0;
		this.currentVelocity = 0;
	}

	public void steer(int direction) {
		currentDirection += direction;
		System.out.println("Vehicle.steer(): Steering at " + currentDirection + " degrees.");
	}

	public void move(int velocity, int direction) {
		currentDirection = direction;
		currentVelocity = velocity;
		System.out.println("Vehicle.move(): Moving at " + currentVelocity + " in direction " + currentDirection);
	}

	public void stop() {
		currentDirection = 0;
	}

	public String getName() {
		return name;
	}

	public String getSize() {
		return size;
	}

	public int getCurrentDirection() {
		return currentDirection;
	}

	public int getCurrentVelocity() {
		return currentVelocity;
	}

	@Override
	public String toString() {
		return "Vehicle [name=" + name + ", size=" + size + ", currentDirection=" + currentDirection
				+ ", currentVelocity=" + currentVelocity + "]";
	}

}
