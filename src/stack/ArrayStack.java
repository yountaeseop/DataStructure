package stack;

import java.util.EmptyStackException;

public class ArrayStack <E>{
	private E s[];	// 스택을 위한 배열
	private int top; // 스택의 top 항목의 배열 원소 인덱스
	
	public ArrayStack() {	// 스택 생성자
		s = (E[])new Object[1]; // 초기에 크기가 1인 배열 생성
		top = -1;
	}
	
	public int size() {
		return top + 1; // 스택에 있는 항목의 수 반환
	}
	
	public boolean isEmpty() { // 스택이 empty이면 true 리턴
		return (top == -1);
	}
	
	public E peek() { // 스택 top 항목의 내용만을 리턴
		if(isEmpty()){
			throw new EmptyStackException();//underflow시 프로그램 정지
		}
		return s[top];
	}
	
	public void push(E newValue) { // push 연산
		if(size() == s.length) {
			resize(2*s.length); // 스택을 2배 크기로 확장
		}
		s[++top] = newValue; // 새 항목을 push
	}
	
	
	public void resize(int newSize) { // 배열 크기 조절
		Object[] t = new Object[newSize]; //newSize 크기의 새로운 배열 t 생성
		
		for(int i = 0; i < size(); i++) {
			t[i] = s[i];	// 배열 s를 배열 t로 복사
		}
		s = (E[])t;		// 배열 t를 배열 s로
	}
	
	public E pop() {	 // pop 연산
		if(isEmpty()) {
			throw new EmptyStackException(); //underflow시 프로그램 정지
		}
		E item = s[top];
		s[top--] = null;	// null로 초기화
		if(size() > 0 && size() == s.length/4) {
			resize(s.length/2);	// 스택을 1/2 크기로 축소
		}
		return item;
	}
	
	public void print() { // 스택의 항목들을 아래에서 위로 출력
		if(isEmpty()) {
			System.out.println("스택이 비어있음.");
		} else {
			for(int a = 0; a < size(); a++) {
				System.out.print(s[a] + "\t ");
			}
		}
		System.out.println();
	}
	
	
	
	
	
}
