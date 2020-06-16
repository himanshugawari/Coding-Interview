package in.himanshugawari.java.javaprogrammingmasterclass.abstracts.BinarySearchTreeImplementation;

public class SearchTree implements NodeList {

	private ListItem root = null;

	public SearchTree(ListItem root) {
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
			// tree is empty so this items becomes root
			this.root = item;
			return true;
		}

		// otherwise start comparing from the head of the tree
		ListItem currItem = this.root;
		while (currItem != null) {
			int comparison = currItem.compareTo(item);
			if (comparison < 0) {
				// item is greater, move right if possible
				if (currItem.next() != null) {
					currItem = currItem.next();
				} else {
					// there is no node at right, so add at this point
					currItem.setNext(item);
					return true;
				}
			} else if (comparison > 0) {
				// item is less, move left if possible
				if (currItem.previous() != null) {
					currItem = currItem.previous();
				} else {
					// there is no node to the left so add at this point
					currItem.setPrevious(item);
					return true;
				}
			} else {
				// equal so do not add
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
		ListItem parentItem = currItem;
		while (currItem != null) {
			int comparision = currItem.compareTo(item);
			if (comparision < 0) {
				parentItem = currItem;
				currItem = currItem.next();
			} else if (comparision > 0) {
				parentItem = currItem;
				currItem = currItem.previous();
			} else {
				// equal, we have found the item so remove it
				performRemoval(currItem, parentItem);
				return true;
			}
		}
		return false;
	}

	private void performRemoval(ListItem item, ListItem parent) {
		// remove item from the tree
		if (item.next() == null) {
			// no right tree, so make parent point to left tree (which may be null)
			if (parent.next() == item) {
				// item is right child of its parent
				parent.setNext(item.previous());
			} else if (parent.previous() == item) {
				// item is left child of its parent
				parent.setPrevious(item.previous());
			} else {
				// parent must be item, which means we were looking at the root of the tree
				this.root = item.previous();
			}
		} else if (item.previous() == null) {
			// no left tree, so make parent point to right tree (which may be null)
			if (parent.next() == item) {
				// item is right child of its parent
				parent.setNext(item.next());
			} else if (parent.previous() == item) {
				// item is left child of its parent
				parent.setPrevious(item.next());
			} else {
				// again, we are deleting the root
				this.root = item.next();
			}
		} else {
			// neither left nor right are null, deletion is now a lot trickier!
			// From the right sub-tree, find the smallest value (i.e., the leftmost).
			ListItem current = item.next();
			ListItem leftmostParent = item;
			while (current.previous() != null) {
				leftmostParent = current;
				current = current.previous();
			}
			// Now put the smallest value into our node to be deleted
			item.setValue(current.getValue());
			// and delete the smallest
			if (leftmostParent == item) {
				// there was no leftmost node, so 'current' points to the smallest
				// node (the one that must now be deleted).
				item.setNext(current.next());
			} else {
				// set the smallest node's parent to point to
				// the smallest node's right child (which may be null).
				leftmostParent.setPrevious(current.next());
			}
		}
	}

	@Override
	public void traverse(ListItem item) {
		if (item != null) {
			traverse(item.previous());
			System.out.println(item.getValue());
			traverse(item.next());
		} else {
			// System.out.println("Empty Tree");
		}
	}

}
