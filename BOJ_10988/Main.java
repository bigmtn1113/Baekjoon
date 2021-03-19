import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		
		sc.close();
		
		boolean check = false;
		
		for (int i = 0; i < input.length(); ++i) {
			if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
				check = true;
				break;
			}
		}
		
		System.out.print((check) ? 0 : 1);
	}
	
}
