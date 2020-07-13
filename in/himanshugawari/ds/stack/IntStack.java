package in.himanshugawari.ds.stack;

/**
 * @author himanshu
 *
 */
public class IntStack {
	private int[] stack;
	private int top;
	private int size;

	public IntStack() {
		top = -1;
		size = 50;
		stack = new int[50];
	}

	public IntStack(int size) {
		this.size = size;
		this.stack = new int[this.size];
	}

	public boolean push(int item) {
		if (!isFull()) {
			top++;
			this.stack[top] = item;
			return true;
		} else {
			return false;
		}
	}

	public int pop() {
		return this.stack[top--];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == stack.length - 1);
	}
}