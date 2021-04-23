import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int p = sc.nextInt();		// 이건 쓸모가 없네..
		
		Stack<Integer>[] stackArray = new Stack[7];
		
		for (int i = 0; i < 7; ++i) {
			stackArray[i] = new Stack<>();
		}
		
		int answer = 0;
		
		for (int i = 0; i < n; ++i) {
			int guitarString = sc.nextInt();
			int fret = sc.nextInt();
			
			while (!stackArray[guitarString].isEmpty()) {
				if (stackArray[guitarString].peek() <= fret) {
					break;
				}
				
				stackArray[guitarString].pop();
				++answer;
			}
			
			if (stackArray[guitarString].isEmpty() || (stackArray[guitarString].peek() != fret)) {
				stackArray[guitarString].push(fret);
				++answer;
			}
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
