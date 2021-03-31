import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int n = sc.nextInt();
			
			String maxS = "";
			int maxL = 0;
			
			for (int j = 0; j < n; ++j) {
				String s = sc.next();
				int l = sc.nextInt();
				
				if (l > maxL) {
					maxL = l;
					maxS = s;
				}
			}
			
			answer.append(maxS + "\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}
	
}
