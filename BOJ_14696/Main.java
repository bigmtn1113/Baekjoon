import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int i = 0; i < n; ++i) {
			int a = sc.nextInt();
			int[] aCards = new int[5];
			
			for (int j = 0; j < a; ++j) {
				++aCards[sc.nextInt()];
			}
			
			int b = sc.nextInt();
			int[] bCards = new int[5];
			
			for (int j = 0; j < b; ++j) {
				++bCards[sc.nextInt()];
			}
			
			boolean isDrawn = true;
			
			for (int j = 4; j > 0; --j) {
				if (aCards[j] > bCards[j]) {
					System.out.println("A");
					isDrawn = false;
					
					break;
				} else if (aCards[j] < bCards[j]) {
					System.out.println("B");
					isDrawn = false;
					
					break;
				}
			}
			
			if (isDrawn) {
				System.out.println("D");
			}
		}
		
		sc.close();
	}
	
}
