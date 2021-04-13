import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void recursionFunc(int[] array, boolean[] visited, int n, int m, String s, int cnt) {
		if (cnt == m) {
			System.out.println(s);
			return;
		}
		
		for (int i = 0; i < n; ++i) {
			if (!visited[i]) {
				visited[i] = true;
				recursionFunc(array, visited, n, m, s + array[i] + " ", cnt + 1);
				visited[i] = false;
			}
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
		
		boolean[] visited = new boolean[n];
		
		recursionFunc(array, visited, n, m, "", 0);
	}

}
