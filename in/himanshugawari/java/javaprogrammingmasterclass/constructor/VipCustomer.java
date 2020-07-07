package in.himanshugawari.java.javaprogrammingmasterclass.constructor;

/**
 * @author himanshu
 *
 */
public class VipCustomer {

	private String name;
	private String email;
	private double creditLimit;

	public VipCustomer() {
		this("default", "default", 0);
	}

	public VipCustomer(String name, String email) {
		this(name, email, 0);
	}

	public VipCustomer(String name, String email, double creditLimit) {
		super();
		this.name = name;
		this.email = email;
		this.creditLimit = creditLimit;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	@Override
	public String toString() {
		return "VipCustomer [ name=" + name + " email=" + email + " creditLimit=" + creditLimit + " ]";

	}

}
