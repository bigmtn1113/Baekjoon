import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			
			for (int j = 0; j < h; ++j) {
				String input = sc.next();
				
				for (int k = 0; k < w; ++k) {
					System.out.print(input.charAt(w - 1 - k));
				}
				
				System.out.println();
			}
		}
		
		sc.close();
	}
	
}
