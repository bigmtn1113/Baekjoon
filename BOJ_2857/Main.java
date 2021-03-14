import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		boolean check = false;
		
		for (int t = 1; t <= 5; ++t) {
			String input = sc.next();
			
			for (int j = 2; j < input.length(); ++j) {
				char f = input.charAt(j - 2);
				char b = input.charAt(j - 1);
				char i = input.charAt(j);
				
				if ((f == 'F') && (b == 'B') && (i == 'I')) {
					System.out.print(t + " ");
					check = true;
					
					break;
				}
			}
		}
		
		sc.close();
		
		if (!check) {
			System.out.print("HE GOT AWAY!");
		}
	}
	
}
