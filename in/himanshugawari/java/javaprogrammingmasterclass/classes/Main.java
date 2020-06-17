package in.himanshugawari.java.javaprogrammingmasterclass.classes;

public class Main {
	public static void main(String[] args) {
		Car audi = new Car();
		Car tata = new Car();
		audi.setModel("S1");
		tata.setModel("Nano");
		System.out.println(audi.toString());
		System.out.println(tata.toString());
	}
}
