import java.util.Scanner;

public class Main {
	public static int answer = 0;
	
	public static void recursionFunc(int[][] eggArray, int brokenEggCnt, int cnt) {
		if (cnt == eggArray.length) {
			answer = Math.max(answer, brokenEggCnt);
			return;
		}
		
		if (eggArray[cnt][0] == 0) {		// 손에 든 계란이 깨진 계란일 경우 다음 계란으로 패스
			recursionFunc(eggArray, brokenEggCnt, cnt + 1);
			return;
		}
		
		for (int i = 0; i < eggArray.length; ++i) {
			if (i == cnt) {
				continue;
			}
			
			if (eggArray[i][0] > 0) {		// 깨지지 않은 계란일 경우
				int tempEggArray1 = eggArray[cnt][0];
				int tempEggArray2 = eggArray[i][0];
				int tempBrokenEggCnt = brokenEggCnt;
				
				eggArray[cnt][0] -= eggArray[i][1];
				eggArray[i][0] -= eggArray[cnt][1];
				
				if (eggArray[cnt][0] <= 0) {
					eggArray[cnt][0] = 0;
					++brokenEggCnt;
				}
				
				if (eggArray[i][0] <= 0) {
					eggArray[i][0] = 0;
					++brokenEggCnt;
				}
				
				recursionFunc(eggArray, brokenEggCnt, cnt + 1);
				
				eggArray[cnt][0] = tempEggArray1;
				eggArray[i][0] = tempEggArray2;
				brokenEggCnt = tempBrokenEggCnt;
			}
		}
		
		recursionFunc(eggArray, brokenEggCnt, cnt + 1);		// 마지막 계란을 집었으나 아무것도 깰 것이 없을 경우
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] eggArray = new int[n][2];
		
		for (int i = 0; i < n; ++i) {
			eggArray[i][0] = sc.nextInt();
			eggArray[i][1] = sc.nextInt();
		}
		
		sc.close();
		
		for (int i = 1; i < n; ++i) {		// 첫 번째 계란은 무조건 집어야 한다.
			int brokenEggCnt = 0;
			
			if (eggArray[i][0] > 0) {		// 깨지지 않은 계란일 경우
				int tempEggArray1 = eggArray[0][0];
				int tempEggArray2 = eggArray[i][0];
				
				eggArray[0][0] -= eggArray[i][1];
				eggArray[i][0] -= eggArray[0][1];
				
				if (eggArray[0][0] <= 0) {
					eggArray[0][0] = 0;
					++brokenEggCnt;
				}
				
				if (eggArray[i][0] <= 0) {
					eggArray[i][0] = 0;
					++brokenEggCnt;
				}
				
				recursionFunc(eggArray, brokenEggCnt, 1);
				
				eggArray[0][0] = tempEggArray1;
				eggArray[i][0] = tempEggArray2;
			}
		}
		
		System.out.print(answer);
	}

}
