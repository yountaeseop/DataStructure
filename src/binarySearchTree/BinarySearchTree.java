package binarySearchTree;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
	public Node root;

	public BinarySearchTree(Key newId, Value newName) {
		this.root = new Node(newId, newName);
	}
	
	public Node getRoot() {
		return root;
	}

	// get, put, min, deleteMin, delete
	// 메소드들 선언

	public Value get(Key k) {
		return get(root, k);
	}

	public Value get(Node n, Key k) {
		if (n == null)
			return null;
		int t = n.getKey().compareTo(k);
		if (t > 0)
			return get(n.getLeft(), k); // if(k < 노드 n의 id) 왼쪽 서브트리 탐색
		else if (t < 0)
			return get(n.getRight(), k); // if(k > 노드 n의 id) 오른쪽 서브트리 탐색
		else
			return (Value) n.getValue(); // k를 가진 노드 발견
	}

	public void put(Key k, Value v) {
		root = put(root, k, v);
	}

	public Node put(Node n, Key k, Value v) { // n은 BST가 처음 생성될 때 만들어진 root노드
		if (n == null) // 삽입할 공간을 찾은 경우
			return new Node(k, v); // 삽입할 key와 value로 Node를 만들어 트리에 붙여준다.
		int t = n.getKey().compareTo(k);
		if (t > 0)
			n.setLeft(put(n.getLeft(), k, v)); // if(k < 노드 n의 id) 왼쪽 서브트리 탐색
		else if (t < 0)
			n.setRight(put(n.getRight(), k, v)); // if(k > 노드 n의 id) 오른쪽 서브트리 탐색
		else // key값이 같은 경우
			n.setValue(v); // 노드 n의 name을 v로 갱신
		return n;
	}
	// 재연결하는 부분이 잘 이해가 안된다.

	public Key min() { 
		if (root == null) {
			return null;
		}
		return (Key) min(root).getKey();
	}
	private Node min(Node n) {
		if(n.getLeft() == null) {
			return n;
		}
		return min(n.getLeft());
	}
	
	public void deleteMin() {
		if(root == null) {
			System.out.println("empty 트리");
		}
		root = deleteMin(root);
	}
	public Node deleteMin(Node n) {
		if(n.getLeft() == null) {
			return n.getRight();
		}
		n.setLeft(deleteMin(n.getLeft()));
		return n;
	}
	
	public void delete(Key k) {
		root = delete(root, k);
	}
	public Node delete(Node n, Key k) {
		// 삭제할 노드 발견시 삭제할 노드의 자식노드가 몇개인지에 따라 3가지case로 분류
		if(n == null) { // 자식노드가 없는경우
			return null;
		}
		int t = n.getKey().compareTo(k);
		if(t > 0) {
			n.setLeft(delete(n.getLeft(), k));
		}
		else if(t < 0) {
			n.setRight(delete(n.getRight(), k));
		}
		else { 
			if(n.getRight() == null) { // 오른쪽 자식노드가 없는 경우
				return n.getLeft();
			}
			if(n.getLeft() == null) { // 왼쪽 자식노드가 없는 경우
				return n.getRight();
			}
			// 왼쪽, 오른쪽 자식 노드가 모두 존재할 경우
			Node target = n;
			n = min(target.getRight());
			n.setRight(deleteMin(target.getRight()));
			//오른쪽 서브트리중 가장 작은 값의 노드를 찾아야한다. 
			//왼쪽 서브트리에서 찾는건 최소값이고 타겟의 자리를 구조상 대신해줄수 없음.
			n.setLeft(target.getLeft());
		}
		return n;
	}
	
	public void print(Node root) {
		System.out.printf("\ninorder:\n");
		inorder(root);
	}
	
	public void inorder(Node n) {
		if(n != null) {
			inorder(n.getLeft());
			System.out.print(n.getKey()+" ");
			inorder(n.getRight());
		}
	}
}
