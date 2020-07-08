package in.himanshugawari.java.javaprogrammingmasterclass.oop.composition;

/**
 * @author himanshu
 *
 */
public class PC {
	private Case theCase;
	private Monitor monitor;
	private Motherboard motherboard;

	public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
		super();
		this.theCase = theCase;
		this.monitor = monitor;
		this.motherboard = motherboard;
	}

	public Case getTheCase() {
		return theCase;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public Motherboard getMotherboard() {
		return motherboard;
	}

	@Override
	public String toString() {
		return "PC [theCase=" + theCase + ", monitor=" + monitor + ", motherboard=" + motherboard + "]";
	}

}
