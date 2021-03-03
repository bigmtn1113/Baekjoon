import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();
		int m = sc.nextInt();
		int s = sc.nextInt();
		int tc = sc.nextInt();
		
		int currentTime = h * 3600 + m * 60 + s;
		
		for (int i = 0; i < tc; ++i) {
			int queryT = sc.nextInt();
			
			if (queryT == 3) {
				System.out.println(currentTime / 3600 + " " + currentTime / 60 % 60 + " " + currentTime % 60);
			} else {
				int queryC = sc.nextInt();
				
				currentTime = (queryT == 1) ? (currentTime + queryC) % 86400 : (currentTime - queryC) % 86400;
				
				if (currentTime < 0) {
					currentTime = (currentTime % 86400 == 0) ? 0 : currentTime % 86400 + 86400;
				}
			}
		}
		
		sc.close();	
	}
	
}
