package sort;

public class Quick {
	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int low, int high) {
		// https://st-lab.tistory.com/250
		// 퀵소트 왼쪽 피벗 순환 이해 링크
		if(high <= low) return;
		int j = partition(a, low, high);
		sort(a, low, j-1);	// 피벗보다 작은 부분 순환 호출
		sort(a, j+1, high);	// 피벗보다 큰 부분 순환 호출
	}
	
	private static int partition(Comparable[] a, int pivot, int high) {
		// 배열 a의 0번째 인덱스를 pivot으로 설정
		// high부분에서 내려오는 연산을 하기위해 j에 +1을 하고 시작한다.
		int i = pivot;
		int j = high + 1;
		Comparable p = a[pivot];
		
		while(true) {
			while(isless(a[++i], p)) if(i == high) break; // 피벗보다 작으면
			while(isless(p, a[--j])) if(j == pivot) break; // 피벗보다 크면
			if(i >= j) break;	// i와 j가 교차되면 루프 나가기
			swap(a, i, j);
		}
		swap(a, pivot, j);	// 피벗과 a[j] 교환 
		return j;	// a[j]의 피벗이 "영원히" 자리 잡은 곳
	}
	
	private static boolean isless(Comparable i, Comparable j) { // 키 비교
		return(i.compareTo(j) < 0);
	}
	
	private static void swap(Comparable[] a, int i, int j) { // 원소 교환
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public void testQuickSort(Integer [] data) {
		System.out.println("퀵 정렬:");
		double quickTime = 0;
		long start, end;
		start = System.nanoTime();//currentTimeMillis();
		Quick.sort(data);
		end = System.nanoTime();//.currentTimeMillis();
		quickTime = (double) (end - start);
		for(int a = 0; a < data.length; a++) {
			System.out.print(data[a] + " ");
		}
		System.out.println("| 정렬 시간 -> " + quickTime);
		System.out.println();
	}
}
