package binarySearchTree;

public class Main {

	public static void main(String[] args) {
		
		BinarySearchTree t = new BinarySearchTree(500, "Apple");
		
		t.put(600, "Banana");
		t.put(200, "Melon");
		t.put(100, "Orange");
		t.put(400, "Tangerine");
		t.put(250, "kiwi");
		t.put(150, "Grape");
		t.put(800, "Strawberry");
		t.put(700, "Cherry");
		t.put(50, "Pear");
		t.put(350, "Lemon");
		t.put(10, "Watermelon");
		
		t.print(t.root);
		System.out.println();
		
		t.delete(200);
		t.print(t.root);
		
		
		//System.out.println("높이 = "+t.height());
	}

}
