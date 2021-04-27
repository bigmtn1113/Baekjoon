import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	public static void end() {
		System.out.print(0);
		System.exit(0);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String inputStr = sc.next();
		
		sc.close();
		
		Stack<String> stack = new Stack<>();
		Stack<String> tempStack = new Stack<>();
		
		for (int i = 0; i < inputStr.length(); ++i) {
			char c = inputStr.charAt(i);
			
			int num = 0;
			
			switch (c) {
			case '(':
			case '[':
				stack.push(String.valueOf(c));
				tempStack.push(String.valueOf(c));
				break;
				
			case ')':
				if (tempStack.isEmpty() || !tempStack.peek().equals("(")) {
					end();
				}
				
				while (stack.peek().chars().allMatch(Character::isDigit)) {
					num += Integer.parseInt(stack.pop());
				}
				
				stack.pop();
				tempStack.pop();
				
				stack.push((num == 0) ? "2" : String.valueOf(num * 2));
				break;
				
			default:
				if (tempStack.isEmpty() || !tempStack.peek().equals("[")) {
					end();
				}
				
				while (stack.peek().chars().allMatch(Character::isDigit)) {
					num += Integer.parseInt(stack.pop());
				}
				
				stack.pop();
				tempStack.pop();
				
				stack.push((num == 0) ? "3" : String.valueOf(num * 3));
				break;
			}
		}
		
		if (!tempStack.isEmpty()) {
			end();
		}
		
		int answer = 0;
		
		while (!stack.isEmpty()) {
			answer += Integer.parseInt(stack.pop());
		}
		
		System.out.print(answer);
	}

}
