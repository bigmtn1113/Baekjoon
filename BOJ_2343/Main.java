import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] lessons = new int[n];
		
		for (int i = 0; i < n; ++i) {
			lessons[i] = sc.nextInt();
		}
		
		sc.close();
		
		int bluRayLengthSum = 0;
		
		for (int i = 0; i < n; ++i) {
			bluRayLengthSum += lessons[i];
		}
		
		bluRayLengthSum /= m;	// 각 블루레이에 들어갈 수 있는 레슨의 길이 합
		
		int answer = 0;
		
		while (true) {
			int sum = 0;
			int tempM = m;
			
			for (int i = 0; i < n; ++i) {
				if ((lessons[i] + sum <= bluRayLengthSum) || (tempM == 1)) {
					sum += lessons[i];
				} else {
					answer = Math.max(answer, sum);
					
					sum = lessons[i];
					--tempM;
				}
			}
			
			if (sum <= bluRayLengthSum) {
				answer = Math.max(answer, sum);
				break;
			}
			
			++bluRayLengthSum;
		}
		
		System.out.print(answer);
	}

}
