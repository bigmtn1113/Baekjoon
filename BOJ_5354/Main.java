import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int boxSize = sc.nextInt();
			
			if (boxSize == 1) {
				System.out.println("#");
				System.out.println();
				
				continue;
			}
			
			for (int j = 1; j <= boxSize; ++j) {
				System.out.print("#");
			}
			
			System.out.println();
			
			for (int j = 2; j <= boxSize - 1; ++j) {
				System.out.print("#");
				
				for (int k = 1; k <= boxSize - 2; ++k) {
					System.out.print("J");
				}
				
				System.out.println("#");
			}
			
			for (int j = 1; j <= boxSize; ++j) {
				System.out.print("#");
			}
			
			System.out.println("\n");
		}
		
		sc.close();
	}
	
}
