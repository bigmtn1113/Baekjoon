import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static boolean binarySearch(int[] cards, int target, int begin, int end) {
		while (begin <= end) {
			int mid = (begin + end) / 2;
			
			if (cards[mid] == target) {
				return true;
			} else if (cards[mid] < target) {
				begin = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] cards = new int[n];
		
		for (int i = 0; i < n; ++i) {
			cards[i] = sc.nextInt();
		}
		
		Arrays.sort(cards);
		
		int m = sc.nextInt();
		
		StringBuilder answer = new StringBuilder();
		
		for (int i = 0; i < m; ++i) {
			answer.append((binarySearch(cards, sc.nextInt(), 0, n - 1)) ? "1 " : "0 ");
		}
		
		sc.close();
		
		System.out.print(answer);
	}
	
}
