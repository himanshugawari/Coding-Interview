package in.himanshugawari.java.javaprogrammingmasterclass.abstracts.LinkedListImplementation;

public interface NodeList {
	
	ListItem getRoot();

	boolean addItem(ListItem item);

	boolean removeItem(ListItem item);

	void traverse(ListItem item);
}
