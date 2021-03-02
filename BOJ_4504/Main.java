import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		while (true) {
			int input = sc.nextInt();
			
			if (input == 0) {
				break;
			}
			
			String result = "";
			
			if (input % n == 0) {
				result = input + " is a multiple of " + n + ".";
			} else {
				result = input + " is NOT a multiple of " + n + ".";
			}
			
			System.out.println(result);
		}
		
		sc.close();
	}
	
}
