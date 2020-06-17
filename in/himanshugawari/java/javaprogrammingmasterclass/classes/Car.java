package in.himanshugawari.java.javaprogrammingmasterclass.classes;

public class Car {

	private int doors;
	private int wheels;
	private String model;
	private String engine;
	private String color;

	public void setColor(String color) {
		this.color = color;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	public String getColor() {
		return color;
	}

	public int getDoors() {
		return doors;
	}

	public String getEngine() {
		return engine;
	}

	public String getModel() {
		return model;
	}

	public int getWheels() {
		return wheels;
	}

	@Override
	public String toString() {
		return "Car [doors=" + doors + ", wheels=" + wheels + ", model=" + model + ", engine=" + engine + ", color="
				+ color + "]";
	}

}
