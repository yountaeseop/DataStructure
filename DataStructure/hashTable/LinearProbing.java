package hashTable;

public class LinearProbing<K, V> {
	public int M = 13; // 테이블 크기
	public K[] a = (K[]) new Object[M]; // 해시테이블
	private V[] d = (V[]) new Object[M]; // 해시테이블
	
	private int hash(K key) { // 해시코드
		return (key.hashCode() & 0x7fffffff) % M; // 나눗셈 함수
	}
	
	public void put(K key, V data) { // 삽입 연산
		int initialpos = hash(key);  // 초기 위치
		int i = initialpos, j = 1;
		
		do { // 최소 한번은 코드 진행
			if(a[i] == null) { // 삽입 위치 발견
				a[i] = key;
				d[i] = data;
				return;
			}
			if(a[i].equals(key)) {
				d[i] = data;
				return;
			}
			i = (initialpos + j++) % M; // i = 다음 위치
		} while (i != initialpos); // 현재 i가 초기 위치와 같게 되면 루프 종료
	}
	
	public V get(K key) { // 탐색 연산
		int initialpos = hash(key);
		int i = initialpos, j = 1;
		while (a[i] != null) {
			if(a[i].equals(key)) {
				return d[i];
			}
			i = (initialpos + j++) % M;
		}
		return null;
	}
	
	
}
