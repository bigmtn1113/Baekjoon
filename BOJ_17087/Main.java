import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int s = sc.nextInt();
		
		int[] distanceArray = new int[n];
		
		for (int i = 0; i < n; ++i) {
			distanceArray[i] = Math.abs(s - sc.nextInt());
		}
		
		sc.close();
		
		for (int i = 1; i < n; ++i) {
			while (distanceArray[i - 1] > 0) {
				int temp = distanceArray[i];
				distanceArray[i] = distanceArray[i - 1];
				distanceArray[i - 1] = temp % distanceArray[i - 1];
			}
		}
		
		System.out.print(distanceArray[n - 1]);
	}

}
