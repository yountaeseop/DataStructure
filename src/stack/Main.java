package stack;

public class Main {

	public static void main(String[] args) {
		ArrayStack<String> stack = new ArrayStack<>();
		
		// stack.peek();
		stack.push("apple");
		stack.push("orange");
		stack.push("cherry");
		System.out.println(stack.peek());
		stack.push("pear");
		stack.print();
		stack.pop();
		System.out.println(stack.peek());
		stack.push("grape");
		stack.print();
	}

}
