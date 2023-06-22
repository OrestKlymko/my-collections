public class MyLinkedList<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size;

	public void add(T value) {
		Node<T> newNode = new Node<>(value);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail = newNode;
		}

		size++;
	}

	public void remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		Node<T> currentNode = getNode(index);

		if (currentNode.getPrevious() != null) {
			currentNode.getPrevious().setNext(currentNode.getNext());
		} else {
			head = currentNode.getNext();
		}

		if (currentNode.getNext() != null) {
			currentNode.getNext().setPrevious(currentNode.getPrevious());
		} else {
			tail = currentNode.getPrevious();
		}

		size--;
	}

	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		Node<T> currentNode = getNode(index);
		return currentNode.getValue();
	}

	private Node<T> getNode(int index) {
		Node<T> currentNode = head;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.getNext();
		}
		return currentNode;
	}

	private static class Node<T> {
		private T value;
		private Node<T> previous;
		private Node<T> next;

		public Node(T value) {
			this.value = value;
		}

		public T getValue() {
			return value;
		}

		public Node<T> getPrevious() {
			return previous;
		}

		public void setPrevious(Node<T> previous) {
			this.previous = previous;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}
	}
}
