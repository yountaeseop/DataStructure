package redBlackTree;

class Node<Key extends Comparable<Key>, Value> { // Node 클래스
	public Key id;
	Value name;
	Node left, right;
	boolean color; // 부모 link의 색
	
	public Node(Key k, Value v, boolean col) { // 노드 생성자
		id = k;
		name = v;
		color = col;
		left = right = null;
	}

	public Key getId() {
		return id;
	}

	public void setId(Key id) {
		this.id = id;
	}

	public Value getName() {
		return name;
	}

	public void setName(Value name) {
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

	public boolean isColor() {
		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}
}
