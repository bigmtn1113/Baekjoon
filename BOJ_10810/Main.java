import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] nums = new int[n + 1];
		
		for (int t = 0; t < m; ++t) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int k = sc.nextInt();
			
			for (int h = i; h <= j; ++h) {
				nums[h] = k;
			}
		}
		
		sc.close();
		
		for (int t = 1; t <= n; ++t) {
			System.out.print(nums[t] + " ");
		}
	}
	
}
