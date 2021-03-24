import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		sc.close();
		
		int tempNum1 = num1;
		int tempNum2 = num2;
		
		while (tempNum1 % tempNum2 != 0) {
			int temp = tempNum1;
			tempNum1 = tempNum2;
			tempNum2 = temp % tempNum2;
		}
		
		System.out.format("%d\n%d", tempNum2, num1 * num2 / tempNum2);
	}
	
}
