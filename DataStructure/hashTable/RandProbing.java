package hashTable;

import java.util.Random;

public class RandProbing<K, V> {
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
		Random rand = new Random();
		rand.setSeed(10);
		
		do { 
			if(a[i] == null) { 
				a[i] = key;
				d[i] = data; N++;
				return;
			}
			if(a[i].equals(key)) {
				d[i] = data;
				return;
			}
			i = (initialpos + rand.nextInt(1000)) % M; // i = 다음 위치
			loop_limit -= 1;
		} while (loop_limit > 0); // 현재 i가 초기 위치와 같게 되면 루프 종료
	}
	
	public V get(K key) { // 탐색 연산
		Random rand = new Random();
		rand.setSeed(10);
		int initialpos = hash(key);
		int i = initialpos, loop_limit = 20;
		while (a[i] != null & loop_limit > 0) {
			if(a[i].equals(key)) {
				return d[i];
			}
			i = (initialpos + rand.nextInt(1000)) % M;
			loop_limit -= 1;
		}
		return null;
	}
}
