import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int c = sc.nextInt();
			int v = sc.nextInt();
			
			System.out.println("You get " + c / v + " piece(s) and your dad gets " + c % v + " piece(s).");
		}
		
		sc.close();
	}
	
}
