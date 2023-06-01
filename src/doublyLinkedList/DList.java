package doublyLinkedList;

import java.util.NoSuchElementException;

public class DList <E> {
	protected Node head;
	protected Node tail;
	protected int size;
	
	public DList() { // 생성자
		head = new Node(null, null, null);
		tail = new Node(null, head, null); //tail의 이전 노드를 head로 만든다.
		head.setNext(tail); //head의 다음 노드를 tail로 만든다.
		// head와 tail은 실재로 항목을 저장하지 않는 Dummy노드
		// head와 tail을 더미노드로 만들어야 delete하는 경우에 
		// DList가 아예 없어지는 경우를 방지할 수 있다.
		// 그리고 head와 tail을 만들어서 양쪽에서 요소를 접근할 수 있도록한다.
		
		size = 0;
	}
	
	// 삽입, 삭제 연산을 위한 메소드 선언
	public void insertBefore(Node p, E value) {
		// p가 가리키는 노드 앞에 삽입
		Node t = p.getPrevious();
		Node newNode = new Node(value, t, p);
		p.setPrevious(newNode);
		t.setNext(newNode);
		size++;
	}
	
	public void insertAfter(Node p, E value) {
		// p가 가리키는 노드 뒤에 삽입
		Node t = p.getNext();
		Node newNode = new Node(value, p, t);
		p.setNext(newNode);
		t.setPrevious(newNode);
		size++;
	}
	
	public void delete(Node x) { // x가 가리키는 노드 삭제
		if(x == null) {
			throw new NoSuchElementException();
		}
		Node p = x.getPrevious();
		Node n = x.getNext();
		x = null;
		p.setNext(n);
		n.setPrevious(p);
		size--;
	}
	
	public void print() {
		for(Node p = head; p != null; p = p.getNext()) {
			if(p != head && p != tail) {
				System.out.print(p.getValue() + " ");
			}
		}
		System.out.println();
	}
	
}
