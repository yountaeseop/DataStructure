package sort;

public class Heap {
	// 여기서는 값이 클수록 우선순위가 높은 maxheap으로 구성됐다.
	public static void sort(Comparable[] a) {
		int heapSize = a.length-1; // a[0]은 사용 안 함
		for(int i = heapSize/2; i > 0; i--) { // 힙 만들기
			downheap(a, i, heapSize);
		}
		while(heapSize > 1) {	// 힙 정렬
			swap(a, 1, heapSize--); // a[1]과 힙의 마지막 항목과 교환
			downheap(a, 1, heapSize);	//위배된 힙 속성 고치기
		}
	}
	
	private static boolean isless(Comparable i, Comparable j) { // 키 비교
		return(i.compareTo(j) < 0);
	}
	
	private static void swap(Comparable[] a, int i, int j) { // 원소 교환
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static void downheap(Comparable[] a, int p, int heapSize) {
		while(2*p <= heapSize) { // 밑으로 내릴 때, i의 자식 우선순위가 N(힙의 크기)를 넘지 않는 동안
			int s = 2*p; // s = 왼쪽 자식의 인덱스
			if(s < heapSize && isless(a[s], a[s+1])) { // 오른쪽 자식이 큰 경우 
				// maxheap으로 구성, 값이 클수록 우선순위가 높기 때문에 더 큰 값인 s+1로 교체하는 경우이다.
				s++;
			}
			if(!isless(a[p], a[s])) { // 부모가 자식 승자보다 크면 힙 속성 만족
				break;	
			}
			swap(a, p, s);	// 힙 속성 만족 안하면 부모와 자식 승자 교환
			p = s;	// 이제 자식 승자의 자리에 부모가 있게 됨 
		}
	}
	
	public void testHeapSort(Integer [] data) {
		System.out.println("선택 정렬:");
		double heapTime = 0;
		long start, end;
		start = System.nanoTime();//currentTimeMillis();
		Heap.sort(data);
		end = System.nanoTime();//.currentTimeMillis();
		heapTime = (double) (end - start);
		for(int a = 0; a < data.length; a++) {
			System.out.print(data[a] + " ");
		}
		System.out.println("| 정렬 시간 -> " + heapTime);
		System.out.println();
	}
}
