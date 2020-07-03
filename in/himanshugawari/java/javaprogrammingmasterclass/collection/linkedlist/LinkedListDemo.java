package in.himanshugawari.java.javaprogrammingmasterclass.collection.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * @author himanshu
 *
 */
public class LinkedListDemo {
	public static void main(String[] args) {

		LinkedList<String> cities = new LinkedList<String>();
		cities.add("Sydney");
		cities.add("Melbourne");
		cities.add("Brisbane");
		cities.add("Perth");
		cities.add("Canberra");
		cities.add("Adelaide");
		cities.add("Darwin");

		printList(cities);

		cities.add(1, "Alice Springs");

		printList(cities);

		cities.remove(4);

		printList(cities);

		System.out.println("=======================================================");

		LinkedList<String> placesToVisit = new LinkedList<String>();
		addInOrder(placesToVisit, "Sydney");
		addInOrder(placesToVisit, "Melbourne");
		addInOrder(placesToVisit, "Brisbane");
		addInOrder(placesToVisit, "Perth");
		addInOrder(placesToVisit, "Canberra");
		addInOrder(placesToVisit, "Adelaide");
		addInOrder(placesToVisit, "Darwin");

		printList(placesToVisit);

		addInOrder(placesToVisit, "Alice Springs");
		addInOrder(placesToVisit, "Darwin");

		printList(placesToVisit);

		System.out.println("==============================================");

		visit(placesToVisit);

	}

	private static void printList(LinkedList<String> cities) {
		Iterator<String> i = cities.iterator();
		while (i.hasNext()) {
			System.out.println("Now visiting " + i.next());
		}
		// OR
		// cities.forEach(System.out::println);
		// OR
		// cities.forEach(s -> System.out.println("No visiting " + s));
		System.out.println("======================");
	}

	private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
		ListIterator<String> stringListIterator = linkedList.listIterator();
		while (stringListIterator.hasNext()) {
			int comparision = stringListIterator.next().compareTo(newCity);
			if (comparision == 0) {
				// equal do not add
				System.out.println(newCity + " is already included as a desitnation.");
				return false;
			} else if (comparision > 0) {
				// newCIty should appear before this one
				stringListIterator.previous();
				stringListIterator.add(newCity);
				return true;
			} else if (comparision < 0) {
				// move on to next city
			}
		}
		stringListIterator.add(newCity);
		return true;
	}

	private static void visit(LinkedList<String> cities) {
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		boolean goingForward = true;
		ListIterator<String> listIterator = cities.listIterator();

		if (cities.isEmpty()) {
			System.out.println("No cities in the itenery.");
			sc.close();
			return;
		} else {
			System.out.println("Now visiting " + listIterator.next());
			printMenu();
		}

		while (!quit) {
			int action = sc.nextInt();
			sc.nextLine();
			switch (action) {
			case 0:
				System.out.println("Holidays are over");
				sc.close();
				quit = true;
				break;

			case 1:
				if (!goingForward) {
					if (listIterator.hasNext()) {
						listIterator.next();
					}
					goingForward = true;
				}
				if (listIterator.hasNext()) {
					System.out.println("Now visiting " + listIterator.next());
				} else {
					System.out.println("Reached the end of the list");
					goingForward = false;
				}
				break;

			case 2:
				if (goingForward) {
					if (listIterator.hasPrevious()) {
						listIterator.previous();
					}
					goingForward = false;
				}
				if (listIterator.hasPrevious()) {
					System.out.println("Now visiting " + listIterator.previous());
				} else {
					System.out.println("We are at the start of the list");
					goingForward = true;
				}
				break;

			case 3:
				printMenu();
				break;
			}
		}
	}

	private static void printMenu() {
		System.out.println("Available actions:\npress");
		System.out.println("0 - to quit");
		System.out.println("1 - go to next city");
		System.out.println("2 - go to previous city");
		System.out.println("3 - print menu");

	}
}
