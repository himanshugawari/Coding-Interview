package in.himanshugawari.java.javaprogrammingmasterclass.constructor;

/**
 * @author himanshu
 *
 */
public class Main {

	public static void main(String[] args) {

		// with default constructor
		Account bobsAccount = new Account();
		System.out.println(bobsAccount.toString());
		bobsAccount.setNumber("12345");
		bobsAccount.setBalance(0.00);
		bobsAccount.setName("Bob Brown");
		bobsAccount.setEmail("myemail@bob.com");
		bobsAccount.setPhoneNumber("(087) 123-4567");
		System.out.println(bobsAccount.toString());

		// with parameterized constructor
		Account timsAccount = new Account("56789", 0.00, "Tim Back", "myemail@tim.com", "(087) 123-4567");
		System.out.println(timsAccount.toString());

		Account snow = new Account();
		System.out.println(snow.toString());

//		bobsAccount.withdrawl(100.0);
//
//		bobsAccount.deposit(50.0);
//		bobsAccount.withdrawl(100.0);
//
//		bobsAccount.deposit(51.0);
//		bobsAccount.withdrawl(100.0);

		System.out.println("\n");

		VipCustomer himanshu = new VipCustomer();
		System.out.println(himanshu);

		VipCustomer hardik = new VipCustomer("Hardik", "myemail@hardik.com");
		System.out.println(hardik);

		VipCustomer rohidas = new VipCustomer("Rohidas", "myemail@rohidas.com", 500000);
		System.out.println(rohidas);

	}
}
