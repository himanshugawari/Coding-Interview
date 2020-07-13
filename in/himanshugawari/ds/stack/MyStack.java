package in.himanshugawari.ds.stack;

/**
 * @author himanshu
 *
 */

// top,size,push,pop
public class MyStack {
	public static void main(String[] args) {

//		IntStack intStack = new IntStack();
//		if (!intStack.isFull()) {
//			intStack.push(2);
//			intStack.push(4);
//			intStack.push(6);
//			intStack.push(9);
//		}
//
//		for (int i = 0; i < 6; i++) {
//			if (!intStack.isEmpty()) {
//				System.out.println(intStack.pop());
//			} else {
//				System.out.println("Stack is empty");
//			}
//		}

		Person person1 = new Person("himanshu", 123);
		Person person2 = new Person("hardik", 321);
		PersonStack personStack = new PersonStack();
		if (!personStack.isFull()) {
			personStack.push(person1);
			personStack.push(person2);

		}

		for (int i = 0; i < 6; i++) {
			if (!personStack.isEmpty()) {
				System.out.println(personStack.pop());
			} else {
				System.out.println("Stack is empty");
			}
		}

	}
}
