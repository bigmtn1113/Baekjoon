import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int evenNumSum = 0;
			int minEvenNum = 100;
			
			for (int j = 0; j < 7; ++j) {
				int input = sc.nextInt();
				
				if (input % 2 == 0) {
					evenNumSum += input;
					minEvenNum = Math.min(minEvenNum, input);
				}
			}
			
			System.out.println(evenNumSum + " " + minEvenNum);
		}
		
		sc.close();
	}
	
}
