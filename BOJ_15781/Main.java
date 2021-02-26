import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int maxHelmet = 0;
		int maxVest = 0;
		
		while (n > 0) {
			maxHelmet = Math.max(maxHelmet, sc.nextInt());
			--n;
		}
		
		while (m > 0) {
			maxVest = Math.max(maxVest, sc.nextInt());
			--m;
		}
		
		sc.close();
		
		System.out.print(maxHelmet + maxVest);
	}
	
}
