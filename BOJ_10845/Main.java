import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		StringBuilder answer = new StringBuilder();
		
		int n = sc.nextInt();
		
		for (int i = 0; i < n; ++i) {
			String order = sc.next();
			
			switch (order) {
			case "push":
				deque.offer(sc.nextInt());
				break;
				
			case "pop":
				answer.append(deque.isEmpty() ? "-1" : deque.poll()).append("\n");
				break;
				
			case "size":
				answer.append(deque.size()).append("\n");
				break;
				
			case "empty":
				answer.append(deque.isEmpty() ? "1" : "0").append("\n");
				break;
				
			case "front":
				answer.append(deque.isEmpty() ? "-1" : deque.peek()).append("\n");
				break;

			default:
				answer.append(deque.isEmpty() ? "-1" : deque.peekLast()).append("\n");
				break;
			}
		}
		
		sc.close();
		
		System.out.print(answer);
	}
	
}
