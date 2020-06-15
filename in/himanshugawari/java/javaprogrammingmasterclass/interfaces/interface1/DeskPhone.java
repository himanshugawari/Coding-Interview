package in.himanshugawari.java.javaprogrammingmasterclass.interfaces.interface1;

public class DeskPhone implements ITelephone {

	private int myNumber;
	private boolean isRinging;

	public DeskPhone(int myNumber) {
		super();
		this.myNumber = myNumber;
	}

	@Override
	public void powerOn() {
		System.out.println("No action taken no power button");
	}

	@Override
	public void dial(int phoneNumber) {
		System.out.println("Now ringing " + phoneNumber + " on DeskPhone");
	}

	@Override
	public void answer() {
		if (isRinging) {
			System.out.println("Answering the call");
			isRinging = false;
		}
	}

	@Override
	public boolean callPhone(int phoneNumber) {
		if (phoneNumber == myNumber) {
			isRinging = true;
			System.out.println("ring ring");
		} else {
			isRinging = false;
		}
		return isRinging;
	}

	@Override
	public boolean isRinging() {
		return isRinging;
	}

}
