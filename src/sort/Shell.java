package sort;

public class Shell {
	public static void sort(Comparable[] a) {
		int N = a.length;
		int h = 4;	// 3x+1 간격: 1, 4, 13, 40, 121, ... 중에서 4와 1만 사용
		while(h >= 1) {
			for(int i = h; i < N; i++) {	// h-정렬 수행
				for(int j = i; j >= h && isless(a[j], a[j-h]); j -= h) {
					swap(a, j, j-h);
				}
			}
			h /= 3;
		}
	}
	
	// isLess(), swap() 메소드 선언, Selection 클래스와 동일함
	private static boolean isless(Comparable i, Comparable j) { // 키 비교
		return(i.compareTo(j) < 0);
	}
	
	private static void swap(Comparable[] a, int i, int j) { // 원소 교환
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public void testShellSort(Integer [] data) {
		System.out.println("쉘 정렬:");
		double shellTime = 0;
		long start, end;
		start = System.nanoTime();//currentTimeMillis();
		Shell.sort(data);
		end = System.nanoTime();//.currentTimeMillis();
		shellTime = (double) (end - start);
		for(int a = 0; a < data.length; a++) {
			System.out.print(data[a] + " ");
		}
		System.out.println("| 정렬 시간 -> " + shellTime);
		System.out.println();
	}
}
