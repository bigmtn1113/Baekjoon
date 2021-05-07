import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		int t = sc.nextInt();
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		for (int i = 0; i < t; ++i) {
			int n = sc.nextInt();
			
			int[] logHeightArray = new int[n];
			
			for (int j = 0; j < n; ++j) {
				logHeightArray[j] = sc.nextInt();
			}
			
			Arrays.sort(logHeightArray);
			
			deque.clear();
			deque.offer(logHeightArray[n - 1]);		// 가장 큰 수 가운데 배치
			
			int difficulty = 0;
			
			for (int j = n - 2; j >= 0; --j) {
				int lastNum = deque.peekLast();
				
				deque.offer(logHeightArray[j--]);		// 큰 수 뒤에 배치
				difficulty = Math.max(difficulty, Math.abs(deque.peekLast() - lastNum));
				
				if (j >= 0) {
					int firstNum = deque.peek();
					
					deque.offerFirst(logHeightArray[j]);		// 큰 수 앞에 배치
					difficulty = Math.max(difficulty, Math.abs(deque.peek() - firstNum));
				}
			}
			
			difficulty = Math.max(difficulty, Math.abs(deque.peek() - deque.peekLast()));
			
			answer.append(difficulty).append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
