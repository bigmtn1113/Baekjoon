import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		String[] room = new String[n];
		
		for (int i = 0; i < n; ++i) {
			room[i] = sc.next();
		}
		
		sc.close();
		
		int rowCnt = 0;
		int colCnt = 0;
		
		for (String s : room) {
			int cnt = 0;
			
			for (int i = 0; i < n; ++i) {
				if (s.charAt(i) == '.') {
					++cnt;
					continue;
				}
				
				if (cnt > 1) {
					++rowCnt;
				}
				
				cnt = 0;
			}
			
			if (cnt > 1) {
				++rowCnt;
			}
		}
		
		for (int i = 0; i < n; ++i) {
			int cnt = 0;
			
			for (int j = 0; j < n; ++j) {
				if (room[j].charAt(i) == '.') {
					++cnt;
					continue;
				}
				
				if (cnt > 1) {
					++colCnt;
				}
				
				cnt = 0;
			}
			
			if (cnt > 1) {
				++colCnt;
			}
		}
		
		System.out.print(rowCnt + " " + colCnt);
	}
	
}
