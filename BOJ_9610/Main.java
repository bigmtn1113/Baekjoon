import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] result = new int[5];
		
		for (int i = 0; i < n; ++i) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			if ((x > 0) && (y > 0)) {
				++result[0];
			} else if ((x < 0) && (y > 0)) {
				++result[1];
			} else if ((x < 0) && (y < 0)) {
				++result[2];
			} else if ((x > 0) && (y < 0)) {
				++result[3];
			} else {
				++result[4];
			}
		}
		
		sc.close();
		
		System.out.format("Q1: %d\nQ2: %d\nQ3: %d\nQ4: %d\nAXIS: %d", result[0], result[1], result[2], result[3], result[4]);
	}
	
}
