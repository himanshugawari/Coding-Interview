package in.himanshugawari.java.javaprogrammingmasterclass.interfaces.interface1;

public class Main {
	public static void main(String[] args) {
		ITelephone timsPhone = new DeskPhone(123456789);
		timsPhone.powerOn();
		timsPhone.callPhone(123456789);
		timsPhone.answer();
		
		timsPhone=new MobilePhone(987654321);
		timsPhone.powerOn();
		timsPhone.callPhone(897654321);
		timsPhone.answer();
		
		//this works because of interfaces
		/*
		 * ITelephone timsPhone = new DeskPhone(123456789); timsPhone=new
		 * MobilePhone(987654321);
		 */
		
		//Does not works
		/*
		 * DeskPhone timsPhone = new DeskPhone(123456789); timsPhone=new
		 * MobilePhone(987654321);
		 * 
		 * MobilePhone timsPhone = new MobilePhone(123456789); timsPhone=new
		 * DeskPhone(987654321);
		 */
	}
}
