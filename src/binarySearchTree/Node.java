package binarySearchTree;

public class Node<Key extends Comparable<Key>, Value> {
// Key extends Comparable<Key>를 사용하면 Key 타입으로 지정되는 객체들은 Comparable 인터페이스를 구현해야 한다.
// 이를 통해 Key 객체들 간의 비교가 가능하게 되며, 정렬이나 검색과 같은 작업에서 활용할 수 있다.
	
// Comparable 인터페이스는 자바에서 제공하는 인터페이스로, 객체의 순서를 정의하고 비교하는 기능을 제공한다. 
// Comparable 인터페이스를 구현한 클래스는 compareTo() 메소드를 구현해야 합니다. 
// 이 메소드는 자신과 다른 객체를 비교하여 순서를 결정하고, 비교 결과에 따라 음수, 양수, 또는 0을 반환한다.
	private Key id;
	private Value name;
	private Node left, right;

	public Node(Key newId, Value newName) {
		this.id = newId;
		this.name = newName;
		this.left = null;
		this.right = null;
	}

	public Key getKey() {
		return id;
	}

	public void setKey(Key id) {
		this.id = id;
	}

	public Value getValue() {
		return name;
	}

	public void setValue(Value name) {
		this.name = name;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

}
