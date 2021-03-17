import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String seats = sc.next();
		
		sc.close();
		
		int cnt = 2;
		boolean canPair = false;
		
		for (int i = 1; i < n; ++i) {
			char seat1 = seats.charAt(i - 1);
			char seat2 = seats.charAt(i);
			
			if ((seat1 == 'S') || (seat2 == 'S') || (canPair)) {
				canPair = false;
				++cnt;
				continue;
			}
			
			canPair = true;
		}
		
		System.out.print((cnt > n) ? n : cnt);
	}
	
}
