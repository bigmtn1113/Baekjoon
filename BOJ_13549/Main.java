import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		sc.close();
		
		int[] time = new int[Math.max(n, k) + 2];
		
		Arrays.fill(time, 123456789);
		time[n] = 0;
		
		// 0-1 BFS
		// 일반 BFS는 모든 간선의 가중치가 같을 때 사용하나 0-1 BFS는 0이거나 1일 때 사용한다.
		// 가중치가 0일 땐 큐의 맨 앞에다가, 1일 땐 큐의 맨 뒤에 데이터를 삽입한다. 
		// 다익스트라로 이 문제를 해결할 수 있으나 더 느리다.
		
		Deque<Integer> deque = new ArrayDeque<>();
		deque.offer(n);
		
		int[] nextN = new int[3];
		
		while (!deque.isEmpty()) {
			int currN = deque.poll();
			
			if (currN == k) {
				break;
			}
			
			nextN[0] = currN * 2;
			
			if ((nextN[0] < time.length) && time[nextN[0]] == 123456789) {
				time[nextN[0]] = time[currN];
				deque.offerFirst(nextN[0]);
			}
			
			nextN[1] = currN - 1;
			nextN[2] = currN + 1;
			
			for (int i = 1; i < 3; ++i) {
				if ((nextN[i] == -1) || (nextN[i] == time.length)) {
					continue;
				}
				
				if (time[nextN[i]] == 123456789) {
					time[nextN[i]] = time[currN] + 1;
					deque.offer(nextN[i]);
				}
			}
		}
		
		System.out.print(time[k]);
	}

}
