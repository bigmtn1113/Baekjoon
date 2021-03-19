import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] array = new int[n + 1][m + 1];
		
		for (int u = 1; u <= n; ++u) {
			for (int v = 1; v <= m; ++v) {
				array[u][v] = sc.nextInt();
			}
		}
		
		int k = sc.nextInt();
		
		for (int t = 0; t < k; ++t) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			int sum = 0;
			
			for (int u = i; u <= x; ++u) {
				for (int v = j; v <= y; ++v) {
					sum += array[u][v];
				}
			}
			
			System.out.println(sum);
		}
		
		sc.close();
	}
	
}
