import java.util.Scanner;

public class Main {
	public static int n;
	public static int m;
	
	public static int parametrixSearch(int[] moneyArray, int begin, int end) {
		int mid = 0;
		int result = 0;
		
		while (begin <= end) {
			mid = (begin + end) / 2;
			
			int temp = mid;
			int cnt = 1;
			
			for (int i = 0; i < n; ++i) {
				if (temp - moneyArray[i] < 0) {
					++cnt;
					temp = (begin + end) / 2;
				}
				
				temp -= moneyArray[i];
			}
			
			if (cnt <= m) {
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
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		int[] moneyArray = new int[n];
		int begin = 0;
		
		for (int i = 0; i < n; ++i) {
			moneyArray[i] = sc.nextInt();
			
			begin = Math.max(begin, moneyArray[i]);
		}
		
		sc.close();
		
		System.out.print(parametrixSearch(moneyArray, begin, 100000 * 10000));
	}

}
