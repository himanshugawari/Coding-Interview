package in.himanshugawari.java.javaprogrammingmasterclass.oop.challnege;

/**
 * @author himanshu
 *
 */
public class Main {
	public static void main(String[] args) {

		Hamburger hamburger = new Hamburger("Basic", "Sausage", 3.56, "White");
		double price = hamburger.itemizeHamburger();
		hamburger.addHamburgerAddition1("Tomato", 0.27);
		hamburger.addHamburgerAddition2("Lettuce", 0.75);
		hamburger.addHamburgerAddition3("Cheese", 1.13);
		price = hamburger.itemizeHamburger();
		System.out.println("Total burger price is " + price);

		HealthyBurger healthyBurger = new HealthyBurger("Bacon", 5.67);
		healthyBurger.addHamburgerAddition1("Egg", 5.43);
		healthyBurger.addHamburgerAddition2("Lentils", 3.41);
		System.out.println("Total Healthy burger price is " + healthyBurger.itemizeHamburger());

		DeluxBurger deluxBurger = new DeluxBurger();
		System.out.println("Total Delux burger price is " + deluxBurger.itemizeHamburger());

	}
}
