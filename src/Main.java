public class Main {
	public static void main(String[] args) {

		MyArrayList myArrayList = new MyArrayList();
		myArrayList.add("Orest");
		myArrayList.add("Oleg");
		myArrayList.add("Nastia");
		myArrayList.add("Andrii");
		myArrayList.remove(1);
		System.out.println("myArrayList = " + myArrayList);
	}
}