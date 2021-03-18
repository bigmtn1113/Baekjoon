import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] basket = new int[n + 1];
		
		for (int k = 1; k <= n; ++k) {
			basket[k] = k;
		}
		
		for (int k = 0; k < m; ++k) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			
			for (int s = i; s < j; ++s, --j) {
				int temp = basket[s];
				basket[s] = basket[j];
				basket[j] = temp;
			}
		}
		
		sc.close();
		
		for (int k = 1; k <= n; ++k) {
			System.out.print(basket[k] + " ");
		}
	}
	
}
