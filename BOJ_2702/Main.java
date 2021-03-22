import java.util.Scanner;

public class Main {
	
	public static int gcd(int num1, int num2) {
		while (num1 % num2 != 0) {
			int temp = num1 % num2;
				num1 = num2;
				num2 = temp;
		}
		return num2;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			int answerGcd = (num1 > num2) ? gcd(num1, num2) : gcd(num2, num1);
			int answerLcm = num1 * num2 / answerGcd;
			
			System.out.println(answerLcm + " " + answerGcd);
		}
		
		sc.close();
	}
	
}
