import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int n = sc.nextInt();
			
			int maxShopLocation = 0;
			int minShopLocation = 99;
			
			for (int j = 0; j < n; ++j) {
				int num = sc.nextInt();
				
				maxShopLocation = Math.max(maxShopLocation, num);
				minShopLocation = Math.min(minShopLocation, num);
			}
			
			System.out.println((maxShopLocation - minShopLocation) * 2);
		}
		
		sc.close();
	}
	
}
