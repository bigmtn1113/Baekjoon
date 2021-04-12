import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		
		sc.close();
		
		int cnt = 0;
		int answer = 0;
		
		boolean open = false;
		
		for (int i = 0; i < input.length(); ++i) {
			char c = input.charAt(i);
			
			if (c == '(') {
				++cnt;
				
				open = true;
			} else {
				--cnt;
				answer += (open) ? cnt : 1;
				
				open = false;
			}
		}
		
		System.out.print(answer);
	}

}
