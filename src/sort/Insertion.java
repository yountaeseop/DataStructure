package sort;

public class Insertion {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for(int i = 1; i < N; i++){  
 			for(int j = i; j > 0; j--) {
				if(isless(a[j], a[j-1])) {
					swap(a, j, j-1);
				}else break;
			}
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
	
	public void testInsertionSort(Integer [] data) {
		System.out.println("삽입 정렬:");
		double insertTime = 0;
		long start, end;
		start = System.nanoTime();//currentTimeMillis();
		Insertion.sort(data);
		end = System.nanoTime();//.currentTimeMillis();
		insertTime = (double) (end - start);
		for(int a = 0; a < data.length; a++) {
			System.out.print(data[a] + " ");
		}
		System.out.println("| 정렬 시간 -> " + insertTime);
		System.out.println();
	}
}
