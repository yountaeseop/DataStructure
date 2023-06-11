package AVLTree;

// AVL은 Adelson-Velsky와 Landis의 이름에서 따온 것으로, 
// AVL 트리라고도 알려진 자가 균형 이진 검색 트리입니다. 
public class AVL<Key extends Comparable<Key>, Value> {
	public Node root;

	public class Node {
		private Key id;
		private Value name;
		private int height;
		private Node left, right;

		public Node(Key newID, Value newName, int newHt) {
			id = newID;
			name = newName;
			height = newHt;
			left = right = null;
		}
	}

	private Node rotateRight(Node n) {
		Node x = n.left;
		n.left = x.right;
		x.right = n;
		n.height = tallerHeight(height(n.left), height(n.right)) + 1;
		x.height = tallerHeight(height(x.left), height(x.right)) + 1;
		return x; // 회전 후 x가 n의 이전 자리로 이동되었으므로
	}

	private Node rotateLeft(Node n) {
		Node x = n.right;
		n.right = x.left;
		x.left = n;
		n.height = tallerHeight(height(n.left), height(n.right)) + 1;
		x.height = tallerHeight(height(x.left), height(x.right)) + 1;
		return x; // 회전 후 x가 n의 이전 자리로 이동되었으므로
	}

	public void put(Key k, Value v) {root = put(root, k, v);} // 삽입 연산
	private Node put(Node n, Key k, Value v) {
		if (n == null) {	//초기 노드 없는 경우 새로운 노드를 만들고 높이 1로 지정 
			return new Node(k, v, 1);
		}
		int t = k.compareTo(n.id);
		if (t < 0) n.left = put(n.left, k, v);
		else if (t > 0) n.right = put(n.right, k, v);
		else {
			n.name = v; // k가 이미 트리에 있으므로 Value v만 갱신
			return n;
		}
		n.height = tallerHeight(height(n.left), height(n.right)) + 1;
		// 리프노드부터 부모노드까지 올라가기때문에 제일 높은 노드에서 +1을 해줘야함.
		return balance(n); // 노드 n의 균형 점검 및 불균형을 바로 잡음
	}

	private Node balance(Node n) { //불균형 처리
		if (bf(n) > 1) { // 노드 n의 왼쪽 서브트리가 높아서 불균형 발생
			if (bf(n.left) < 0) { // 노드 n의 왼쪽자식노드의 오른쪽 서브트리가 높은 경우
				n.left = rotateLeft(n.left); // LR - 회전
			}
			n = rotateRight(n); // LL - 회전
		} else if (bf(n) < -1) { // 노드 n의 오른쪽 서브트리가 높아서 불균형 발생
			if (bf(n.right) > 0) { // 노드 n의 오른쪽자식노드의 왼쪽 서브트리가 높은 경우
				n.right = rotateRight(n.right); // RL - 회전
			}
			n = rotateLeft(n); // RR - 회전
		}
		return n;
	}

	// Balance Factor 균형요인
	private int bf(Node n) { // bf = 왼쪽 서브트리 높이 - 오른쪽 서브트리 높이
		return height(n.left) - height(n.right);
	}

	private int height(Node n) { // 높이 계산
		if (n == null) {
			return 0;
		}
		return n.height;
	}

	//
	private int tallerHeight(int x, int y) { // 높이 비교
		if (x > y) {
			return x;
		} else {
			return y;
		}
	}

	public void print(Node root) {
		System.out.printf("\ninorder:\n");
		inorder(root);
	}

	public void inorder(Node n) {
		if (n != null) {
			inorder(n.left);
			System.out.print(n.id + " ");
			inorder(n.right);
		}
	}
}
