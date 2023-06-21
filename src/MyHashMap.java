public class MyHashMap {

	private static class Node {
		Object key;
		Object value;
		Node next;

		public Node(Object key, Object value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}

	private static final int DEFAULT_CAPACITY = 16;
	private Node[] buckets;
	private int size;

	public MyHashMap() {
		this(DEFAULT_CAPACITY);
	}

	public MyHashMap(int capacity) {
		this.buckets = new Node[capacity];
		this.size = 0;
	}

	public void put(Object key, Object value) {
		int index = getIndex(key);
		Node newNode = new Node(key, value);

		if (buckets[index] == null) {
			buckets[index] = newNode;
		} else {
			Node current = buckets[index];
			while (current.next != null) {
				if (current.key.equals(key)) {
					current.value = value;
					return;
				}
				current = current.next;
			}
			if (current.key.equals(key)) {
				current.value = value;
			} else {
				current.next = newNode;
			}
		}

		size++;
	}

	public void remove(Object key) {
		int index = getIndex(key);

		if (buckets[index] == null) {
			return;
		}

		Node prev = null;
		Node current = buckets[index];

		while (current != null) {
			if (current.key.equals(key)) {
				if (prev == null) {
					buckets[index] = current.next;
				} else {
					prev.next = current.next;
				}
				size--;
				return;
			}
			prev = current;
			current = current.next;
		}
	}

	public void clear() {
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = null;
		}
		size = 0;
	}

	public int size() {
		return size;
	}

	public Object get(Object key) {
		int index = getIndex(key);
		Node current = buckets[index];

		while (current != null) {
			if (current.key.equals(key)) {
				return current.value;
			}
			current = current.next;
		}

		return null;
	}

	private int getIndex(Object key) {
		if (key == null) {
			return 0;
		}
		return Math.abs(key.hashCode() % buckets.length);
	}
}
