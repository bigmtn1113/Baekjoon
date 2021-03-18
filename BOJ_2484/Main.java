import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int maxReword = 0;
		
		for (int i = 0; i < n; ++i) {
			int[] dice = new int[7];
			
			for (int j = 0; j < 4; ++j) {
				++dice[sc.nextInt()];
			}
			
			int reword = 0;
			
			int[] pairNum = new int[2];
			int pairNumIndex = 0;
			
			int maxNum = 0;
			
			label: for (int j = 1; j < 7; ++j) {
				switch (dice[j]) {
				case 4:
					reword = 50000 + j * 5000;
					break label;
					
				case 3:
					reword = 10000 + j * 1000;
					break label;
					
				case 2:
					pairNum[pairNumIndex++] = j;
					break;
					
				case 1:
					maxNum = Math.max(maxNum, j);
					break;

				default:
					break;
				}
			}
			
			switch (pairNumIndex) {
			case 2:
				reword = 2000 + pairNum[0] * 500 + pairNum[1] * 500;
				break;
				
			case 1:
				reword = 1000 + pairNum[0] * 100;
				break;

			default:
				reword = Math.max(reword, maxNum * 100);
				break;
			}
			
			maxReword = Math.max(maxReword, reword);
		}
		
		sc.close();
		
		System.out.print(maxReword);
	}
	
}
