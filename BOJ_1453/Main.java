import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		boolean[] seats = new boolean[101];
		int cnt = 0;
		
		for (int i = 0; i < n; ++i) {
			int input = sc.nextInt();
			
			if (seats[input]) {
				++cnt;
			} else {
				seats[input] = true;
			}
		}
		
		sc.close();
		
		System.out.print(cnt);
	}
	
}
