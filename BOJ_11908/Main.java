import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int max = 0;
		int sum = 0;
		
		while (n > 0) {
			int input = sc.nextInt();
			
			sum += input;
			max = Math.max(max, input);
			
			--n;
		}
		
		sc.close();
		
		System.out.print(sum - max);
	}
	
}
