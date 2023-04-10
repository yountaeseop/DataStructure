package singlyLinkedList;

import java.util.NoSuchElementException;

public class SList<E> {
	public Node<E> head; // 연결 리스트의 첫 노드 가리킴
	private int size;

	public SList() {
		head = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void insertFront(E value) { //연결리스트 맨 앞에 새 노드 삽입
		head = new Node(value, head);
		size++;
	}

	public void insertAfter(E value, Node p) { //노드 p 바로 다음에 새 노드 삽입
		p.setNext(new Node(value, p.getNext()));
		// 노드 p의 다음 노드를 만들어주고 그 노드에 value를 부여한다.
		// 그리고 새로만든 노드의 class내부에 있는 nextNode의 멤버변수에
		// 새로만든 노드 전의 노드의 다음 노드를 꺼내서 저장시키면
		// 새로만든 노드가 이전 노드의 다음노드를 가리키면서 완벽하게 연결된다!  
		size++;
	}

	public void deleteFront() {  // 리스트의 첫 노드 삭제
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		head = head.getNext();
		//head의 값을 head의 다음 값으로 변경
		
		size--;
	}

	public void deleteAfter(Node<E> p) { //p가 가리키는 노드의 다음 노드를 삭제
		if(p == null) {
			throw new NoSuchElementException();
		}
		Node<E> t = p.getNext();
		p.setNext(t.getNext());
		t.setNext(null); // 쓰레기값 정리
		size--;
	}

	public int search(E value) { // 값으로 탐색, 검색한 값의 index 반환
		Node p = head;
		for(int a = 0; a < size; a++) {
			if(value == p.getValue()) {
				return a;
			}
			p = p.getNext();
		}
		return -1;
	}

	public void print() { // 노드들을 차례로 출력
		for(Node p = head; p != null; p = p.getNext()) {
			System.out.print(p.getValue() + " ");
		}
		System.out.println();
	}
}
