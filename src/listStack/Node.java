package listStack;

public class Node <E> {
	private E item;
	private Node<E> next;
	
	public Node(E item, Node<E> next) {
		this.item = item;
		this.next = next;
	}
	
	//get과 set메소드
	public E getItem() {
		return item;
	}
	
	public Node<E> getNext() {
		return next;
	}
	
	public void setItem(E newItem) {
		item = newItem;
	}
	
	public void setNext(Node<E> newNext) {
		next = newNext;
	}
}
