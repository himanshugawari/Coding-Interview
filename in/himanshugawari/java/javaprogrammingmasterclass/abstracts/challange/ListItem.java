package in.himanshugawari.java.javaprogrammingmasterclass.abstracts.challange;

public abstract class ListItem {
	protected ListItem rightLink = null;
	protected ListItem leftLink = null;
	protected Object value;

	public ListItem(Object value) {
		super();
		this.value = value;
	}

	abstract ListItem next();

	abstract ListItem setNext(ListItem item);

	abstract ListItem previous();

	abstract ListItem setPrevious(ListItem item);

	abstract int compareTo(ListItem item);

	public void setValue(Object value) {
		this.value = value;
	}

	public Object getValue() {
		return value;
	}
}
