package sort;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Selection selectionSort = new Selection();
		selectionSort.testSelectionSort(generateRandomData(20));
		
		Insertion insertionSort = new Insertion();
		insertionSort.testInsertionSort(generateRandomData(20));
		
		Merge mergeSort = new Merge();
		mergeSort.testMergeSort(generateRandomData(20));
		
		Quick quickSort = new Quick();
		quickSort.testQuickSort(generateRandomData(20));
		
		Heap heapSort = new Heap();
		heapSort.testHeapSort(generateRandomData(20));
		
		Shell shellSort = new Shell();
		shellSort.testShellSort(generateRandomData(20));
	}
	
	// 난수 생성기
	public static Integer[] generateRandomData(int size) {
		Random random = new Random();

		Integer[] dataArray = new Integer[size];

		dataArray[0] = -1;

		int dataSize = size;

		for(int i = 1; i < size; i++)
			dataArray[i] = random.nextInt(size);
		return dataArray;
	}
}
