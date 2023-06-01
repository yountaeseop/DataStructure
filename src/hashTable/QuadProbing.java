package hashTable;

public class QuadProbing<K, V> {
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
}
