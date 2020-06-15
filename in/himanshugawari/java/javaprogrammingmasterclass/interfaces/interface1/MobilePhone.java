package in.himanshugawari.java.javaprogrammingmasterclass.interfaces.interface1;

public class MobilePhone implements ITelephone {

	private int myNumber;
	private boolean isRinging;
	private boolean isOn=false;

	public MobilePhone(int myNumber) {
		super();
		this.myNumber = myNumber;
	}

	@Override
	public void powerOn() {
		isOn=true;
		System.out.println("Mobile is powered ON");
	}

	@Override
	public void dial(int phoneNumber) {
		if(isOn) {
			System.out.println("Now ringing " + phoneNumber + " on MobilePhone");
		}else {
			System.out.println("MobilePhone is switched OFF");
		}
	}

	@Override
	public void answer() {
		if (isRinging) {
			System.out.println("Answering the MobilePhone");
			isRinging = false;
		}
	}

	@Override
	public boolean callPhone(int phoneNumber) {
		if (phoneNumber == myNumber && isOn) {
			isRinging = true;
			System.out.println("song ring");
		} else {
			isRinging = false;
			System.out.println("Wrong number or mobilephone is OFF");
		}
		return isRinging;
	}

	@Override
	public boolean isRinging() {
		return isRinging;
	}

}
