import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int p = sc.nextInt();
		
		sc.close();
		
		int x = a * p;
		int y = b;
		
		if (p > c) {
			y += (p - c) * d;
		}
		
		System.out.print(Math.min(x, y));
	}
	
}
