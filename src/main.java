
import java.util.NoSuchElementException;

public class main {

	public static void main(String[] args) {
		
		ArrList<String> students = new ArrList<String>();
		students.print();
		students.insertLast("철수");
		students.print();
		students.insertLast("영희");
		students.print();
		students.insertLast("길동");
		students.print();
		students.insert("태섭", 3);
		students.print();
		students.insert("영서", 3);
		students.print();
		students.delete(3);
		students.print();
		System.out.println("3번째 자리엔 " + students.peek(3) + "이가 살고 있어요~");
		
	}

}

class ArrayList <E> {
	// 어떤 객체 타입이 오든 대응할 수 있도록 Generic클래스로 구현함
	E list[]; // 리스트의 항목들을 저장할 배열
	int size; // 리스트의 항목 수
	
	ArrayList(){ // 생성자
		list = (E[]) new Object[1]; 
		size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	} // 리스트가 empty이면 true리턴
	
	public void insertLast(E newItem) {
		if(list.length == size) {
			resize(list.length * 2);
		}
		list[size] = newItem;
		size++;
	}

	private void resize(int newSize) {
		E[] newList = (E[])new Object[newSize];
		
		for(int a = 0; a < size; a++) {
			newList[a] = list[a];
		}
		
		list = (E[])newList;
	}
	
	public void insert(E newItem, int k) {
		if(size == list.length) {
			resize(2*list.length);
		}
		
		for(int a = size-1; a >= k; a--) {
			list[a+1] = list[a];
		}
		//size에서 -1을 해야지 맨 마지막 요소를 선택할 수 있고
		//맨 마지막 요소인 size-1에서 옮기고 싶은 자리인 k까지 돌려야
		//마지막 요소 ~ 넣고 싶은 자리 사이의 요소를 모두 뒤로 옮길 수가 있다.
		
//		for(int a = k; a < size; a++) {
//			list[a+1] = list[a];
//		}
		// 이렇게 넣고 싶은 자리부터 옮기는게 단순하긴 하다.
		
		list[k] = newItem;
		size++;
	}
	
	public void delete(int k) {
		
		for(int a = k; a < size; a++) {
			list[a] = list[a+1];
		}
		
		size--;
		
		if(size > 0 && size == list.length / 4) {
			resize(2*list.length);
		}
	}
	
	public E peek(int k) {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		return list[k];
	}
	
	public void print() {
		if(isEmpty()) {
			System.out.println("배열이 비어있음.");
		} else {
			for(int i = 0; i < list.length; i++) {
				System.out.print(list[i]+"\t");
			}
			System.out.println();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}