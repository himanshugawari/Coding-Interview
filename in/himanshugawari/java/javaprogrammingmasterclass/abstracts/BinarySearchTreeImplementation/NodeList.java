package in.himanshugawari.java.javaprogrammingmasterclass.abstracts.BinarySearchTreeImplementation;

public interface NodeList {
	
	ListItem getRoot();

	boolean addItem(ListItem item);

	boolean removeItem(ListItem item);

	void traverse(ListItem item);
}
