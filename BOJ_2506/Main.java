import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int sum = 0;
		int additionalPoint = 0;
		
		while (n > 0) {
			byte input = sc.nextByte();
			
			if (input == 1) {
				++additionalPoint;
				sum += additionalPoint;
			} else {
				additionalPoint = 0;
			}
			
			--n;
		}
		
		sc.close();
		
		System.out.print(sum);
	}
	
}
