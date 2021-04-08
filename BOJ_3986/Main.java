import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Stack<Character> stack = new Stack<>();
		
		int answer = 0;
		
		for (int i = 0; i < n; ++i) {
			String word = sc.next();
			
			stack.push(word.charAt(0));
			
			for (int j = 1; j < word.length(); ++j) {
				char c = word.charAt(j);
				
				if ((!stack.isEmpty()) && (c == stack.peek())) {
					stack.pop();
				} else {
					stack.push(c);
				}
			}
			
			if (stack.isEmpty()) {
				++answer;
			} else {
				stack.clear();
			}
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
