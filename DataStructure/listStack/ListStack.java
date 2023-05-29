package listStack;

import java.util.EmptyStackException;

public class ListStack <E> {
	private Node<E> top;	// 스택 top항목을 가진 Node를 가리키기 위해
	private int size;	    // 스택의 항목 수
	
	public ListStack() {	// 스택 생성자
		top = null;
		size = 0;
	}
	
	public int size() {	// 스택의 항목의 수를 반환
		return size;	
	}
	
	public boolean isEmpty() {	// 스택의 항목의 수를 반환
		return size == 0;	// 스택이 empty이면 true반환
	}
	
	public E peek() {	// 스택top 항목만을 반환
		if(isEmpty()) {
			throw new EmptyStackException();
			// underflow시 프로그램 정지
		}
		return top.getItem();
	}
	
	public void push(E newItem) {  // 스택 push 연산
		Node newNode = new Node(newItem, top);	// 리스트 앞부분에 삽입
		top = newNode;	// top이 새 노드 가리킴
		size++;	// 스택 항목 수 1 증가
	}
	
    public E pop() {	// 스택 pop연산
    	if(isEmpty()) {
    		throw new EmptyStackException();  // underflow시 프로그램 정지
    	}
    	E topItem = top.getItem();	// 스택top 항목을 topItem에 저장
    	top = top.getNext();	// top이 top 바로 아래 항목을 가리킴
    	size--;		// 스택 항목 수를 1감소
    	return topItem;
    }
    
    
}
