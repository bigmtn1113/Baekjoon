import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		StringBuilder answer = new StringBuilder();
		
		for (int i = 0; i < t; ++i) {
			int[] a = new int[10];
			
			for (int j = 0; j < 10; ++j) {
				a[j] = sc.nextInt();
			}
			
			Arrays.sort(a);
			
			answer.append(a[7] + "\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}
	
}
