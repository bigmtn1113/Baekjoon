import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		String b = sc.next();
		
		sc.close();
		
		int aLength = a.length();
		int bLength = b.length();
		
		int minCnt = 50;
		
		for (int i = 0; i <= bLength - aLength; ++i) {
			int cnt = 0;
			
			for (int j = 0; j < aLength; ++j) {
				if (a.charAt(j) != b.charAt(i + j)) {
					++cnt;
				}
			}
			
			minCnt = Math.min(minCnt, cnt);
		}
		
		System.out.print(minCnt);
	}
	
}
