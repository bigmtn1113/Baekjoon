import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			String input = Integer.toBinaryString(sc.nextInt());
			
			for (int j = input.length() - 1; j >= 0; --j) {
				if (input.charAt(j) == '1') {
					System.out.print(input.length() - 1 - j + " ");
				}
			}
		}
		
		sc.close();		
	}
	
}
