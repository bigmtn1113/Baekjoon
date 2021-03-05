import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static int n;
	public static Integer[] input;
	
	public static int gcd(int index1, int index2) {
		while (input[index1] % input[index2] > 0) {
			int temp = input[index1];
			input[index1] = input[index2];
			input[index2] = temp % input[index2];
		}
		
		return input[index2];
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		input = new Integer[n];
		
		for (int i = 0; i < n; ++i) {
			input[i] = sc.nextInt();
		}
		
		sc.close();
		
		Arrays.sort(input, Collections.reverseOrder());
		
		int gcd = gcd(0, 1);
		
		if (n == 3) {
			gcd = gcd(1, 2);
		}
		
		for (int i = 1; i <= gcd; ++i) {
			if (gcd % i == 0) {
				System.out.println(i);
			}
		}
	}
	
}
