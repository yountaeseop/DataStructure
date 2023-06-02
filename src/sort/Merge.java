package sort;

public class Merge {
	private static void merge(Comparable[] a, Comparable[] b, int low, int mid, int high) {
		int i = low, j = mid + 1;
		for(int k = low; k <= high; k++) { 
//			System.out.println();
//			for(Comparable all : a) {
//				System.out.print(all + " ");
//			}
//			System.out.println();

			if(i > mid) {
				b[k] = a[j++];
			} else if (j > high) {
				b[k] = a[i++];
			} else if (isless(a[j], a[i])) {
				b[k] = a[j++];
			} else {
				b[k] = a[i++];
			}
		}
		
		for(int k = low; k <= high; k++) {
			a[k] = b[k];
		}
	}
	
	private static void sort(Comparable[] a, Comparable[] b, int low, int high) {
		if(high <= low) return;
		int mid = low + (high - low) / 2;
		sort(a, b, low, mid);
		sort(a, b, mid + 1, high);
		merge(a, b, low, mid, high);
	}
	
	public static void sort(Comparable[] a) {
		Comparable[] b = new Comparable[a.length];
		sort(a, b, 0, a.length - 1);
	}
	
	private static boolean isless(Comparable i, Comparable j) { // 키 비교
		return(i.compareTo(j) < 0);
	}
	
	public void testMergeSort(Integer [] data) {
		System.out.println("합병 정렬:");
		double mergeTime = 0;
		long start, end;
		start = System.nanoTime();//currentTimeMillis();
		Merge.sort(data);
		end = System.nanoTime();//.currentTimeMillis();
		mergeTime = (double) (end - start);
		for(int a = 0; a < data.length; a++) {
			System.out.print(data[a] + " ");
		}
		System.out.println("| 정렬 시간 -> " + mergeTime);
		System.out.println();
	}
}
