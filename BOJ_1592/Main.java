import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int l = sc.nextInt();
		
		sc.close();
		
		int[] seats = new int[n + 1];
		
		int i = 1;
		int cnt = 0;
		
		while (true) {
			++seats[i];
			
			if (seats[i] == m) {
				break;
			}
			
			if (seats[i] % 2 == 1) {
				i += l;
			} else {
				i -= l;
			}
			
			if (i > n) {
				i %= n;
			} else if (i < 1) {
				i += n;
			}
			
			++cnt;
		}
		
		System.out.print(cnt);
	}
	
}
