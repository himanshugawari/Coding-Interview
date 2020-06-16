package in.himanshugawari.java.javaprogrammingmasterclass.abstracts.abstract2;

public class Main {
	public static void main(String[] args) {
		Dog dog = new Dog("Doberman");
		dog.breath();
		dog.eat();

		Bird bird = new Parrot("Indian Parrot");
		bird.breath();
		bird.eat();
		bird.fly();

		Parrot parrot = new Parrot("Australian RingNeck");
		parrot.breath();
		parrot.eat();
		parrot.fly();

		Penguin penguin = new Penguin("Emperor");
		penguin.breath();
		penguin.eat();
		penguin.fly();
	}
}
