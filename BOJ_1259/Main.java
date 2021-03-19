import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			String input = sc.next();
			
			if (input.equals("0")) {
				break;
			}
			
			boolean check = true;
			
			for (int i = 0; i < input.length(); ++i) {
				if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
					check = false;
				}
			}
			
			System.out.println((check) ? "yes" : "no");
		}
		
		sc.close();
	}
	
}
