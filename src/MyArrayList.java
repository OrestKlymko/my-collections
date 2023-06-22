import java.util.Arrays;

public class MyArrayList<T> {
	private T[] array;

	public MyArrayList() {
		array = (T[]) new Object[0];
	}

	public void add(T value) {
		T[] temp = Arrays.copyOf(array, array.length + 1);
		temp[temp.length - 1] = value;
		array = temp;
	}

	public void remove(int index) {
		if (index < 0 || index >= array.length) {
			throw new IndexOutOfBoundsException("Invalid index");
		}

		T[] temp = (T[]) new Object[array.length - 1];
		int tempIndex = 0;

		for (int i = 0; i < array.length; i++) {
			if (i != index) {
				temp[tempIndex] = array[i];
				tempIndex++;
			}
		}

		array = temp;
	}

	public void clear() {
		array = (T[]) new Object[0];
	}

	public int size() {
		return array.length;
	}

	@Override
	public String toString() {
		return Arrays.toString(array);
	}

	public T get(int index) {
		if (index < 0 || index >= array.length) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		return array[index];
	}
}
