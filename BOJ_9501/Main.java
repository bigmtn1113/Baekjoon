import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while (t > 0) {
			int n = sc.nextInt();
			int d = sc.nextInt();
			
			int spaceCraftCnt = 0;
			
			for (int i = 0; i < n; ++i) {
				int v = sc.nextInt();
				int f = sc.nextInt();
				int c = sc.nextInt();
				
				if (v * ((double) f / c) >= d) {
					++spaceCraftCnt;
				}
			}
			
			System.out.println(spaceCraftCnt);
			
			--t;
		}
		
		sc.close();
	}
	
}
