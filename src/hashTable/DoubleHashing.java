package hashTable;

public class DoubleHashing<K, V> {
	private int N = 0;
	public int M = 13; // 테이블 크기
	public K[] a = (K[]) new Object[M]; // 해시테이블
	private V[] d = (V[]) new Object[M]; // 해시테이블
	
	private int hash(K key) { // 해시코드
		return (key.hashCode() & 0x7fffffff) % M; // 나눗셈 함수
	}
	
	public void put(K key, V data) { // 삽입 연산
		int initialpos = hash(key);  // 초기 위치
		int i = initialpos, loop_limit = 20;
		int j = 1;
		int dh =(7-(int)key % 7); // 두번째 해시 함수
		// 해시함수를 2가지를 사용해서 시퀀스가 일정하지 않게 배치가능
		// 모든 종류의 군집화 해결
		
		do { // 최소 한번은 코드 진행
			if(a[i] == null) { // 삽입 위치 발견
				a[i] = key;
				d[i] = data; N++;
				return;
			}
			if(a[i].equals(key)) {
				d[i] = data;
				return;
			}
			i = (initialpos + j*dh) % M; // i = 다음 위치
			// (hash(key)+j*d(key)) % 13 
			j++;
			loop_limit -= 1;
		} while (loop_limit > 0); // 현재 i가 초기 위치와 같게 되면 루프 종료
	}
	
	public V get(K key) { // 탐색 연산
		int initialpos = hash(key);
		int i = initialpos, loop_limit = 20;
		int j = 1;
		int dh = (7 - (int)key % 7);
		while (a[i] != null & loop_limit > 0) {
			if(a[i].equals(key)) {
				return d[i];
			}
			i = (initialpos + j*dh) % M;
			j++;
			loop_limit -= 1;
		}
		return null;
	}
	
	public void print() {
		System.out.println("해시 테이블:");

		for (int i = 0; i < M; ++i) // 배열 인덱스
			System.out.printf("\t%2d", i);

		System.out.println();

		for (int i = 0; i < M; ++i) // key값들
			System.out.print("\t" + a[i]);

		System.out.println();
		
		for (int i = 0; i < M; ++i) // key값에 hash함수적용한 값들
			if(a[i] != null) {
				//null값을 연산하려고 하면 안되기 때문에 조건으로 나눠준다
				System.out.print("\t" + hash(a[i]));
			} else {
				System.out.print("\t" + "null ");
			}
		System.out.println();
	}
}
