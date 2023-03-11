package overflow;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Overflow {
	
//	배열에 overflow가 발생하면 배열 크기를 2배로
//	확장한다. 만일 배열의 3/4이 비어 있으면 배열
//	크기를 1/2로 축소한다.
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		String[] list = new String[size];
		
		list[0] = "apple";
		list[1] = "grape";
		list[2] = "orange";
		
		list[size + 1] 
		
		
		
		for (int a = 0; a < list.length; a++) {
			System.out.println(list[a]);
		}

	}

	public void peek() {

	}

	public void insertLast() {

	}

	public void insert() {

	}

	public void resize() {

	}

	public void delete() {

	}

}

class ArrList {
	int size = 6;
	Array[] list = new Array[size];

}