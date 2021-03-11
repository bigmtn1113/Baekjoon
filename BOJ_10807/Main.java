import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] input = new int[n];
		
		for (int i = 0; i < n; ++i) {
			input[i] = sc.nextInt();
		}
		
		int v = sc.nextInt();
		
		sc.close();
		
		int cnt = 0;
		
		for (int num : input) {
			if (num == v) {
				++cnt;
			}
		}
		
		System.out.print(cnt);
	}
	
}
