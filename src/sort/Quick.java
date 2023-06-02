package sort;

public class Quick {
	
	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int low, int high) {
		if(high <= low) {
			return;
		}
		int j = partition(a, low, high);
		sort(a, low, j-1);	
		sort(a, j+1, high);	 
	}
	
	private static int partition(Comparable[] a, int pivot, int high) {
		int i = pivot;
		int j = high + 1;
		Comparable p = a[pivot];
		
		while(true) {
			while(isless(a[++i], p)) {
				if(i == high) {
					break;
				}
			}
			while(isless(p, a[--j])) {
				if(j == pivot) {
					break;
				}
			}
			if(i >= j) {
				break;
			}
			swap(a, i, j);
		}
		swap(a, pivot, j); 
		return j;
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
