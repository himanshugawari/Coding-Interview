package in.himanshugawari.java.javaprogrammingmasterclass.oop.inheritance;

/**
 * @author himanshu
 *
 */
public class Fish extends Animal {

	private int gills;
	private int eyes;
	private int fins;

	public Fish(String name, int size, int weight, int gills, int eyes, int fins) {
		super(name, 1, 1, size, weight);
		this.gills = gills;
		this.eyes = eyes;
		this.fins = fins;
	}

	public void rest() {

	}

	public void moveMuscles() {

	}

	public void moveBackFin() {

	}

	public void swim(int speed) {
		moveMuscles();
		moveBackFin();
		super.move(speed);
	}

	public int getGills() {
		return gills;
	}

	public int getEyes() {
		return eyes;
	}

	public int getFins() {
		return fins;
	}

	@Override
	public String toString() {
		return "Fish [gills=" + gills + ", eyes=" + eyes + ", fins=" + fins + ", Animal.toString()=" + super.toString()
				+ "]";
	}

}
