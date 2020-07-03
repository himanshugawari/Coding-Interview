package in.himanshugawari.java.javaprogrammingmasterclass.collection.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author himanshu
 *
 */
public class ArrayListExample {
	private static Scanner sc = new Scanner(System.in);
	private static GrocertList grocertList = new GrocertList();

	public static void main(String[] args) {
		boolean quit = false;
		int choice = 0;
		printInstructions();
		while (!quit) {
			System.out.println("Enter your choice : ");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 0:
				printInstructions();
				break;
			case 1:
				grocertList.printGroceryList();
				break;
			case 2:
				addItem();
				break;
			case 3:
				modifyItem();
				break;
			case 4:
				removeItem();
				break;
			case 5:
				searchForItem();
				break;
			case 6:
				quit = true;
				sc.close();
				break;
			}

		}
	}

	private static void searchForItem() {
		System.out.print("Enter the item to search for : ");
		String searchItem = sc.nextLine();
		if (grocertList.onList(searchItem)) {
			System.out.println("Found " + searchItem + " in our grocery list");
		} else {
			System.out.println(searchItem + " in not in our grocery list");
		}

	}

	private static void removeItem() {
		System.out.print("Please enter the gocery number to be removed : ");
		String item = sc.nextLine();
		grocertList.removeGroceryItem(item);
	}

	private static void modifyItem() {
		System.out.print("Please enter the gocery item : ");
		String item = sc.nextLine();
		System.out.print("Enter the replacement item : ");
		String newItem = sc.nextLine();
		grocertList.modifyGroceryItem(item, newItem);
	}

	private static void addItem() {
		System.out.print("Please enter the gocery item : ");
		grocertList.addGroceryItem(sc.nextLine());
	}

	private static void printInstructions() {
		System.out.println("\nPress ");
		System.out.println("\t 0 -  To print choice options.");
		System.out.println("\t 1 -  To print the list of grocery items.");
		System.out.println("\t 2 -  To add an item into grocery list.");
		System.out.println("\t 3 -  To modify an item in grocery list.");
		System.out.println("\t 4 -  To remove an item from grocery list.");
		System.out.println("\t 5 -  To search an item in grocery list.");
		System.out.println("\t 6 -  To quit the application.");

	}
}

class GrocertList {
	private ArrayList<String> groceryList = new ArrayList<>();

	public void addGroceryItem(String item) {
		groceryList.add(item);
	}

	public void printGroceryList() {
		System.out.println("You have " + groceryList.size() + " items in your grocery list");
		// groceryList.forEach(System.out::println);
		for (int i = 0; i < groceryList.size(); i++) {
			System.out.println((i + 1) + " -> " + groceryList.get(i));
		}
	}

	public void modifyGroceryItem(String currItem, String newItem) {
		int position = findItem(currItem);
		if (position >= 0) {
			modifyGroceryItem(position, newItem);
		}
	}

	private void modifyGroceryItem(int position, String newItem) {
		groceryList.set(position, newItem);
		System.out.println("Grocery item has been modified");
	}

	public void removeGroceryItem(String newItem) {
		int position = findItem(newItem);
		if (position >= 0) {
			removeGroceryItem(position);
		}
	}

	private void removeGroceryItem(int position) {
		String theItem = groceryList.get(position);
		groceryList.remove(position);
		System.out.println(theItem + " is removed from grocery list");
	}

	public boolean onList(String searchItem) {
		int position = findItem(searchItem);
		if (position >= 0) {
			return true;
		}
		return false;
	}

	private int findItem(String searchItem) {
		// boolean exists=groceryList.contains(searchItem);
		/*
		 * int position = groceryList.indexOf(searchItem); if (position >= 0) { return
		 * groceryList.get(position); } return null;
		 */
		return groceryList.indexOf(searchItem);
	}
}
