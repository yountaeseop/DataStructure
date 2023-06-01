package priorityQueue;

public class Entry <Key extends Comparable<Key>, Value> {
	private Key key;
	private Value value;
	
	public Entry(Key newKey, Value newValue) {  // 생성자
		key = newKey;
		value = newValue;
	}
	// get, set 메소드들
	public Key getKey() {
		return key;
	}
	public void setKey(Key newKey) {
		this.key = newKey;
	}
	public Value getValue() {
		return value;
	}
	public void setValue(Value newValue) {
		this.value = newValue;
	}
}
