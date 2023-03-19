package singlyLinkedList;

public class Node <E> {
	private E value;
	private Node<E> nextNode;
	
	public Node(E value, Node<E> nextNode) {
		this.value = value;
		this.nextNode = nextNode;
	}

	public E getValue() {
		return value;
	}
	
	public Node getNext() {
		return nextNode;
	}
	
	public void setValue(E value) {
		this.value = value;
	}
	
	public void setNext(Node<E> nextNode) {
		this.nextNode = nextNode;
	}
}
