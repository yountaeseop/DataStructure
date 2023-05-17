package AVLTree;

import binarySearchTree.Node;

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
		return x;	// 회전 후 x가 n의 이전 자리로 이동되었으므로
	}
	
	private Node rotateLeft(Node n) {
		Node x = n.right;
		n.right = x.left;
		x.left = n;
		n.height = tallerHeight(height(n.left), height(n.right)) + 1;
		x.height = tallerHeight(height(x.left), height(x.right)) + 1;
		return x;	// 회전 후 x가 n의 이전 자리로 이동되었으므로
	}
	
	public void put(Key k, Value v) {
		root = put(root, k, v);
	}
	private Node put(Node n, Key k, Value v) {
		if(n == null) {
			return new Node(k, v, 1);
		}
		int t = k.compareTo(n.id);
		if(t < 0) {
			n.left = put(n.left, k, v);
		} else if(t > 0) {
			n.right = put(n.right, k, v);
		} else {
			n.name = v;  // k가 이미 트리에 있으므로 Value v만 갱신
			return n;
		}
		n.height = tallerHeight(height(n.left), height(n.right))+1;
		return balance(n); // 노드 n의 균형 점검 및 불균형을 바로 잡음
	}
	
	private Node balance(Node n) {
		if(bf(n) > 1) {
			if(bf(n.left) < 0) {
				n.left = rotateLeft(n.left);
			}
			n = rotateRight(n);
		}
		else if(bf(n) < -1) {
			if(bf(n.right) > 0) {
				n.right = rotateRight(n.right);
			}
			n = rotateLeft(n);
		}
		return n;
	}
	
	private int bf(Node n) {
		return height(n.left) - height(n.right);
	}
	
	private int height(Node n) {
		if(n == null) {
			return 0;
		}
		return n.height;
	}
	
	private int tallerHeight(int x, int y) {
		if(x > y) {
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
		if(n != null) {
			inorder(n.left);
			System.out.print(n.id+" ");
			inorder(n.right);
		}
	}
}
