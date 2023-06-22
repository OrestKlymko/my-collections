public class MyHashMap<K, V> {

	private static class Node<K, V> {
		K key;
		V value;
		Node<K, V> next;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}

	private static final int DEFAULT_CAPACITY = 16;
	private Node<K, V>[] buckets;
	private int size;

	public MyHashMap() {
		this(DEFAULT_CAPACITY);
	}

	public MyHashMap(int capacity) {
		this.buckets = new Node[capacity];
		this.size = 0;
	}

	public void put(K key, V value) {
		int index = getIndex(key);
		Node<K, V> newNode = new Node<>(key, value);

		if (buckets[index] == null) {
			buckets[index] = newNode;
		} else {
			Node<K, V> current = buckets[index];
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

	public void remove(K key) {
		int index = getIndex(key);

		if (buckets[index] == null) {
			return;
		}

		Node<K, V> prev = null;
		Node<K, V> current = buckets[index];

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

	public V get(K key) {
		int index = getIndex(key);
		Node<K, V> current = buckets[index];

		while (current != null) {
			if (current.key.equals(key)) {
				return current.value;
			}
			current = current.next;
		}

		return null;
	}

	private int getIndex(K key) {
		if (key == null) {
			return 0;
		}
		return Math.abs(key.hashCode() % buckets.length);
	}
}
