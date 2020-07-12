package in.himanshugawari.java.javaprogrammingmasterclass.equalsandhashcode;

/**
 * @author himanshu
 *
 */
public class EqualAndHashCodeChallenge {
	public static void main(String[] args) {
		Labrador rover = new Labrador("Rover");
		Dog rover2 = new Dog("Rover");

		System.out.println(rover2.equals(rover));
		System.out.println(rover.equals(rover2));
	}
}

class Dog {

	private final String name;

	public Dog(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	// mark as final so it will not be overridden
	@Override
	final public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Dog) {
			String objName = ((Dog) obj).getName();
			return this.name.equals(objName);
		}
		return false;
	}
}

class Labrador extends Dog {

	public Labrador(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	// if overriding fails the equals rule
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj) {
//			return true;
//		}
//		if (obj instanceof Labrador) {
//			String objName = ((Labrador) obj).getName();
//			return this.getName().equals(objName);
//		}
//		return false;
//	}

}
