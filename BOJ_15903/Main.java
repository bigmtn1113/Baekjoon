import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		long answer = 0;
		
		for (int i = 0; i < n; ++i) {
			long card = sc.nextLong();
			
			pq.offer(card);
			answer += card;
		}
		
		sc.close();
		
		int cnt = 0;
		
		while (cnt < m) {
			long newCard = pq.poll() + pq.poll();
			
			pq.offer(newCard);
			pq.offer(newCard);
			
			answer += newCard;
			++cnt;
		}
		
		System.out.print(answer);
	}

}
