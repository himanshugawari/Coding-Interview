package in.himanshugawari.java.javaprogrammingmasterclass.constructor;

/**
 * @author himanshu
 *
 */
public class Account {

	private String number;
	private double balance;
	private String name;
	private String email;
	private String phoneNumber;

	public Account() {
		// super();
		this("default", 0, "default", "default", "default");
		System.out.println("Empty Constructor Called");
	}

	public Account(String number, double balance, String name, String email, String phoneNumber) {
		super();
		System.out.println("Parameterized Constructor Called");
		this.number = number;
		this.balance = balance;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public void deposit(double depositAmount) {
		this.balance += depositAmount;
		System.out.println("deposit of " + depositAmount + " processed. new balance = " + this.balance);
	}

	public void withdrawl(double withdrawlAmount) {
		if (this.balance - withdrawlAmount < 0) {
			System.out.println("only " + this.balance + " available. withdrawl not processed.");
		} else {
			this.balance -= withdrawlAmount;
			System.out.println("withdrawl of " + withdrawlAmount + " processed. remaining balance = " + this.balance);
		}
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Account [number=" + number + ", balance=" + balance + ", name=" + name + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + "]";
	}

}
