import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		
		sc.close();
		
		int cnt = 0;
		
		for (int i = 0; i < input.length(); ++i) {
			if ((input.charAt(i) == 'a') || (input.charAt(i) == 'e') || (input.charAt(i) == 'i')
					|| (input.charAt(i) == 'o') || (input.charAt(i) == 'u')) {
				++cnt;
			}
		}
		
		System.out.print(cnt);
	}
	
}
