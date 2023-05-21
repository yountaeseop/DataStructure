package hashTable;

public class Chaining<K, V> {
	public int M = 13;
	public Node[] a = new Node[M];
	public static class Node {
		private Object key;
		private Object data;
		public Node next;
		public Node(Object newkey, Object newdata, Node ref) {
			key = newkey;
			data = newdata;
			next = ref;
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
	
	public V get(K key) {
		int i = hash(key);
		for(Node x = a[i]; x != null; x = x.next) {
			if(key.equals(x.key)) {
				return (V) x.data;
			}
		}
		return null;
	}
	
	public void put(K key, V data) {
		int i = hash(key);
		for(Node x = a[i]; x != null; x = x.next) {
			if(key.equals(x.key)) {
				x.data = data;
				return;
			}
		}
		a[i] = new Node(key, data, a[i]);
	}
	
	
	
}
