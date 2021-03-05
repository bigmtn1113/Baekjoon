import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		int pointCnt = 2;
		int sideCnt = 1;
		
		for (int i = 1; i <= n; ++i) {
			pointCnt += sideCnt;
			sideCnt *= 2;
		}
		
		System.out.format("%.0f", Math.pow(pointCnt, 2));
	}
	
}
