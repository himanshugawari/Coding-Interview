package in.himanshugawari.java.javaprogrammingmasterclass.oop.composition;

/**
 * @author himanshu
 *
 */
public class Main {
	public static void main(String[] args) {
		Dimensions dimensions = new Dimensions(20, 20, 5);
		Case theCase = new Case("2208", "Dell", "240", dimensions);

		Resolution resolution = new Resolution(2540, 1440);
		Monitor monitor = new Monitor("27inch Beast", "Acer", 27, resolution);

		Motherboard motherboard = new Motherboard("B3-200", "Asus", 4, 6, "v2.44");

		PC pc = new PC(theCase, monitor, motherboard);
		System.out.println(pc);

		pc.getMonitor().drawPixelAt(1500, 1200, "red");
		pc.getMotherboard().loadProgram("Windows 1.0");
		pc.getTheCase().pressPowerButton();
	}
}
