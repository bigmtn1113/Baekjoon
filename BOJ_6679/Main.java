import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		for (int i = 1000; i < 10000; ++i) {
			String decimal = Integer.toString(i, 10);
			String duodecimal = Integer.toString(i, 12);
			String hexadecimal = Integer.toString(i, 16);
			
			int decimalSum = 0;
			int duodecimalSum = 0;
			int hexadecimalSum = 0;
			
			for (int j = 0; j < 4; ++j) {
				decimalSum += decimal.charAt(j) - '0';
			}
			
			for (int j = 0; j < duodecimal.length(); ++j) {
				char c = duodecimal.charAt(j);
				
				switch (c) {
				case 'a':
					duodecimalSum += 10;
					break;
				
				case 'b':
					duodecimalSum += 11;
					break;

				default:
					duodecimalSum += c - '0';
					break;
				}
			}
			
			for (int j = 0; j < hexadecimal.length(); ++j) {
				char c = hexadecimal.charAt(j);
				
				switch (c) {
				case 'a':
					hexadecimalSum += 10;
					break;
					
				case 'b':
					hexadecimalSum += 11;
					break;
					
				case 'c':
					hexadecimalSum += 12;
					break;
					
				case 'd':
					hexadecimalSum += 13;
					break;
					
				case 'e':
					hexadecimalSum += 14;
					break;
					
				case 'f':
					hexadecimalSum += 15;
					break;

				default:
					hexadecimalSum += c - '0';
					break;
				}
			}
			
			if ((decimalSum == duodecimalSum)
					&& (duodecimalSum == hexadecimalSum)) {
				System.out.println(i);
			}
		}
		
		sc.close();
	}
	
}
