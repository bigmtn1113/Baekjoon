import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 3; ++i) {
			String input = sc.next();
			
			int cnt = 1;
			int maxCnt = 1;
			char c = input.charAt(0);
			
			for (int j = 1; j < input.length(); ++j) {
				if (input.charAt(j) == c) {
					++cnt;
					
					maxCnt = Math.max(maxCnt, cnt);
				} else {
					cnt = 1;
					
					c = input.charAt(j);
				}
			}
			
			System.out.println(maxCnt);
		}
		
		sc.close();
	}
	
}
