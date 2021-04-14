import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int l = sc.nextInt();
		
		int[] leakLocationArray = new int[n];
		
		for (int i = 0; i < n; ++i) {
			leakLocationArray[i] = sc.nextInt();
		}
		
		sc.close();
		
		Arrays.sort(leakLocationArray);
		
		int answer = 1;
		double range = leakLocationArray[0] - 0.5 + l;
		
		for (int i = 1; i < n; ++i) {
			if (leakLocationArray[i] < range) {
				continue;
			}
			
			++answer;
			range = leakLocationArray[i] - 0.5 + l;
		}
		
		System.out.print(answer);
	}

}
