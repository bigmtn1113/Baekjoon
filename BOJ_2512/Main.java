import java.util.Scanner;

public class Main {
	
	public static int parametricSearch(int[] budgetArray, int m, int begin, int end) {
		int mid = 0;
		int result = 0;
		
		while (begin <= end) {
			mid = (begin + end) / 2;
			
			int sum = 0;
			
			for (int i = 0; i < budgetArray.length; ++i) {
				sum += (budgetArray[i] > mid) ? mid : budgetArray[i];
			}
			
			if (sum <= m) {
				result = mid;
				begin = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] budgetArray = new int[n];
		
		int sum = 0;
		int maxBudget = 0;
		
		for (int i = 0; i < n; ++i) {
			budgetArray[i] = sc.nextInt();
			sum += budgetArray[i];
			
			maxBudget = Math.max(maxBudget, budgetArray[i]);
		}
		
		int m = sc.nextInt();
		
		sc.close();
		
		if (sum <= m) {
			System.out.print(maxBudget);
			System.exit(0);
		}
		
		System.out.print(parametricSearch(budgetArray, m, 0, maxBudget));
	}

}
