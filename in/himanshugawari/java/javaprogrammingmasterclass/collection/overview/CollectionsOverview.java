package in.himanshugawari.java.javaprogrammingmasterclass.collection.overview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author himanshu
 *
 */
public class CollectionsOverview {

	public static void main(String[] args) {

		Theatre theatre = new Theatre("Olympian", 8, 12);
//		theatre.getSeats();
//		if (theatre.reservedSeat("H11")) {
//			System.out.println("Please Pay");
//		} else {
//			System.out.println("Sorry, seat is already taken");
//		}
//		if (theatre.reservedSeat("H11")) {
//			System.out.println("Please Pay");
//		} else {
//			System.out.println("Sorry, seat is already taken");
//		}

		List<Seat> seatCopy = new ArrayList<>(theatre.seats);
		printList(seatCopy);

		seatCopy.get(1).reserve();
		if (theatre.reservedSeat("A02")) {
			System.out.println("Please Pay for A02");
		} else {
			System.out.println("Sorry, seat is already taken");
		}

		System.out.println("printing seatCopy");
		// can reverse, shuffle etc.
		Collections.shuffle(seatCopy);
		printList(seatCopy);

		System.out.println("printing seats");
		printList(theatre.seats);

		Seat minSeat = Collections.min(seatCopy);
		Seat maxSeat = Collections.max(seatCopy);
		System.out.println("Min seat no is " + minSeat.getSeatNumber());
		System.out.println("Max seat no is " + maxSeat.getSeatNumber());

		sortList(seatCopy);
		System.out.println("printing sorted seatCopy");
		printList(seatCopy);

	}

	public static void printList(List<Seat> seats) {
		seats.forEach(seat -> System.out.print(" " + seat.getSeatNumber()));
		System.out.println("\n==========================================================================");
	}

	public static void sortList(List<? extends Seat> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).compareTo(list.get(j)) > 0) {
					Collections.swap(list, i, j);
				}
			}
		}
	}

}

class Theatre {
	private final String theatreName;
	public List<Seat> seats = new ArrayList<>();
	// private List<Seat> seats = new ArrayList<>();
	// OR
	// private List<Seat> seats = new LinkedList<>();
	// OR
	// private Collection<Seat> seats=new LinkedList<Seat>();
	// OR
	// private Collection<Seat> seats = new HashSet<Seat>();
	// OR
	// private Collection<Seat> seats = new LinkedHashSet<Seat>();

	public Theatre(String theatreName, int numRows, int seatsPerRow) {
		this.theatreName = theatreName;

		int lastRow = 'A' + (numRows - 1);
		for (char row = 'A'; row <= lastRow; row++) {
			for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
				Seat seat = new Seat(row + String.format("%02d", seatNum));
				seats.add(seat);
			}
		}
	}

	public String getTheatreName() {
		return this.theatreName;
	}

	public boolean reservedSeat(String seatNumber) {

		Seat requestedSeat = new Seat(seatNumber);
		int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
		if (foundSeat >= 0) {
			return seats.get(foundSeat).reserve();
		} else {
			System.out.println("There is no seat " + seatNumber);
			return false;
		}

//		Seat requestedSeat = null;
//		for (Seat seat : seats) {
//			System.out.print(".");
//			if (seat.getSeatNumber().equals(seatNumber)) {
//				requestedSeat = seat;
//				break;
//			}
//		}
//		if (requestedSeat == null) {
//			System.out.println("There is no seat " + seatNumber);
//			return false;
//		}
//		return requestedSeat.reserve();
	}

	public void getSeats() {
		seats.forEach(s -> System.out.println(s.getSeatNumber()));
//		for (Seat seat : seats) {
//			System.out.println(seat.getSeatNumber());
//		}
	}

}

class Seat implements Comparable<Seat> {

	private final String seatNumber;
	private boolean reserved = false;

	public Seat(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public boolean reserve() {
		if (!this.reserved) {
			this.reserved = true;
			System.out.println("Seat " + seatNumber + " is reserved");
			return true;
		} else {
			return false;
		}
	}

	public boolean cancel() {
		if (this.reserved) {
			this.reserved = false;
			System.out.println("Seat " + seatNumber + " reservation is cancelled");
			return true;
		} else {
			return false;
		}
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	@Override
	public int compareTo(Seat seat) {
		return this.seatNumber.compareTo(seat.getSeatNumber());
	}
}
