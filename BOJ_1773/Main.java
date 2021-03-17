import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int c = sc.nextInt();
		
		boolean[] fireworkTime = new boolean[c + 1];
		
		for (int i = 0; i < n; ++i) {
			int cycle = sc.nextInt();
			
			for (int j = 1; j <= c; ++j) {
				if (j % cycle == 0) {
					fireworkTime[j] = true;
				}
			}
		}
		
		sc.close();
		
		int cnt = 0;
		
		for (boolean b : fireworkTime) {
			if (b) {
				++cnt;
			}
		}
		
		System.out.print(cnt);
	}
	
}
