package infixtopostfixbyStack;

import java.util.Stack;

public class InToPost {
	public static int priority(char op) {
		switch (op) {
		case '+':
			return 1;
		case '-':
			return 1;
		case '*':
			return 2;
		case '/':
			return 2;	
		}
		return -1;
	}

	public static String InfixToPostfix(String Infix) {
		Stack<Character> stack = new Stack<>();
		String Postfix = "";
		
		for(int a = 0; a < Infix.length(); a++) {
			char c = Infix.charAt(a);
			
			if(c == '(') {
				stack.push(c);
			} else if(c == ')') {
				while(stack.peek() != '(') {
					Postfix += stack.pop();
				}
				stack.pop();
			} else if(Character.isLetterOrDigit(c)) { //파라미터의 char 값이 문자 혹은 숫자 인지 여부를 판단하여 true / false로 리턴된다.
				Postfix += c;
			} else {
				while(!stack.isEmpty() && priority(c) <= priority(stack.peek())) {
					Postfix += stack.pop();
				}
				stack.push(c);
			}
			
		}
		
		while(!stack.isEmpty()) {
			Postfix += stack.pop();
		}
		
		return Postfix;
	}
}
