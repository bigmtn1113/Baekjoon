import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int minkookTotalScore = 0;
		int manseTotalScore = 0;
		
		for (int i = 0; i < 4; ++i) {
			minkookTotalScore += sc.nextInt();
		}
		
		for (int i = 0; i < 4; ++i) {
			manseTotalScore += sc.nextInt();
		}
		
		sc.close();
		
		System.out.print(Math.max(minkookTotalScore, manseTotalScore));
	}
	
}
