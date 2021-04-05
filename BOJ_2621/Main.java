import java.util.Scanner;

public class Main {
	
	public static void printAnswer(int num) {
		System.out.print(num);
		System.exit(0);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] colors = new char[5];
		int[] nums = new int[5];
		
		int[] colorCnt = new int[4];
		int[] numCnt = new int[10];
		
		int minNum = 9;
		int maxNum = 0;
		
		for (int i = 0; i < 5; ++i) {
			colors[i] = sc.next().charAt(0);
			nums[i] = sc.nextInt();
			
			switch (colors[i]) {
			case 'R':
				++colorCnt[0];
				break;
				
			case 'B':
				++colorCnt[1];
				break;
				
			case 'Y':
				++colorCnt[2];
				break;

			default:
				++colorCnt[3];
				break;
			}
			
			++numCnt[nums[i]];
			
			minNum = Math.min(minNum, nums[i]);
			maxNum = Math.max(maxNum, nums[i]);
		}
		
		sc.close();
		
		for (int i : colorCnt) {
			if (i == 5) {
				int cnt = 0;
				
				for (int j = minNum; j <= maxNum; ++j) {
					if (numCnt[j] != 1) {
						break;
					}
					
					++cnt;
				}
				
				if (cnt == 5) {
					printAnswer(maxNum + 900);
				}
			}
		}
		
		int cnt = 0;
		
		for (int j = minNum; j <= maxNum; ++j) {
			if (numCnt[j] == 4) {
				printAnswer(j + 800);
			} else if (numCnt[j] == 3) {
				for (int k = minNum; k <= maxNum; ++k) {
					if ((k != j) && (numCnt[k] == 2)) {
						printAnswer(j * 10 + k + 700);
					}
				}
			} else if (numCnt[j] == 1) {
				++cnt;
			} else {
				--cnt;
			}
		}
		
		for (int i : colorCnt) {
			if (i == 5) {
				printAnswer(maxNum + 600);
			}
		}
		
		if (cnt == 5) {
			printAnswer(maxNum + 500);
		}
		
		for (int j = minNum; j <= maxNum; ++j) {
			if (numCnt[j] == 3) {
				printAnswer(j + 400);
			}
		}
		
		for (int j = minNum; j <= maxNum; ++j) {
			if (numCnt[j] == 2) {
				for (int k = minNum; k <= maxNum; ++k) {
					if ((k != j) && (numCnt[k] == 2)) {
						printAnswer(Math.max(j, k) * 10 + Math.min(j, k) + 300);
					}
				}
				
				printAnswer(j + 200);
			}
		}
		
		System.out.print(maxNum + 100);
	}
	
}
