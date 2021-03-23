import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int l = sc.nextInt();
		int n = sc.nextInt();
		
		boolean[] cakes = new boolean[l + 1];
		int[] cakeCnt = new int[n + 1];
		
		int maxExpect = 0;
		int expectPersonNum = 0;
		int maxCakeCnt = 0;
		int personNum = 0;
		
		for (int i = 1; i <= n; ++i) {
			int p = sc.nextInt();
			int k = sc.nextInt();
			
			if (k - p > maxExpect) {
				maxExpect = k - p;
				expectPersonNum = i;
			}
			
			for (int j = p; j <= k; ++j) {
				if (cakes[j] == false) {
					cakes[j] = true;
					++cakeCnt[i];
				}
			}
			
			if (cakeCnt[i] > maxCakeCnt) {
				maxCakeCnt = cakeCnt[i];
				personNum = i;
			}
		}
		
		sc.close();
		
		System.out.print(expectPersonNum + "\n" + personNum);
	}
	
}
