import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Integer[] array = new Integer[n];
		
		for (int i = 0; i < n; ++i) {
			array[i] = sc.nextInt();
		}
		
		sc.close();
		
		Arrays.sort(array, Collections.reverseOrder());
		
		StringBuilder answer = new StringBuilder();
		
		for (int i : array) {
			answer.append(i + "\n");
		}
		
		System.out.print(answer);
	}
	
}
