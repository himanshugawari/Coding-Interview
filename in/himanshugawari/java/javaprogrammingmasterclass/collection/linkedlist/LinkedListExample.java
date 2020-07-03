package in.himanshugawari.java.javaprogrammingmasterclass.collection.linkedlist;

import java.util.ArrayList;

/**
 * @author himanshu
 *
 */
public class LinkedListExample {
	public static void main(String[] args) {
		Customer customer = new Customer("Tim", 54.96);
		Customer anotherCustomer = customer;
		anotherCustomer.setBalance(12.18);
		System.out.println("Balance for customer " + customer.getName() + " is " + customer.getBalance());

		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(3);
		intList.add(4);
		intList.forEach(System.out::println);
		System.out.println();
		intList.add(1, 2);
		intList.forEach(s -> System.out.println(s));
	}
}

class Customer {
	private String name;
	private double balance;

	public Customer(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Customer [name = " + name + ", balance = " + balance + " ]";
	}
}
