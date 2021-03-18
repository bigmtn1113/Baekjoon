import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int n = sc.nextInt();
			
			int maxNum = n;
			
			while (n > 1) {
				n = (n % 2 == 0) ? n / 2 : n * 3 + 1;
				maxNum = Math.max(maxNum, n);
			}
			
			System.out.println((maxNum > 1) ? maxNum : 1);
		}
		
		sc.close();
	}
	
}
