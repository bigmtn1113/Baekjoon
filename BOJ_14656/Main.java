import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int result = n;
		
		for (int i = 1; i <= n; ++i) {
			if (sc.nextInt() == i) {
				--result;
			}
		}
		
		sc.close();
		
		System.out.print(result);
	}
	
}
