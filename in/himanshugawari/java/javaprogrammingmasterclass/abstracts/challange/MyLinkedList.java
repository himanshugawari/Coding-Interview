package in.himanshugawari.java.javaprogrammingmasterclass.abstracts.challange;

public class MyLinkedList implements NodeList {

	private ListItem root = null;

	public MyLinkedList(ListItem root) {
		super();
		this.root = root;
	}

	@Override
	public ListItem getRoot() {
		return this.root;
	}

	@Override
	public boolean addItem(ListItem item) {
		if (this.root == null) {
			// list is empty so this items becomes root
			this.root = item;
			return true;
		}
		ListItem currItem = this.root;
		while (currItem != null) {
			int comparison = currItem.compareTo(item);
			if (comparison < 0) {
				// item is greater, move right if possible
				if (currItem.next() != null) {
					currItem = currItem.next();
				} else {
					// there is no next, so insert at the end of the list
					currItem.setNext(item);
					item.setPrevious(currItem);
				}
				return true;
			} else if (comparison > 0) {
				// item is less, insert before
				if (currItem.previous() != null) {
					currItem.previous().setNext(item);
					item.setPrevious(currItem.previous());
					item.setNext(currItem);
					currItem.setPrevious(item);
				} else {
					// the node without a previous is root
					item.setNext(this.root);
					this.root.setPrevious(item);
					this.root = item;
				}
				return true;
			} else {
				// equal
				System.out.println(item.getValue() + " is already present, not added");
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean removeItem(ListItem item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void traverse(ListItem root) {
		// TODO Auto-generated method stub

	}

}
