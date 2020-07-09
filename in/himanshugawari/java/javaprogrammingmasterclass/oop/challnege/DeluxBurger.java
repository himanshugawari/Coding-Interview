package in.himanshugawari.java.javaprogrammingmasterclass.oop.challnege;

/**
 * @author himanshu
 *
 */
public class DeluxBurger extends Hamburger {

	public DeluxBurger() {
		super("Delus", "Sausage & Bacon", 14.54, "White");
		super.addHamburgerAddition1("Chips", 2.75);
		super.addHamburgerAddition2("Drink", 1.81);
	}

	@Override
	public void addHamburgerAddition1(String name, double price) {
		System.out.println("Cannot add additional items to delux burger");
	}

	@Override
	public void addHamburgerAddition2(String name, double price) {
		System.out.println("Cannot add additional items to delux burger");
	}

	@Override
	public void addHamburgerAddition3(String name, double price) {
		System.out.println("Cannot add additional items to delux burger");
	}

	@Override
	public void addHamburgerAddition4(String name, double price) {
		System.out.println("Cannot add additional items to delux burger");
	}

	@Override
	public double itemizeHamburger() {
		// TODO Auto-generated method stub
		return super.itemizeHamburger();
	}

}
