import java.util.Scanner;

public class Main {
	
	public static void recursionFunc(boolean[] visited, int n, String s, int cnt) {
		if (cnt == n) {
			System.out.println(s);
			return;
		}
		
		for (int i = 1; i <= n; ++i) {
			if (!visited[i]) {
				visited[i] = true;
				recursionFunc(visited, n, (s + i) + " ", cnt + 1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		boolean[] visited = new boolean[n + 1];
		
		recursionFunc(visited, n, "", 0);
	}

}
