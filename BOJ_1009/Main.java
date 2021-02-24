import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while (t > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int computerNum = 0;
			
			if (b % 4 == 0) {
				computerNum = (int) Math.pow(a, 4) % 10;
			} else {
				computerNum = (int) Math.pow(a, b % 4) % 10;
			}
			
			if (a % 10 == 0) {
				computerNum = 10;
			}
			
			System.out.println(computerNum);
			
			--t;
		}
		
		sc.close();
	}
	
}
