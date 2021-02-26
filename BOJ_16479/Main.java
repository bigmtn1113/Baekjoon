import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		int d1 = sc.nextInt();
		int d2 = sc.nextInt();
		
		sc.close();
		
		double height = (d1 - d2 == 0) ? k * k : k * k - Math.pow((double) (d1 - d2) / 2, 2);
		
		System.out.format("%.6f", height);
	}
	
}
