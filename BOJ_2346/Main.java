import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] array = new int[n + 1];
		
		for (int i = 1; i <= n; ++i) {
			array[i] = sc.nextInt();
		}
		
		sc.close();
		
		StringBuilder answer = new StringBuilder();
		
		int cnt = n;
		int balloonNum = 1;
		
		while (--cnt > 0) {
			answer.append(balloonNum).append(" ");
			
			int numInBalloon = array[balloonNum];
			
			array[balloonNum] = 0;
			
			if (numInBalloon < 0) {
				for (int i = numInBalloon; i < 0; ++i) {
					--balloonNum;
					
					if (balloonNum == 0) {
						balloonNum = n;
					}
					
					if (array[balloonNum] == 0) {
						--i;
					}
				}
			} else {
				for (int i = 0; i < numInBalloon; ++i) {
					++balloonNum;
					
					if (balloonNum == n + 1) {
						balloonNum = 1;
					}
					
					if (array[balloonNum] == 0) {
						--i;
					}
				}
			}
		}
		
		System.out.print(answer.append(balloonNum));
	}

}
