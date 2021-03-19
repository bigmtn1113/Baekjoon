import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		sc.close();
		
		int temp = (int) Math.sqrt(m);
		
		int sum = 0;
		int minPerfectSquareNum = 0;
		
		if (temp * temp == m) {
			sum = m;
			minPerfectSquareNum = m;
		} else if ((temp + 1) * (temp + 1) <= n) {
			minPerfectSquareNum = (temp + 1) * (temp + 1);
		}
		
		for (int i = (int) Math.sqrt(m) + 1; i * i <= n ; ++i) {
			sum += i * i;
		}
		
		System.out.print((sum > 0) ? sum + "\n" + minPerfectSquareNum : -1);
	}
	
}
