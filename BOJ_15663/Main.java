import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
	public static boolean[] visited;
	
	public static LinkedHashSet<String> set = new LinkedHashSet<>();  // 이 문제에서 TreeSet의 정렬은 문자열 정렬이지 수열 정렬이 아니다.
	
	public static void recursionFunc(int[] array, int m, String s, int cnt) {
		if (cnt == m) {
			set.add(s);
			return;
		}
		
		for (int i = 0; i < array.length; ++i) {
			if (!visited[i]) {
				visited[i] = true;
				
				recursionFunc(array, m, s + array[i] + " ", cnt + 1);
				
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
		
		visited = new boolean[n];
		
		Arrays.sort(array);
		
		recursionFunc(array, m, "", 0);
		
		StringBuilder answer = new StringBuilder();
		
		for (String temp : set) {
			answer.append(temp).append("\n");
		}
		
		System.out.print(answer);
	}

}
