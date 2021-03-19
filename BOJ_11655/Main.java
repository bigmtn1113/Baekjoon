import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		
		sc.close();
		
		for (int i = 0; i < input.length(); ++i) {
			char c = input.charAt(i);
			
			if (c == ' ') {
				System.out.print(" ");
				continue;
			}
			
			if (('0' <= c) && (c <= '9')) {
				System.out.print(c);
				continue;
			}
			
			if (('A' <= c) && (c <= 'Z')) {
				if (('A' <= c + 13) && (c + 13 <= 'Z')) {
					System.out.print((char) (c + 13));
				} else {
					System.out.print((char) (c - 13));
				}
			} else {
				if (('a' <= c + 13) && (c + 13 <= 'z')) {
					System.out.print((char) (c + 13));
				} else {
					System.out.print((char) (c - 13));
				}
			}
		}
	}
	
}
