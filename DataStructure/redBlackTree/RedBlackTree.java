package redBlackTree;

public class RedBlackTree<Key extends Comparable<Key>, Value> {
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	private Node root;
	
	private class Node { // Node 클래스
	    Key id;
		Value name;
		Node left, right;
		boolean color; // 부모 link의 색
		
		public Node(Key k, Value v, boolean col) { // 노드 생성자
			id = k;
			name = v;
			color = col;
			left = right = null;
		}
	}
	
	private boolean isEmpty() {
		return root == null;
	}
	
	private boolean isRed(Node n) {
		if(n == null) {
			return false;	// null의 색은 블랙
		}
		return (n.color == RED);
	}
	
	public Value get(Key k) {	// 탐색 연산
		return get(root, k);
	}
	
	public Value get(Node n, Key k) {	
		if(n == null) {
			return null;	// 탐색 실패
		}
		int t = n.id.compareTo(k);
		if(t > 0) {	// if (k < 노드 n의 id) 왼쪽 서브트리 탐색
			return get(n.left, k);
		} else if(t < 0) {	// if(k > 노드 n의 id) 오른쪽 서브트리 탐색
			return get(n.right, k);
		} else {  // 탐색 성공
			return (Value) n.name;  // 탐색 성공
		}
	}
	
	private Node rotateLeft(Node n) {
		Node x = n.right;
		n.right = x.left;
		x.left = n;
		x.color = n.color;
		n.color = RED;
		return x;
	}
	
	private Node rotateRight(Node n) {
		Node x = n.left;
		n.left = x.right;
		x.right = n;
		x.color = n.color;
		n.color = RED;
		return x;
	}
	
	private void flipColors(Node n) {
		n.color = !n.color;
		n.left.color = !n.left.color;
		n.right.color = !n.right.color;
	}
	
	public void put(Key k, Value v) {
		root = put(root, k, v);
		root.color = BLACK;
	}
	private Node put(Node n, Key k, Value v) {
		if(n == null) {
			return new Node(k, v, RED);	// 새로운 레드노드 생성
		}
		int t = k.compareTo(n.id);
		if(t < 0) {
			n.left = put(n.left, k, v);
		} else if(t > 0) {
			n.right = put(n.right, k, v);
		} else {
			n.name = v;	//k가 트리에 있는 경우 v로 name을 갱신
		}
		// 오른쪽 link가 레드인 경우 바로잡는다.
		if(!isRed(n.left) && isRed(n.right)) n = rotateLeft(n);
		if(isRed(n.left) && isRed(n.left.left)) n = rotateRight(n);
		if(isRed(n.left) && isRed(n.right)) flipColors(n);
		return n;
	}
	
	private Node moveRedLeft(Node n) {
		flipColors(n);	// case1 과 case2
		if(isRed(n.right.left)) {	// case 2
			n.right = rotateRight(n.right);
			n = rotateLeft(n);
			flipColors(n);
		}
		return n;
	}
	
	public void deleteMin() { // 최솟값 삭제
		root = deleteMin(root);
		root.color = BLACK;
	}
	
	private Node deleteMin(Node n) {
		if(n.left == null) {
			return null;
		}
		if(!isRed(n.left) && !isRed(n.left.left)) {
			n = moveRedLeft(n);
		}
		n.left = deleteMin(n.left);
		return fixUp(n);
	}
	
	private Node fixUp(Node n) {
		if(isRed(n.right)) n = rotateLeft(n);
		if(isRed(n.left) && isRed(n.left.left)) n = rotateLeft(n);
		if(isRed(n.left) && isRed(n.right)) flipColors(n);
		return n;
	}
	
	public void inorder(Node n) {
		if(n != null) {
			inorder(n.left);
			System.out.print(n.id+" ");
			inorder(n.right);
		}
	}
	
	public void print() {
		System.out.printf("\ninorder:\n");
		inorder(root);
	}
	
}
