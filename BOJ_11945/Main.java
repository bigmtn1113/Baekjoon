import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		for (int i = 0; i < n; ++i) {
			String input = "";
			
			if (m != 0) {
				input = sc.next();
			}
			
			for (int j = 0; j < m; ++j) {
				System.out.print(input.charAt(m - 1 - j));
			}
			
			System.out.println();
		}
		
		sc.close();
	}
	
}
