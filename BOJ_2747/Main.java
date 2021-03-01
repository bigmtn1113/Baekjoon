import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		int num1 = 0;
		int num2 = 1;
		int nextNum = 1;
		
		for (int i = 2; i <= n; ++i) {
			nextNum = num1 + num2;
			
			num1 = num2;
			num2 = nextNum;
		}
		
		System.out.print(nextNum);
	}
	
}
