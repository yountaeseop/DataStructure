import java.util.NoSuchElementException;

public class Overflow {

//	배열에 overflow가 발생하면 배열 크기를 2배로
//	확장한다. 만일 배열의 3/4이 비어 있으면 배열
//	크기를 1/2로 축소한다.

	public static void main(String[] args) {
		
		
		
		ArrList<String> s = new ArrList<String>();
		s.print();
		s.insertLast("apple");
		s.print() ;
		s.insertLast("orange");
		s.print();
		s.insertLast("cherry");
		s.print();
		s.insertLast("pear");
		s.print();
		s.insert("grape", 1);
		s.print();
		s.insert("lemon", 4);
		s.print();
		s.insertLast("kiwi");
		s.print();
		s.delete(4);
		s.print();
		s.delete(0);
		s.print();
		s.delete(0);
		s.print();
		s.delete(3);
		s.print();
		s.delete(0);
		s.print();

		System.out.println("1번째 항목은" + s.peek(1) + "이다.");
		System.out.println();

	}
}

class ArrList <E> {
	private E a[];
	private int size;

	public ArrList() {
		a = (E[]) new Object[1];
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	} // 리스트가 empty이면 true리턴

	public void insertLast(E newItem) {
		if (size == a.length) {
			resize(2 * a.length);
		}
		a[size] = newItem; //a[size++] = newItem; 이렇게도 가능
							 // size의 +연산이 나중에 된다.	
		size++;
	}

	public void insert(E newItem, int k) { // k번째 자리에 새항목 삽입
		if (size == a.length) {
			resize(2 * a.length);
		}
		for (int i = size - 1; i >= k; i--) {
			a[i + 1] = a[i]; // 한 칸씩 뒤로 이동
		}
		a[k] = newItem;
		size++;
	}

	public E delete(int k) { // k번째 항목 삭제
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		E item = a[k];

		for (int i = k; i < size; i++) {
			a[i] = a[i + 1]; // 한 칸씩 앞으로 이동
		}
		size--;
		if (size > 0 && size == a.length / 4) {
			resize(a.length / 2);
		}

		return item;
	}
	
	public E peek(int k) { // k번째 항목을 리턴, 단순히 읽기만 한다.
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		return a[k];
	}
	
	private void resize(int newSize) {
		Object[] t = new Object[newSize]; // 새로운 배열 선언
		for(int i = 0; i < size; i++) {
			t[i] = a[i];   // 배열 s를 배열 t로 복사
		}
		a = (E[]) t;       // 배열 t를 배열 s로 
	}
	
	public void print() {
		if(isEmpty()) {
			System.out.print("배열이 비어있음.");
		} else {
			for(int i = 0; i < a.length; i++) {
				System.out.print(a[i] + "\t");
			}
		}
		System.out.println();
	}
	
}