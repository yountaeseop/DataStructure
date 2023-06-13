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
		int i = initialpos, loop_limit = 20; // 저장 시도 횟수 제한
		
		// 선형조사와 이차조사의 규칙적인 점프 시퀀스와 달리 
		// 점프 시퀀스를 Random으로 무작위화하여 empty원소를 찾음 
		Random rand = new Random();
		rand.setSeed(10); // 랜덤 초기값을 10으로 설정
		// *동일한 시드를 사용하면 동일한 순서의 난수를 얻을 수 있음
		
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
			// rand.nextInt(1000); -> 0부터 999까지의 값을 무작위로 반환
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
