import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNextLine()) {
			int[] result = new int[4];
			
			String input = sc.nextLine();
			
			for (int i = 0; i < input.length(); ++i) {
				char c = input.charAt(i);
				
				if (('a' <= c) && (c <= 'z')) {
					++result[0];
				} else if (('A' <= c) && (c <= 'Z')) {
					++result[1];
				} else if ((0 <= c - '0') && (c - '0' <= 9)) {
					++result[2];
				} else {
					++result[3];
				}
			}
			
			System.out.format("%d %d %d %d\n", result[0], result[1], result[2], result[3]);
		}
		
		sc.close();
	}
	
}
