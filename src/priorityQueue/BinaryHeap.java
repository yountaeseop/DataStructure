package priorityQueue;

public class BinaryHeap<Key extends Comparable<Key>, Value> {
	// MinHeap으로 구현 -> 가장 작은 값이 우선순위가 가장 높음
	private Entry[] a; // a[0]은 사용 안 함
	private int N;	// 힙의 크기
	public BinaryHeap(Entry[] harray, int initialSize) {  // 생성자
		a = harray;
		N = initialSize;
	}
	public int size() {
		return N;	// 힙의 크기 반환
	}
	
	private boolean greater(int i, int j) { // 키 비교
		return a[i].getKey().compareTo(a[j].getKey()) > 0;
		// i - j > 0
		// i가 key값이 더 클 경우, true를 반환
		// true를 반환할 경우 downheap에선 i값이 더 크기때문에 
		// swap()매서드 진행
	}
	private void swap(int i, int j) { // a[i]와 a[j]를 교환
		Entry temp = a[i];
		a[i] =a[j];
		a[j] = temp;
	}
	
	// createheap, insert, deleteMin, downheap, upheap 메소드 선언
	
	public void createHeap() {	// 초기 힙 만들기
		for(int i = N/2; i > 0; i--) {
			// i가 N/2부터 시작하는 이유는 힙이 완전 이진트리로
			// 구현돼있다고 가정할때, 맨 마지막 리프노드들의 부모노드 개수
			// 부터 접근해나가면 되기때문에 리프노드의 개수(N)을 반으로 나눈
			// N/2부터 힙을 만드는 것이다.
			downheap(i);
		}
	}
	
	private void downheap(int i) {
		while(2 * i <= N) {
			int k = 2*i; // i의 leftChild
			if(k < N && greater(k, k+1)) k++;
			// k < N 이 부분은 i의 rightChild가 없을 경우를 고려하기 위함
			if(!greater(i, k)) break;
			swap(i, k);
			i = k;
		}
	}
	
	public void insert(Key newKey, Value newValue) {
		Entry temp = new Entry(newKey, newValue);
		a[++N] = temp;
		upheap(N);
	}
	
	private void upheap(int j) {
		while(j > 1 && greater(j/2, j)) {
			swap(j/2, j);
			j = j/2;
		}
	}
	
	public Entry deleteMin() {
		Entry min = a[1]; // 첫번째 엔트리 추출
		swap(1, N--); // 첫번재 자리와 최하위자리 엔트리 자리바꿈
		a[N+1] = null; // 마지막 자리를 null해서 최소값 삭제
		// swap에서 전역변수 N이 -1됐으니
		// 마지막 자리 인덱스는 N+1을 해줘야한다.
		downheap(1); // downheap으로 정리
		return min;
	}
	
	public void print() {
		for(int i = 1; a[i] != null; i++) {
			System.out.printf("[%d %s] ",a[i].getKey(),a[i].getValue());
		}
		System.out.println();
		System.out.println("힙 크기 = " + size());
		System.out.println();
	}
}
