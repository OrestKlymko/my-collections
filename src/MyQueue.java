public class MyQueue<T> {

	private T[] queue;
	private int front;
	private int rear;
	private int size;


	public MyQueue() {
		queue = (T[]) new Object[10];
		front = 0;
		rear = -1;
		size = 0;
	}

	public void add(T value) {
		if (size == queue.length) {
			resizeQueue();
		}

		rear = (rear + 1) % queue.length;
		queue[rear] = value;
		size++;
	}

	public void clear() {
		queue = (T[]) new Object[10];
		front = 0;
		rear = -1;
		size = 0;
	}

	public int size() {
		return size;
	}

	public T peek() {
		if (size == 0) {
			return null;
		}

		return queue[front];
	}

	public T poll() {
		if (size == 0) {
			return null;
		}

		T element = queue[front];
		front = (front + 1) % queue.length;
		size--;
		return element;
	}


	private void resizeQueue() {
		int newSize = queue.length * 2;
		T[] newQueue = (T[]) new Object[newSize];

		for (int i = 0; i < size; i++) {
			newQueue[i] = queue[front];
			front = (front + 1) % queue.length;
		}

		front = 0;
		rear = size - 1;
		queue = newQueue;
	}
}
