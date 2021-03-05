import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int n = sc.nextInt();
		
		double theLowestPrice = (double) x / y;
		
		for (int i = 0; i < n; ++i) {
			int xi = sc.nextInt();
			int yi = sc.nextInt();
			
			theLowestPrice = Math.min(theLowestPrice, (double) xi / yi);
		}
		
		sc.close();
		
		System.out.format("%.2f", theLowestPrice * 1000);
	}
	
}
