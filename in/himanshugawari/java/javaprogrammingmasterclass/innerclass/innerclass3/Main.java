package in.himanshugawari.java.javaprogrammingmasterclass.innerclass.innerclass3;

import java.util.Scanner;

// anonymous class

public class Main {
	private static Scanner sc = new Scanner(System.in);
	private static Button btnPrint = new Button("Print");

	public static void main(String[] args) {

		btnPrint.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(String title) {
				System.out.println(title + " was clicked");
			}
		});
		listen();
	}

	private static void listen() {
		boolean quit = false;
		System.out.println("Choose \n" + "1 to enter a string \n" + "0 to quit");
		while (!quit) {
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 0:
				quit = true;
				break;
			case 1:
				btnPrint.onClick();
				break;
			default:
				break;
			}
		}
	}
}
