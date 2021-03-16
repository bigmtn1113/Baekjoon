import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] sticks = new int[n];
		
		for (int i = 0; i < n; ++i) {
			sticks[i] = sc.nextInt();
		}
		
		sc.close();
		
		int visibleStick = sticks[n - 1];
		int cnt = 1;
		
		for (int i = n - 2; i >= 0; --i) {
			if (sticks[i] > visibleStick) {
				visibleStick = sticks[i];
				
				++cnt;
			}
		}
		
		System.out.print(cnt);
	}
	
}
