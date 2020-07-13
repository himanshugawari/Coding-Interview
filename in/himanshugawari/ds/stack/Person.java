package in.himanshugawari.ds.stack;

/**
 * @author himanshu
 *
 */
public class Person {
	private String name;
	private int rollno;

	public Person(String name, int rollno) {
		super();
		this.name = name;
		this.rollno = rollno;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", rollno=" + rollno + "]";
	}
}