package binaryTree;

public class BinaryTree <E> {
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

	public void levelorder(Node root) {
		// TODO Auto-generated method stub
		
	}
}
