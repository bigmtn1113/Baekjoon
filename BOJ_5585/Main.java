import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int money = 1000 - sc.nextInt();
		
		sc.close();
		
		int[] coinTypes = {500, 100, 50, 10, 5, 1};
		int coinCnt = 0;
		
		for (int coinType : coinTypes) {
			coinCnt += money / coinType;
			money %= coinType;
		}
		
		System.out.print(coinCnt);
	}
	
}
