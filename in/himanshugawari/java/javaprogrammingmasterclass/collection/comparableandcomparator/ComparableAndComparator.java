package in.himanshugawari.java.javaprogrammingmasterclass.collection.comparableandcomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableAndComparator {
	public static void main(String[] args) {
		Theatre theatre = new Theatre("Olympian", 8, 12);
		if (theatre.reservedSeat("D12")) {
			System.out.println("Please Pay for D12");
		} else {
			System.out.println("Sorry, seat is already taken");
		}
		if (theatre.reservedSeat("D12")) {
			System.out.println("Please Pay for D12");
		} else {
			System.out.println("Sorry, seat is already taken");
		}
		if (theatre.reservedSeat("B13")) {
			System.out.println("Please Pay for B13");
		} else {
			System.out.println("Sorry, seat is already taken");
		}

		List<Seat> reverseSeats = new ArrayList<Seat>(theatre.getSeats());
		printList(reverseSeats);
		Collections.reverse(reverseSeats);
		printList(reverseSeats);

		List<Seat> priceSeats = new ArrayList<Seat>(theatre.getSeats());
		priceSeats.add(new Seat("B00", 13.00));
		priceSeats.add(new Seat("A00", 13.00));
		printList(priceSeats);
		Collections.sort(priceSeats, Theatre.PRICE_ORDER);
		printList(priceSeats);

	}

	public static void printList(List<Seat> seats) {
		seats.forEach(seat -> System.out.print(" " + seat.getSeatNumber() + " $" + seat.getPrice()));
		System.out.println("\n==========================================================================");
	}
}