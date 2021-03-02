import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int maxPrice = 0;
		
		for (int i = 0; i < n; ++i) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			int num3 = sc.nextInt();
			
			int price = 0;
			
			if ((num1 == num2) && (num2 == num3)) {
				price = 10000 + num1 * 1000;
			} else if ((num1 != num2) && (num1 != num3) && (num2 != num3)) {
				price = Math.max(Math.max(num1, num2), num3) * 100;
			} else {
				if ((num1 == num2) || (num1 == num3)) {
					price = 1000 + num1 * 100;
				} else {
					price = 1000 + num2 * 100;
				}
			}
			
			maxPrice = Math.max(maxPrice, price);
		}
		
		sc.close();
		
		System.out.print(maxPrice);
	}
	
}
