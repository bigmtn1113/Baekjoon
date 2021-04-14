import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String expression = sc.next();
		
		int[] array = new int[n];
		
		for (int i = 0; i < n; ++i) {
			array[i] = sc.nextInt();
		}
		
		sc.close();
		
		Stack<Double> stack = new Stack<>();
		
		for (int i = 0; i < expression.length(); ++i) {
			char c = expression.charAt(i);
			
			switch (c) {
			case '*':
				stack.push(stack.pop() * stack.pop());
				break;
				
			case '/':
				double num1 = stack.pop();
				double num2 = stack.pop();
				
				stack.push(num2 / num1);
				break;
				
			case '+':
				stack.push(stack.pop() + stack.pop());
				break;
				
			case '-':
				stack.push(-(stack.pop() - stack.pop()));
				break;

			default:
				stack.push((double) array[c - 'A']);
				break;
			}
		}
		
		System.out.format("%.2f", stack.pop());
	}

}
