package circularLinkedList;

public class Main {

	public static void main(String[] args) {
		CList<String> s = new CList<String>();
		// 연결 리스트 
		
		s.insert("pear");
		s.insert("cherry");
		s.insert("orange");
		s.insert("apple");
		s.print();
		System.out.print(": s의 길이 ="+s.size()+"\n");
		
		s.delete();
		s.print();
		System.out.println(" : s의 길이 = " + s.size());
		System.out.println();
		
		
		s.delete();
		s.delete();
		s.printx(); // last의 요소까지 같이 출력해보기
					// last와 last.getNext()가 동일하게 출력된다.
		
	}

}
