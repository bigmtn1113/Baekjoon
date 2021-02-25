import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int uk = sc.nextInt();
		int je = sc.nextInt();
		
		sc.close();
		
		double result = 1 / (1 + Math.pow(10, ((double) (je - uk) / 400)));
		
		System.out.format("%.4f", result);
	}
	
}
