import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int c = sc.nextInt();
		int k = sc.nextInt();
		
		sc.close();
		
		double money = Math.pow(10, k);
		
		System.out.format("%.0f", Math.round(c / money) * money);
	}
	
}
