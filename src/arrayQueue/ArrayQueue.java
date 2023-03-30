package arrayQueue;

import java.util.NoSuchElementException;

public class ArrayQueue<E> {
	// 조건 1. 배열을 원형으로 구성한다.(배열 오른쪽 편중문제 해결)
	// 조건 2. front를 실제의 가장 앞에 있는 item의 바로 앞의
	// 비어있는 원소를 가리키게 한다.(마지막 원소를 삭제했을 때,
	// rear뒤로 넘어가는 현상방지.)

	private E[] q; // 큐를 위한 배열
	private int front, rear, size;

	public ArrayQueue() { // 큐 생성자
		q = (E[]) new Object[2]; // 초기에 크기가 2인 배열 생성2
		front = rear = size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() { // 큐가 비어있으면 true리턴
		return size == 0;
	}

	public void add(E newValue) { // 큐 삽입 연산
		// 큐의 편중문제를 고려해서 배열의 순서가 원형으로 돌아갈 수 있도록 구현한다
		// * 꼬리번호 계산식을 적용해서!!!

		if ((rear + 1) % q.length == front) { // 비어있는 원소가 1개뿐인 경우
			// 꼬리번호 계산식 적용.
			resize(2 * q.length); // 큐의 크기를 2배 확장
		}
		rear = (rear + 1) % q.length;
		// new_rear = (old_rear + 1) % N
		q[rear] = newValue; // 새 항목을 add
		size++;
	}

	public E remove() { // 큐 삭제 연산
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		front = (front + 1) % q.length;
		E item = q[front];
		q[front] = null; // null로 만들어 가비지 컬렉션 되도록
		// 위의 꼬리번호 계산식을 통해서 새로운 front인덱스를 구하고 그자리에
		// 저장돼있는 값을 null로 만드는게 remove의 핵심이다.
		size--;
		if (size > 0 && size == q.length / 4) { // 큐의 항목수가 배열 크기의 1/4이 되면
			resize(q.length / 2); // 큐를 1/2 크기로 축소
		}
		return item;
		// remove된 값을 보고 싶을 수가 있기때문에 삭제할 요소를
		// 미리저장하고 반환할 수 있도록한다.
	}

	private void resize(int newSize) { // 큐의 배열 크기 조절
		Object[] t = new Object[newSize]; // newSize 크기의 새로운 배열 t 생성
		for (int a = 1, j = front + 1; a < size + 1; a++, j++) {
			// front한칸 비우는거니까 a가 1부터 시작하는 것이다.
			t[a] = q[j % q.length]; // 배열 q의 항목들을 배열 t[1]로부터 복사
		}

		front = 0;
		rear = size;
		q = (E[]) t; // 배열 t를 배열 q로
	}

	public void print() {
		if (isEmpty()) {
			System.out.println("큐가 비어있음.");
		} else {
			for (int a = 0; a < q.length; a++) {
				System.out.print(q[a] + " ");
			}
		}
		System.out.println();
	}
}
