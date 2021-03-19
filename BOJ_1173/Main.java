import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int minPulse = sc.nextInt();
		int maxPulse = sc.nextInt();
		int t = sc.nextInt();
		int r = sc.nextInt();
		
		sc.close();
		
		if ((minPulse == maxPulse) || (minPulse + t > maxPulse)) {
			System.out.print(-1);
			System.exit(0);
		}
		
		int cnt = 0;
		int currPulse = minPulse;
		int time = 0;
		
		while (cnt < n) {
			++time;
			
			if (currPulse + t <= maxPulse) {
				currPulse += t;
				++cnt;
				
				continue;
			}
			
			if (currPulse - r >= minPulse) {
				currPulse -= r;
				
				continue;
			}
			
			currPulse = minPulse;
		}
		
		System.out.print(time);
	}
	
}
