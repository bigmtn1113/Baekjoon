import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void recursionFunc(int[] array, int m, String s, int cnt, StringBuilder answer) {
		if (cnt == m) {
			answer.append(s).append("\n");
			return;
		}
		
		for (int i = 0; i < array.length; ++i) {
			recursionFunc(array, m, s + array[i] + " ", cnt + 1, answer);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] array = new int[n];
		
		for (int i = 0; i < n; ++i) {
			array[i] = sc.nextInt();
		}
		
		sc.close();
		
		Arrays.sort(array);
		
		StringBuilder answer = new StringBuilder();
		
		recursionFunc(array, m, "", 0, answer);
		
		System.out.print(answer);
	}

}
