package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree <E> implements Comparable<E>{
	Node<E> root;
	
	public BinaryTree() {this.root = null;}

	public Node<E> getRoot() {return root;}
	
	public void setRoot(Node<E> newRoot) {this.root = newRoot;}
	
	public boolean isEmpty() {return root == null;}

	public int size(Node root) { // root를 루트로 하는 (서브)트리에 있는 노드 수
		if(root == null) {
			return 0;	// null이면 0반환
		} else {
			return(1 + size(root.getLeft()) + size(root.getRight()));
		}
	}

	public int height(Node root) {  // root를 루트로 하는 (서브)트리의 높이
		if(root == null) {
			return 0;	// null이면 0반환
		} else {
			return (1 + Math.max(height(root.getLeft()), height(root.getRight())));
		}
	}

	public void preorder(Node root) {
		if(root == null) {
			return;
		}
		System.out.print(root.getKey()+ " ");
		preorder(root.getLeft());
		preorder(root.getRight());
	}

	public void inorder(Node root) {
		if(root == null) {
			return;
		}
		inorder(root.getLeft());
		System.out.print(root.getKey()+ " ");
		inorder(root.getRight());
		
	}

	public void postorder(Node root) {
		if(root == null) {
			return;
		}
		postorder(root.getLeft());
		postorder(root.getRight());
		System.out.print(root.getKey()+ " ");
		
	}
	
	public void levelorder(Node root) { // 레벨 순회
		Queue<Node> q = new LinkedList<Node>(); // 큐 자료구조 이용
		Node t;
		q.add(root);	// 루트 큐에 삽입
		while(!q.isEmpty()) {
			t = q.remove();	// 큐에서 가장 앞에 있는 노드 제거
			System.out.print(t.getKey()+" "); // 제거된 노드 출력(방문)
			if(t.getLeft() != null) {	//제거된 왼쪽 자식이 null이 아니면
				q.add(t.getLeft());	// 큐에 왼쪽 자식 삽입
			}
			if(t.getRight() != null) {	// 제거된 오른쪽 자식이 null이 아니면
				q.add(t.getRight()); 	// 큐에 오른쪽 자식 삽입
			}
		}
	}

	public static boolean isEqual(Node n, Node m) {  // 두 트리의 동일성 검사
		if(n == null || m == null) {  // 둘중에 하나라도 null이면
			return n == m;	// 둘다 null이면 true, 아니면 false
		}
		
//		if(n.getKey().compareTo(m.getKey()) != 0) {	 // 둘다 null이 아니면 item 비교
//			return false;
//		}
		
		return (isEqual(n.getLeft(), m.getLeft()) &&  // item이 같으면 왼쪽 자식 순환 호출 
				isEqual(n.getRight(), m.getRight()));  //  오른쪽 자식 순환 호출
	}

	@Override
	public int compareTo(E o) {
		
		return 0;
	}
	
	
	
}
