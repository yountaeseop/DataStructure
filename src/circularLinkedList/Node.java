package circularLinkedList;

public class Node<E> {
	
	protected Node<E> nextNode;
	private E value;

	public Node(Node<E> nextNode, E value) {
		this.nextNode = nextNode;
		this.value = value;
	}

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}

	public Node<E> getNext() {
		return nextNode;
	}

	public void setNext(Node<E> nextNode) {
		this.nextNode = nextNode;
	}

}
