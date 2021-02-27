import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		int maxPeopleCnt = 0;
		
		for (int i = 0; i < 4; ++i) {
			int getOffPeopleCnt = sc.nextInt();
			int getOnPeopleCnt = sc.nextInt();
			
			sum += getOnPeopleCnt - getOffPeopleCnt;
			
			maxPeopleCnt = Math.max(maxPeopleCnt, sum);
		}
		
		sc.close();
		
		System.out.print(maxPeopleCnt);
	}
	
}
