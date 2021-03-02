import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		int pointCnt = 5;
		
		for (int i = 2; i <= n; ++i) {
			pointCnt += i * 3 + 1;
			pointCnt %= 45678;
		}
		
		System.out.print(pointCnt);
	}
	
}
