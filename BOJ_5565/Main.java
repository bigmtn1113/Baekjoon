import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int bookPriceSum = sc.nextInt();
		
		for (int i = 0; i < 9; ++i) {
			bookPriceSum -= sc.nextInt();
		}
		
		sc.close();
		
		System.out.print(bookPriceSum);
	}
	
}
