import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			int n = sc.nextInt();
			
			int cnt = 0;
			
			for (int j = 0; j < n; ++j) {
				int cx = sc.nextInt();
				int cy = sc.nextInt();
				int r = sc.nextInt();
				
				boolean circle1Check = false;
				boolean circle2Check = false;
				
				if (Math.sqrt((x1 - cx) * (x1 - cx) + (y1 - cy) * (y1 - cy)) <= r) {
					circle1Check = true;
				}
				
				if (Math.sqrt((x2 - cx) * (x2 - cx) + (y2 - cy) * (y2 - cy)) <= r) {
					circle2Check = true;
				}
				
				if (circle1Check != circle2Check) {
					++cnt;
				}
			}
			
			answer.append(cnt).append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
