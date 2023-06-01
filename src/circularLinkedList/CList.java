package circularLinkedList;

import java.util.NoSuchElementException;

public class CList<E> {
	// protected Node<E> head;
	protected Node<E> last;
	private int size;

	public CList() {
		this.last = null;
		this.size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void insert(E value) { // last가 가리키는 노드의 다음에 새노드 삽입
		Node newNode = new Node(null, value);
		if( last == null ) {
			newNode.setNext(newNode);
			last = newNode;
		}
		else {
			newNode.setNext(last.getNext());
			// newNode의 다음 노드가 last가 가리키는 노드의 다음노드가 되도록
			last.setNext(newNode); 
			// last가 가리키는 노드의 다음 노드가 newNode가 되도록
		}
		size++;
	}
	// Node p앞에 값 value를 삽입

	public Node delete() { // last가 가리키는 노드의 다음 노드를 제거
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		Node x = last.getNext(); // last.getNext()가 0번째 노드를 뜻함
		
		if(x == last) {
			last = null; //리스트에 1개의 노드만 있는 경우
		} else {
			last.setNext(x.getNext()); 
			x.setNext(null);
		}
		size--;
		return x;
		
	}

	public void print() {
		if(size > 0) { // 연결리스트를 차례로 출력
			int i = 0;
			for(Node p = last.getNext(); i < size; p = p.getNext(), i++) {
				System.out.print(p.getValue() + "\t ");
			}
		} else {
			System.out.println("리스트 비어있음.");
		}
	}

}
