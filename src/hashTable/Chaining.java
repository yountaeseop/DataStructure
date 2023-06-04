package hashTable;

public class Chaining<K, V> {
	// 폐쇄주소방식으로 해시값에 대응되는 곳에만 키를 저장한다.
	// LinkedList처럼 노드를 두고 노드에 다음 노드를 저장해서 검색
	public int M = 13;
	public Node[] a = new Node[M];
	public static class Node {
		private Object key;
		private Object data;
		public Node next;
		public Node(Object newkey, Object newdata, Node nextNode) {
			key = newkey;
			data = newdata;
			next = nextNode;
		}
		public Object getKey() {
			return key;
		}
		public Object getData() {
			return data;
		}
	}
	
	private int hash(K key) { // 해시 코드
		return (key.hashCode() & 0x7fffffff) % M; 
	}
	
	public V get(K key) { // 탐색 연산
		int i = hash(key);
		for(Node x = a[i]; x != null; x = x.next) {
			if(key.equals(x.key)) {
				return (V) x.data;
			}
		}
		return null;
	}
	
	public void put(K key, V data) { // 삽입 연산
		int i = hash(key);
		for(Node x = a[i]; x != null; x = x.next) {
			if(key.equals(x.key)) { // 이미 key존재
				x.data = data; // 데이터만 갱신
				return;
			}
		}
		a[i] = new Node(key, data, a[i]); // 연결 리스트의 첫 노드로 삽입
		// a[i] 노드의 다음 노드가 a[i]인 것이다.
	}
}
