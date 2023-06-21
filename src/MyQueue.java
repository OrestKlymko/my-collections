public class MyQueue {

	private Object[] queue;
	private int front;
	private int rear;
	private int size;

	public MyQueue() {
		queue = new Object[10];
		front = 0;
		rear = -1;
		size = 0;
	}

	public void add(Object value) {
		if (size == queue.length) {
			resizeQueue();
		}

		rear = (rear + 1) % queue.length;
		queue[rear] = value;
		size++;
	}

	public void clear() {
		queue = new Object[10];
		front = 0;
		rear = -1;
		size = 0;
	}

	public int size() {
		return size;
	}

	public Object peek() {
		if (size == 0) {
			return null;
		}

		return queue[front];
	}

	public Object poll() {
		if (size == 0) {
			return null;
		}

		Object element = queue[front];
		front = (front + 1) % queue.length;
		size--;
		return element;
	}

	private void resizeQueue() {
		int newSize = queue.length * 2;
		Object[] newQueue = new Object[newSize];

		for (int i = 0; i < size; i++) {
			newQueue[i] = queue[front];
			front = (front + 1) % queue.length;
		}

		front = 0;
		rear = size - 1;
		queue = newQueue;
	}
}
