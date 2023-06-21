public class MyStack {

	private Object[] stack;
	private int top;
	private int size;

	public MyStack() {
		stack = new Object[10]; // Початковий розмір масиву стеку
		top = -1;
		size = 0;
	}

	public void push(Object value) {
		if (size == stack.length) {
			resizeStack();
		}

		top++;
		stack[top] = value;
		size++;
	}

	public void remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		int elementsToMove = size - index - 1;
		if (elementsToMove > 0) {
			System.arraycopy(stack, index + 1, stack, index, elementsToMove);
		}

		stack[top] = null;
		top--;
		size--;
	}

	public void clear() {
		stack = new Object[10];
		top = -1;
		size = 0;
	}

	public int size() {
		return size;
	}

	public Object peek() {
		if (size == 0) {
			return null;
		}

		return stack[top];
	}

	public Object pop() {
		if (size == 0) {
			return null;
		}

		Object element = stack[top];
		stack[top] = null;
		top--;
		size--;
		return element;
	}

	private void resizeStack() {
		int newSize = stack.length * 2;
		Object[] newStack = new Object[newSize];
		System.arraycopy(stack, 0, newStack, 0, size);
		stack = newStack;
	}
}
