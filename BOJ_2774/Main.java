import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			String x = sc.next();
			
			int[] cnt = new int[10];
			
			for (int j = 0; j < x.length(); ++j) {
				++cnt[x.charAt(j) - '0'];
			}
			
			int answer = 0;
			
			for (int j : cnt) {
				if (j > 0) {
					++answer;
				}
			}
			
			System.out.println(answer);
		}
		
		sc.close();
	}
	
}
