package infixtopostfixbyStack;

public class Main {
	public static void main(String[] args) {
		
		String s = "a+b*c-(d*e+f)*g";
		
		System.out.println(InToPost.InfixToPostfix(s));
	}
}
