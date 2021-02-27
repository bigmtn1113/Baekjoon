import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int a = 0;
		int aSum = 0;
		
		for (int i = 1; i <= n; ++i) {
			a = sc.nextInt() * i;
			
			System.out.print(a - aSum + " ");
			
			aSum += a - aSum;
		}
		
		sc.close();
	}
	
}
