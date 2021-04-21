import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
	public static LinkedHashSet<String> set = new LinkedHashSet<>();
	
	public static void recursionFunc(int[] array, int m, int preIndex, String result, int cnt) {
		if (cnt == m) {
			set.add(result);
			return;
		}
		
		for (int i = 0; i < array.length; ++i) {
			recursionFunc(array, m, i, result + array[i] + " ", cnt + 1);
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
		
		recursionFunc(array, m, -1, "", 0);
		
		StringBuilder answer = new StringBuilder();
		
		for (String result : set) {
			answer.append(result).append("\n");
		}
		
		System.out.print(answer);
	}

}
