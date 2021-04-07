import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] distanceArray = new int[n - 1];
		int[] gasPriceArray = new int[n];
		
		for (int i = 0; i < n - 1; ++i) {
			distanceArray[i] = sc.nextInt();
		}
		
		for (int i = 0; i < n; ++i) {
			gasPriceArray[i] = sc.nextInt();
		}
		
		sc.close();
		
		long answer = (long) distanceArray[0] * gasPriceArray[0];
		
		for (int i = 1; i < n - 1; ++i) {
			if (gasPriceArray[i - 1] < gasPriceArray[i]) {
				gasPriceArray[i] = gasPriceArray[i - 1];
			}
			
			answer += (long) distanceArray[i] * gasPriceArray[i];
		}
		
		System.out.print(answer);
	}

}
