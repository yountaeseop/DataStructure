package hashTable;

public class DoubleHashing<K, V> {
	private int N = 0;
	public int M = 13; // 테이블 크기
	public K[] a = (K[]) new Object[M]; // 해시테이블
	private V[] dt = (V[]) new Object[M]; // 해시테이블
	
	private int hash(K key) { // 해시코드
		return (key.hashCode() & 0x7fffffff) % M; // 나눗셈 함수
	}
	
	public void put(K key, V data) { // 삽입 연산
		int initialpos = hash(key);  // 초기 위치
		int i = initialpos, loop_limit = 20;
		int j = 1;
		int d =(7-(int)key % 7);
		
		do { // 최소 한번은 코드 진행
			if(a[i] == null) { // 삽입 위치 발견
				a[i] = key;
				dt[i] = data; N++;
				return;
			}
			if(a[i].equals(key)) {
				dt[i] = data;
				return;
			}
			i = (initialpos + j*d) % M; // i = 다음 위치
			j++;
			loop_limit -= 1;
		} while (loop_limit > 0); // 현재 i가 초기 위치와 같게 되면 루프 종료
	}
	
	public V get(K key) { // 탐색 연산
		int initialpos = hash(key);
		int i = initialpos, loop_limit = 20;
		int j = 1;
		int d = (7 - (int)key % 7);
		while (a[i] != null & loop_limit > 0) {
			if(a[i].equals(key)) {
				return dt[i];
			}
			i = (initialpos + j*d) % M;
			j++;
			loop_limit -= 1;
		}
		return null;
	}
	
	
}
