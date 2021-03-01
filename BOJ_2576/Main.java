import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		int minOddNum = 100;
		int cnt = 0;
		
		for (int i = 0; i < 7; ++i) {
			int input = sc.nextInt();
			
			if (input % 2 == 1) {
				sum += input;
				
				minOddNum = Math.min(minOddNum, input);
				
				++cnt;
			}
		}
		
		sc.close();
		
		System.out.print((cnt > 0) ? sum + "\n" + minOddNum : -1);
	}
	
}
