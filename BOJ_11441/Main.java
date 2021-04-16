import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] array = new int[n + 1];
		
		array[1] = sc.nextInt();
		
		for (int i = 2; i <= n; ++i) {
			array[i] = array[i - 1] + sc.nextInt();
		}
		
		StringBuilder answer = new StringBuilder();
		
		int m = sc.nextInt();
		
		for (int i = 0; i < m; ++i) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			answer.append(array[to] - array[from - 1]).append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
