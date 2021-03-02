import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int ySum = 0;
			int kSum = 0;
			
			for (int j = 0; j < 9; ++j) {
				ySum += sc.nextInt();
				kSum += sc.nextInt();
			}
			
			if (ySum > kSum) {
				System.out.println("Yonsei");
			} else if (ySum == kSum) {
				System.out.println("Draw");
			} else {
				System.out.println("Korea");
			}
		}
		
		sc.close();
	}
	
}
