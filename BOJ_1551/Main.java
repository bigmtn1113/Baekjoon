import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		String[] aStrArray = sc.next().split(",");
		
		sc.close();
		
		int[] aIntArray = new int[n];
		
		for (int i = 0; i < n; ++i) {
			aIntArray[i] = Integer.parseInt(aStrArray[i]);
		}
		
		for (int i = 0; i < k; ++i) {
			for (int j = 1; j < n - i; ++j) {
				aIntArray[j - 1] = aIntArray[j] - aIntArray[j - 1];
			}
		}
		
		for (int i = 0; i < n - k - 1; ++i) {
			System.out.print(aIntArray[i] + ",");
		}
		
		System.out.print(aIntArray[n - k - 1]);
	}
	
}
