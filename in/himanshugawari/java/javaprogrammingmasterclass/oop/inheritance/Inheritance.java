package in.himanshugawari.java.javaprogrammingmasterclass.oop.inheritance;

/**
 * @author himanshu
 *
 */
public class Inheritance {
	public static void main(String[] args) {

		Animal animal = new Animal("Animal", 1, 1, 5, 5);
		animal.eat();
		animal.move(1);

		System.out.println();

		Dog dog = new Dog("Yorkie", 8, 20, 2, 4, 1, 20, "long silky");
		dog.eat();
		System.out.println();
		dog.move(1);
		System.out.println();
		dog.walk();
		System.out.println();
		dog.run();
		System.out.println();
		System.out.println(dog.toString());

	}
}
