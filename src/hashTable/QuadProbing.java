package hashTable;

public class QuadProbing<K, V> {
	// 이차조사, 선형조사와 근본적으로 동일하다.
	// 선형조사보다 j가 증가할수록 더욱 멀리 떨어진 곳의 empty원소를 조사한다.
	// 선형조사의 군집화 문제를 해결할 수 있다. 하지만 또 다른 형태의 군집화 발생
	private int N = 0; // 항목 수 
	public int M = 13; // 테이블 크기
	public K[] a = (K[]) new Object[M]; // 해시테이블
	private V[] d = (V[]) new Object[M]; // 해시테이블
	
	private int hash(K key) { // 해시코드
		return (key.hashCode() & 0x7fffffff) % M; // 나눗셈 함수
	}
	
	public void put(K key, V data) { // 삽입 연산
		int initialpos = hash(key);  // 초기 위치
		int i = initialpos, j = 1, loop_limit = 20; // 저장 시도 횟수 제한
		
		do { // 최소 한번은 코드 진행
			if(a[i] == null) { // 삽입 위치 발견
				a[i] = key;
				d[i] = data; N++; // key관련 데이터 저장
				return;
			}
			if(a[i].equals(key)) {
				d[i] = data;
			}
			i = (initialpos + j * j++) % M; // i = 다음 위치
			loop_limit -= 1;
		} while (loop_limit > 0); 
	}
	
	public V get(K key) { // 탐색 연산
		int initialpos = hash(key);
		int i = initialpos, j = 1, loop_limit = 20;
		while (a[i] != null & loop_limit > 0) {
			if(a[i].equals(key)) {
				return d[i];
			}
			i = (initialpos + j * j++) % M;
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
