import java.util.Arrays;

public class MyArrayList<T> {
	private static final int INITIAL_CAPACITY = 15;
	private static final int CAPACITY_INCREMENT = 15;

	private T[] array;
	private int size;

	public MyArrayList() {
		array = (T[]) new Object[INITIAL_CAPACITY];
		size = 0;
	}

	public void add(T value) {
		if (size == array.length) {
			expandArray();
		}
		array[size] = value;
		size++;
	}

	public void remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index");
		}

		for (int i = index; i < size - 1; i++) {
			array[i] = array[i + 1];
		}

		array[size - 1] = null;
		size--;
	}

	public void clear() {
		Arrays.fill(array, null);
		size = 0;
	}

	public int size() {
		return size;
	}

	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOf(array, size));
	}

	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		return array[index];
	}

	private void expandArray() {
		array = Arrays.copyOf(array, array.length + CAPACITY_INCREMENT);
	}
}
