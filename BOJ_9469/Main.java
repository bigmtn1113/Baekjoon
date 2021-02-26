import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int p = sc.nextInt();
		
		while (p > 0) {
			int n = sc.nextInt();
			
			float d = sc.nextFloat();
			float a = sc.nextFloat();
			float b = sc.nextFloat();
			float f = sc.nextFloat();
			
			float distance = d / (a + b) * f;
			
			System.out.format("%s %.2f\n", n + " ", distance);
			
			--p;
		}
		
		sc.close();
	}
	
}
