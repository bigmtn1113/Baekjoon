import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		long sum = 0;
		
		for (long i = 1; i < n; ++i) {
			sum += n * i + i;
		}
		
		System.out.print(sum);
	}
	
}
