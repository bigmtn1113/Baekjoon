import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String plaintext = sc.nextLine();
		String key = sc.next();
		
		sc.close();
		
		for (int i = 0; i < plaintext.length(); ++i) {
			char c = plaintext.charAt(i);
			
			if (c == ' ') {
				System.out.print(" ");
				continue;
			}
			
			char result = (char) (c - (key.charAt(i % key.length()) - 'a' + 1));
			
			if (result < 'a') {
				result += 26;
			} else if (result > 'z') {
				result -= 26;
			}
			
			System.out.print(result);
		}
	}
	
}
