import java.util.Scanner;

public class Main {
	
	public static int parametricSearch(long x, long y, int begin, int end) {
		long currPercent = y * 100 / x;
		
		if (currPercent >= 99) {
			return 0;
		}
		
		int mid = 0;
		int result = 0;
		
		while (begin <= end) {
			mid = (begin + end) / 2;
			
			long nextPercent = (y + mid) * 100 / (x + mid);
			
			if (nextPercent > currPercent) {
				result = mid;
				end = mid - 1;
			} else {
				begin = mid + 1;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long x = sc.nextLong();
		long y = sc.nextLong();
		
		sc.close();
		
		int answer = parametricSearch(x, y, 1, 2000000000);
		
		System.out.print((answer > 0) ? answer : -1);
	}

}
