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

	public Node put(Node n, Key k, Value v) {
		if (n == null)
			return new Node(k, v);
		int t = n.getKey().compareTo(k);
		if (t > 0)
			n.setLeft(put(n.getLeft(), k, v)); // if(k < 노드 n의 id) 왼쪽 서브트리 탐색
		else if (t < 0)
			n.setRight(put(n.getRight(), k, v)); // if(k > 노드 n의 id) 오른쪽 서브트리 탐색
		else
			n.setValue(v); // 노드 n의 name을 v로 갱신
		return n;
	}

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
		if(n == null) {
			return null;
		}
		int t = n.getKey().compareTo(k);
		if(t > 0) {
			n.setLeft(delete(n.getLeft(), k));
		}
		else if(t < 0) {
			n.setRight(delete(n.getRight(), k));
		}
		else { // 삭제할 노드 발견
			if(n.getRight() == null) {
				return n.getLeft();
			}
			if(n.getLeft() == null) {
				return n.getRight();
			}
			Node target = n;
			n = min(target.getRight());
			n.setRight(deleteMin(target.getRight()));
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
