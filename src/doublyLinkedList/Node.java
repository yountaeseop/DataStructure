package doublyLinkedList;

public class Node <E> {
	Node<E> previous;
	Node<E> next;
	E value;
	
	public Node(E value, Node<E> previous, Node<E> next) {
		this.value = value;
		this.previous = previous;
		this.next = next;
	}
	
	//get 메소드와 set 메소드
	public E getValue() {
		return value;
	}
	
	public void setValue(E value) {
		this.value = value;
	}
	
	public Node getPrevious() {
		return previous;
	}
	
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
}
