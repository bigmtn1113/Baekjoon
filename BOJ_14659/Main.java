import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] peaks = new int[n];
		
		for (int i = 0; i < n; ++i) {
			peaks[i] = sc.nextInt();
		}
		
		sc.close();
		
		int cnt = 0;
		int maxCnt = 0;
		int prePeak = peaks[0];
		
		for (int i = 1; i < n; ++i) {
			if (peaks[i] < prePeak) {
				++cnt;
				continue;
			}
			
			prePeak = peaks[i];
			
			maxCnt = Math.max(maxCnt, cnt);
			cnt = 0;
		}
		
		maxCnt = Math.max(maxCnt, cnt);
		
		System.out.print(maxCnt);
	}
	
}
