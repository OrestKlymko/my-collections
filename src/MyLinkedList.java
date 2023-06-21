public class MyLinkedList {

	private Node head;
	private Node tail;
	private int size;

	public void add(Object value) {
		Node newNode = new Node(value);

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

		Node currentNode = getNode(index);

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

	public Object get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		Node currentNode = getNode(index);
		return currentNode.getValue();
	}

	private Node getNode(int index) {
		Node currentNode = head;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.getNext();
		}
		return currentNode;
	}

	private class Node {
		private Object value;
		private Node previous;
		private Node next;

		public Node(Object value) {
			this.value = value;
		}

		public Object getValue() {
			return value;
		}

		public Node getPrevious() {
			return previous;
		}

		public void setPrevious(Node previous) {
			this.previous = previous;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}
}

