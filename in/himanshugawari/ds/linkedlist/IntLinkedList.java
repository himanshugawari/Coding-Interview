package in.himanshugawari.ds.linkedlist;

/**
 * @author himanshu
 *
 */
public class IntLinkedList {
	private Node head;

	public IntLinkedList(int item) {
		super();
		this.head = new Node();
		this.head.value = item;
		this.head.link = null;
	}

	public boolean deleteItem(int item) {
		if (head.value == item) {
			head = head.link;
		} else {
			Node x = head;
			Node y = head.link;
			while (true) {
				if (y == null || y.value == item) {
					break;
				} else {
					x = y;
					y = y.link;
				}
			}
			if (y != null) {
				x.link = y.link;
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public boolean insertItem(int item) {
		Node n = new Node();
		n.value = item;
		n.link = head;
		head = n;
		return true;
	}

	public void printList() {
		Node z = head;
		while (z != null) {
			System.out.println(z.value);
			z = z.link;
		}
	}

	class Node {
		private int value;
		private Node link;
	}
}
