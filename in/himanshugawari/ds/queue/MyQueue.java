package in.himanshugawari.ds.queue;

/**
 * @author himanshu
 *
 */

// enque, dequeue, front(just added), rear(added first) 
public class MyQueue {
	public static void main(String[] args) {

//		IntQueue queue = new IntQueue();
//		if (!queue.isFull()) {
//			queue.enque(3);
//			queue.enque(4);
//			queue.enque(6);
//			queue.enque(9);
//		}
//		queue.showAll();
//		System.out.println();
//		System.out.println(queue.dequeue());

		Person person1 = new Person("himanshu", 123);
		Person person2 = new Person("hardik", 321);
		PersonQueue personQueue = new PersonQueue();
		if (!personQueue.isFull()) {
			personQueue.enque(person1);
			personQueue.enque(person2);
		}
		personQueue.showAll();
		System.out.println();
		System.out.println(personQueue.dequeue());

	}
}
