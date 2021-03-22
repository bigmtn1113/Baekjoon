import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String n = sc.next();
		
		sc.close();
		
		boolean check = false;
		StringBuilder num1 = new StringBuilder();
		
		for (int i = 0; i < n.length() - 1; ++i) {
			num1.append(n.charAt(i));
			
			StringBuilder num2 = new StringBuilder();
			
			for (int j = i + 1; j < n.length(); ++j) {
				num2.append(n.charAt(j));
			}
			
			int num1Multiplication = 1;
			int num2Multiplication = 1;
			
			for (int j = 0; j < num1.length(); ++j) {
				num1Multiplication *= num1.charAt(j) - '0';
			}
			
			for (int j = 0; j < num2.length(); ++j) {
				num2Multiplication *= num2.charAt(j) - '0';
			}
			
			if (num1Multiplication == num2Multiplication) {
				check = true;
				break;
			}
		}
		
		System.out.print((check) ? "YES" : "NO");
	}
	
}
