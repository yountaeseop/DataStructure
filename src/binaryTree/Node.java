package binaryTree;

public class Node<E> {
	E value;
	Node<E> leftNode;
	Node<E> rightNode;

	public Node(E value, Node<E> leftNode, Node<E> rightNode) {
		this.value = value;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}

	public E getKey() {return value;}

	public Node<E> getLeft() {return leftNode;}

	public Node<E> getRight() {return rightNode;}

	public void setKey(E value) {this.value = value;}

	public void setLeft(Node<E> leftNode) {this.leftNode = leftNode;}

	public void setRight(Node<E> rightNode) {this.rightNode = rightNode;}
}
