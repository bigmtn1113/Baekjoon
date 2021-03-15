import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int p = sc.nextInt();
		
		sc.close();
		
		int[] cycleNums = new int[p];
		
		int remainder = n * n % p;
		int cnt = 0;
		
		while (cycleNums[remainder] < 3) {
			++cycleNums[remainder];
			remainder = remainder * n % p;
		}
		
		for (int cycleNum : cycleNums) {
			if (cycleNum > 1) {
				++cnt;
			}
		}
		
		System.out.print(cnt);
	}
	
}
