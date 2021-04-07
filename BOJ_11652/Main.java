import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long[] cards = new long[n];
		
		for (int i = 0; i < n; ++i) {
			cards[i] = sc.nextLong();
		}
		
		sc.close();
		
		Arrays.sort(cards);
		
		int cnt = 1;
		int maxCnt = 0;
		long answer = cards[0];
		
		for (int i = 1; i < n; ++i) {
			if (cards[i - 1] == cards[i]) {
				++cnt;
			} else {
				if (cnt > maxCnt) {
					maxCnt = cnt;
					answer = cards[i - 1];
				}
				
				cnt = 1;
			}
		}
		
		if (cnt > maxCnt) {
			maxCnt = cnt;
			answer = cards[n - 1];
		}
		
		System.out.print(answer);
	}

}
