import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		
		sc.close();
		
		if (input.charAt(0) == 'F') {
			System.out.print(0.0);
			System.exit(0);
		}
		
		double gpa = 0;
		
		switch (input.charAt(0)) {
		case 'A':
			gpa = 4.0;
			break;

		case 'B':
			gpa = 3.0;
			break;
			
		case 'C':
			gpa = 2.0;
			break;
			
		case 'D':
			gpa = 1.0;
			break;
			
		default:
			gpa = 0.0;
			break;
		}
		
		switch (input.charAt(1)) {
		case '+':
			gpa += 0.3;
			break;

		case '-':
			gpa -= 0.3;
			break;
		
		default:
			break;
		}
		
		System.out.print(gpa);
	}
	
}
