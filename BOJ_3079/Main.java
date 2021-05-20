import java.util.Scanner;

public class Main {
	public static long parametricSearch(int[] t, int target, long begin, long end) {
		long mid = 0;
		long result = 0;
		
		while (begin <= end) {
			mid = (begin + end) / 2;
			
			long sum = 0;
			
			for (int i = 0; i < t.length; ++i) {
				sum += mid / t[i];
			}
			
			if (sum >= target) {
				end = mid - 1;
				result = mid;
			} else {
				begin = mid + 1;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] t = new int[n];
		
		for (int i = 0; i < n; ++i) {
			t[i] = sc.nextInt();
		}
		
		sc.close();
		
		int maxT = 0;
		
		for (int i = 0; i < n; ++i) {
			maxT = Math.max(maxT, t[i]);
		}
		
		long maxSecond = (long) maxT * m;
		
		System.out.print(parametricSearch(t, m, 0, maxSecond));
	}

}
