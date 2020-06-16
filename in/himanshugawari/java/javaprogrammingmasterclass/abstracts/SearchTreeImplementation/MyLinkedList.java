package in.himanshugawari.java.javaprogrammingmasterclass.abstracts.SearchTreeImplementation;

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
			System.out.println("Inserting item " + item.getValue());
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
					/*
					 * currItem.setNext(item); item.setPrevious(currItem);
					 */
					// same as above commented code in one line
					currItem.setNext(item).setPrevious(currItem);
					System.out.println("Inserting item " + item.getValue());
					return true;
				}
			} else if (comparison > 0) {
				// item is less, insert before
				if (currItem.previous() != null) {
					/*
					 * currItem.previous().setNext(item); item.setPrevious(currItem.previous());
					 * item.setNext(currItem); currItem.setPrevious(item);
					 */
					/*
					 * currItem.previous().setNext(item).setPrevious(currItem.previous());
					 * item.setNext(currItem).setPrevious(item);
					 */
					currItem.previous().setNext(item).setPrevious(currItem.previous());
					item.setNext(currItem).setPrevious(item);
					System.out.println("Inserting item " + item.getValue());
				} else {
					// the node without a previous is root
					/*
					 * item.setNext(this.root); this.root.setPrevious(item);
					 */
					item.setNext(this.root).setPrevious(item);
					System.out.println("Inserting item " + item.getValue());
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
		if (item != null) {
			System.out.println("Deleting item " + item.getValue());
		}
		ListItem currItem = this.root;
		while (currItem != null) {
			int comparision = currItem.compareTo(item);
			if (comparision == 0) {
				// found the item to delete
				if (currItem == this.root) {
					this.root = currItem.next();
				} else {
					currItem.previous().setNext(currItem.next());
					if (currItem.next() != null) {
						currItem.next().setPrevious(currItem.previous());
					}
				}
				return true;
			} else if (comparision < 0) {
				currItem = currItem.next();
			} else {
				// comparision > 0
				// we are at an item greater than the one to be deleted
				// so the item is not int the list
				return false;
			}
		}
		// we have reached the end of the list
		// without finding the item to delete
		return false;
	}

	@Override
	public void traverse(ListItem item) {
		if (item == null) {
			System.out.println("The list is empty");
		} else {
			while (item != null) {
				System.out.println(item.getValue());
				item = item.next();
			}
		}
	}

}
