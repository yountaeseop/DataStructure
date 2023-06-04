package hashTable;

import hashTable.Chaining.Node;

public class Main {

	public static void main(String[] args) {
		LinearProbing lp = new LinearProbing();
		// QuadProbing lp = new QuadProbing();
		// RandProbing lp = new RandProbing();
		// DoubleHashing lp = new DoubleHashing();

		// 25, 37, 18, 55, 22, 35, 50, 63을 차례로 해시 테이블에 저장
		lp.put(25, "grape");
		lp.put(37, "apple");
		lp.put(18, "bananna");

		lp.put(55, "cherry");
		lp.put(22, "mango");
		lp.put(35, "lime");

		lp.put(50, "orange");
		lp.put(63, "watermelon");

		System.out.println("탐색 결과:");

		System.out.println("50의 data = " + lp.get(50));

		System.out.println("63의 data = " + lp.get(63));

		System.out.println();

		lp.print();

		Chaining c = new Chaining();

		// 25, 37, 18, 55, 22, 35, 50, 63을 차례로 테이블에 저장
		c.put(25, "grape");
		c.put(37, "apple");
		c.put(18, "bananna");
		c.put(55, "cherry");
		c.put(22, "mango");
		c.put(35, "lime");
		c.put(50, "orange");
		c.put(63, "watermelon");
		
		System.out.println();
		System.out.println("탐색 결과");
		System.out.println("50의 data = " + c.get(50));
		System.out.println("63의 data = " + c.get(63));
		System.out.println("37의 data = " + c.get(37));
		System.out.println("22의 data = " + c.get(22));

//		c.put(71, "grape");
//		c.put(23, "apple");
//		c.put(73, "bananna");
//		c.put(49, "cherry");
//		c.put(54, "mango");
//		c.put(89, "lime");
//		c.put(39, "orange");
		System.out.println();
		System.out.println("해시 테이블");
		for (int i = 0; i < c.M; ++i) {
			System.out.print(String.format("%2d", i));
			Node x = c.a[i];
			while (x != null) {
				System.out.print("-->[" + x.getKey() + ", " + x.getData() + "]");
				x = x.next;
			}
			System.out.println();
		}
	}
}
