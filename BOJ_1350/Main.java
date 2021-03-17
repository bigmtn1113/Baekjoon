import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] files = new int[n];
		
		for (int i = 0; i < n; ++i) {
			files[i] = sc.nextInt();
		}
		
		int clusterSize = sc.nextInt();
		
		sc.close();
		
		long sum = 0;
		
		for (int i = 0; i < n; ++i) {
			if (files[i] == 0) {
				continue;
			}
			
			if (files[i] % clusterSize == 0) {
				sum += files[i];
			} else {
				sum += (files[i] / clusterSize + 1) * clusterSize;
			}
		}
		
		System.out.print(sum);
	}
	
}
