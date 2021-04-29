import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] frameArray = new int[n];				// 사진틀
		int[] recommendationCntArray = new int[n];	// 게시된 사진들이 추천받은 횟수
		int[] timeArray = new int [n];				// 게시된 사진들이 게시된 시간
		
		label: for (int i = 0; i < m; ++i) {
			int student = sc.nextInt();
			
			int frameArrayIndex = -1;
			
			for (int j = 0; j < n; ++j) {
				if (frameArray[j] == student) {		// 이미 게시되어 있는 사진이면 추천 수만 증가
					++recommendationCntArray[j];
					continue label;
				}
				
				if (frameArray[j] == 0) {			// 비어있는 사진틀이 있으면 그 위치 저장
					frameArrayIndex = j;
					break;
				}
			}
			
			if (frameArrayIndex == -1) {			// 비어있는 사진틀이 없으면
				int minRecommendationCnt = 1000;
				int maxTime = 0;
				
				for (int j = 0; j < n; ++j) {		// 가장 적게 추천받은 사진 찾기
					minRecommendationCnt = Math.min(minRecommendationCnt, recommendationCntArray[j]);
				}
				
				for (int j = 0; j < n; ++j) {		// 가장 적게 추천받은 사진들 중 가장 오래 게시된 사진 찾기
					if (recommendationCntArray[j] == minRecommendationCnt) {
						if (timeArray[j] > maxTime) {
							maxTime = timeArray[j];
							frameArrayIndex = j;
						}
					}
				}
				
				recommendationCntArray[frameArrayIndex] = 0;
				timeArray[frameArrayIndex] = 0;
			}
			
			frameArray[frameArrayIndex] = student;
			++recommendationCntArray[frameArrayIndex];
			
			for (int j = 0; j < n; ++j) {			// 게시된 사진들 게시된 시간 증가
				if (frameArray[j] > 0) {
					++timeArray[j];
				}
			}
		}
		
		sc.close();
		
		Arrays.sort(frameArray);
		
		StringBuilder answer = new StringBuilder();
		
		for (int frame : frameArray) {
			answer.append(frame).append(" ");
		}
		
		System.out.print(answer);
	}

}
