package in.himanshugawari.ds.stack;

/**
 * @author himanshu
 *
 */
public class PersonStack {
	private Person[] stack;
	private int top;
	private int size;

	public PersonStack() {
		top = -1;
		size = 50;
		stack = new Person[50];
	}

	public PersonStack(int size) {
		this.size = size;
		this.stack = new Person[this.size];
	}

	public boolean push(Person item) {
		if (!isFull()) {
			top++;
			this.stack[top] = item;
			return true;
		} else {
			return false;
		}
	}

	public Person pop() {
		return this.stack[top--];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == stack.length - 1);
	}
}
