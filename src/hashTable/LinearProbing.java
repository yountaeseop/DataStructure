package hashTable;

public class LinearProbing<K, V> {
	public int M = 13; // 테이블 크기
	public K[] a = (K[]) new Object[M]; // 해시테이블
	private V[] d = (V[]) new Object[M]; // key관련 데이터 저장
	
	private int hash(K key) { // 해시코드
		return (key.hashCode() & 0x7fffffff) % M; // 나눗셈 함수
		//M자리에는 소수를 사용한다 -> 나눗셈연산을 했을 때, 소수가 키들을 균등하게 인덱스로 변환하기 때문
	}
	
	public void put(K key, V data) { // 삽입 연산
		int initialpos = hash(key);  // 초기 위치
		int i = initialpos, j = 1;
		
		do { // 최소 한번은 코드 진행
			if(a[i] == null) { // 삽입 위치 발견
				a[i] = key;	   // key를 해시 테이블에 저장	
				d[i] = data;   // key관련 데이터를 동일한 인덱스하에 저장
				return;
			}
			if(a[i].equals(key)) { // 이미 key존재
				d[i] = data;	// 데이터만 갱신한다.
				return;
			}
			i = (initialpos + j++) % M; // i = 다음 위치, 0부터 다시 찾아가기 위해서 배열의 길이로 나누는 것이다.
										// 원형리스트 인덱스 찾는 것과 비슷함.
		} while (i != initialpos); // 현재 i가 초기 위치와 같게 되면 루프 종료
								   // 1차원 배열을 한바퀴 돌아야하기 때문에 초기위치와 같게 될때 종료
		
		// 해시값이 충돌할 경우 결국 충돌이 일어난 횟수는 해시값이 같은 것들의 개수와 동일하다 
	}
	
	public V get(K key) { // 탐색 연산
		int initialpos = hash(key);
		int i = initialpos, j = 1;
		while (a[i] != null) {	// a[i]가 empty가 아니면 
			if(a[i].equals(key)) { // 해시테이블의 key와 찾고자하는 key가 같을 경우
				return d[i];	// 탐색 성공
			}
			i = (initialpos + j++) % M;	// i = 다음 위치
		}
		return null;  // 탐색 실패
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
