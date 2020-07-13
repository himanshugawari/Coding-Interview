package in.himanshugawari.ds.queue;

/**
 * @author himanshu
 *
 */
public class IntQueue {
	private int[] q;
	private int total;
	private int size;
	private int front;
	private int rear;

	public IntQueue() {
		total = 0;
		front = 0;
		rear = 0;
		size = 100;
		q = new int[this.size];
	}

	public IntQueue(int size) {
		total = 0;
		front = 0;
		rear = 0;
		this.size = size;
		q = new int[this.size];
	}

	public int dequeue() {
		int item = q[front];
		total--;
		// front++;
		front = (front + 1) % size;
		return item;
	}

//	public boolean isEmpty() {
//		return (top == -1);
//	}

	public boolean enque(int item) {
		if (isFull()) {
			return false;
		} else {
			total++;
			q[rear] = item;
			// rear++;
			rear = (rear + 1) % size;
			return true;
		}
	}

	public boolean isFull() {
		if (size == total) {
			return true;
		} else {
			return false;
		}
	}

	public void showAll() {
		int f = front;
		if (total != 0) {
			for (int i = 0; i < total; i++) {
				System.out.print(" " + q[f]);
				f = (f + 1) % size;
			}
		}
	}
}
