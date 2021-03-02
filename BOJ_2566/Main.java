import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int maxNum = 0;
		int maxNumX = 0;
		int maxNumY = 0;
		
		for (int i = 1; i <= 9; ++i) {
			for (int j = 1; j <= 9; ++j) {
				int input = sc.nextInt();
				
				if (maxNum < input) {
					maxNum = input;
					maxNumX = i;
					maxNumY = j;
				}
			}
		}
		
		sc.close();
		
		System.out.print(maxNum + "\n" + maxNumX + " " + maxNumY);
	}
	
}
