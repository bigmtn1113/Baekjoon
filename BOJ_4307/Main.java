import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int l = sc.nextInt();
			int n = sc.nextInt();
			
			int[] antArray = new int[n];
			
			int leftmostAnt = l;
			int rightmostAnt = 0;
			int oneOfLeftAntsRightAnt = 0;
			int oneOfRightAntsLeftAnt = l;
			
			for (int j = 0; j < n; ++j) {
				antArray[j] = sc.nextInt();
				
				leftmostAnt = Math.min(leftmostAnt, antArray[j]);
				rightmostAnt = Math.max(rightmostAnt, antArray[j]);
				
				if (antArray[j] <= l / 2) {
					oneOfLeftAntsRightAnt = Math.max(oneOfLeftAntsRightAnt, antArray[j]);
				} else {
					oneOfRightAntsLeftAnt = Math.min(oneOfRightAntsLeftAnt, antArray[j]);
				}
			}
			
			int earilestTime = Math.max(oneOfLeftAntsRightAnt, l - oneOfRightAntsLeftAnt);
			int latestTime = Math.max(l - leftmostAnt, rightmostAnt);
			
			answer.append(earilestTime).append(" ").append(latestTime).append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
