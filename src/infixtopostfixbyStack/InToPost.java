package infixtopostfixbyStack;

import java.util.Stack;

public class InToPost {
	// 일단 우선순위 함수가 있다.
	// *, /가 우선순위가 더 높기 때문에 더 높은 숫자를 반환하도록 한다.
	
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
		// 핵심 아이디어 => 왼쪽 괄호나 연산자는 스택에 push하고, 피연산자는 출력한다.
		
		Stack<Character> stack = new Stack<>(); // 스택선언
		String Postfix = "";
		
		for(int a = 0; a < Infix.length(); a++) {
			char c = Infix.charAt(a); // infix문자 하나씩 추출
			
			if(c == '(') {
				stack.push(c);
			} else if(c == ')') {
				while(stack.peek() != '(') {
					Postfix += stack.pop();
				}
				stack.pop();
			} else if(Character.isLetterOrDigit(c)) { //파라미터의 char 값이 문자 혹은 숫자 인지 여부를 판단하여 true / false로 리턴된다.
				Postfix += c;
			} else { // 이 부분이 연산자인 경우를 나타낸다.
					 // 자신의 우선순위보다 낮은 연산자가 스택top에 나타날 때까지 pop하여 출력하고 
					 // 읽은 연산자를 push.
				while(!stack.isEmpty() && priority(c) <= priority(stack.peek())) {
					//stack.peek()에 유의하자 현재 top과 지금 넣은 연산자의 우선순위를 비교하는 것이다.
					Postfix += stack.pop();
				}
				stack.push(c);
			}
			
		}
		
		while(!stack.isEmpty()) {
			// infix길이만큼 다 돌리면 stack에 남아있는 것들을 전부 
			// pop해서 postfix에 더한다.
			Postfix += stack.pop();
		}
		
		return Postfix;
	}
}
