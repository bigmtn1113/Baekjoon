import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static int n;
	public static int k;
	public static int[] cards;
	public static boolean[] visited;
	public static Set<String> set = new HashSet<>();
	
	public static void recursionFunc(String result, int cnt) {
		if (cnt == k) {
			set.add(result);
			return;
		}
		
		for (int i = 0; i < n; ++i) {
			if (!visited[i]) {
				visited[i] = true;
				
				recursionFunc(result + cards[i], cnt + 1);
				
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		cards = new int[n];
		visited = new boolean[n];
		
		for (int i = 0; i < n; ++i) {
			cards[i] = sc.nextInt();
		}
		
		sc.close();
		
		recursionFunc("", 0);
		
		System.out.print(set.size());
	}
	
}
