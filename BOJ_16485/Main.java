import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int c = sc.nextInt();
		int b = sc.nextInt();
		
		sc.close();
		
		System.out.format("%.6f", (double) c / b);
	}
	
}
