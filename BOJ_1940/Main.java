import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] numArray = new int[n];
		
		for (int i = 0; i < n; ++i) {
			numArray[i] = sc.nextInt();
		}
		
		sc.close();
		
		Arrays.sort(numArray);
		
		int begin = 0;
		int end = n - 1;
		
		int answer = 0;
		
		while (begin < end) {
			int sum = numArray[begin] + numArray[end];
			
			if (sum == m) {
				++answer;
				
				++begin;
				--end;
			} else if (sum < m) {
				++begin;
			} else {
				--end;
			}
		}
		
		System.out.print(answer);
	}

}
