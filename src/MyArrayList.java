import java.util.Arrays;

public class MyArrayList {
	private Object[] array = new Object[0];

	public void add(Object value) {
		Object[] temp = new Object[array.length+1];
		for (int i = 0; i < array.length; i++) {
			temp[i] = array[i];
		}
		temp[temp.length-1]=value;
		array=temp;
	}

	public void remove(int index) {
		Object[] temp = new Object[array.length - 1];
		int tempIndex = 0;

		for (int i = 0; i < array.length; i++) {
			if (i != index) {
				temp[tempIndex] = array[i];
				tempIndex++;
			}
		}

		array = temp;
	}

	public void clear(){
		array = new Object[0];
	}

	public int size(){
		return array.length;
	}

	@Override
	public String toString() {
		return  Arrays.toString(array);
	}

	public Object get(int index){
		for (int i = 0; i < array.length; i++) {
			if(i==index) return array[i];
		}
		return -1;
	}
}
