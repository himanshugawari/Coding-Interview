package in.himanshugawari.ds.linkedlist;

/**
 * @author himanshu
 *
 */
public class MyLinkedList {
	public static void main(String[] args) {

		IntLinkedList list = new IntLinkedList(2);
		list.insertItem(5);
		list.insertItem(8);
		list.printList();
		System.out.println();
		list.deleteItem(5);
		list.printList();
	}
}
