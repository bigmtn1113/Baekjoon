import java.util.Scanner;

public class Main {
	public static int[] resultArray = new int[6];
	public static int resultArrayIndex = 0;
	public static boolean[] visited;
	
	public static StringBuilder answer = new StringBuilder();
	
	public static void recursionFunc(int[] numArray, int preIndex, int cnt) {
		if (cnt == 6) {
			for (int num : resultArray) {
				answer.append(num).append(" ");
			}
			
			answer.append("\n");
			return;
		}
		
		for (int i = 0; i < numArray.length; ++i) {
			if ((!visited[i]) && i > preIndex) {
				visited[i] = true;
				resultArray[resultArrayIndex++] = numArray[i];
				
				recursionFunc(numArray, i, cnt + 1);
				
				--resultArrayIndex;
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			int k = sc.nextInt();
			
			if (k == 0) {
				break;
			}
			
			int[] numArray = new int[k];
			visited = new boolean[k];
			
			for (int i = 0; i < k; ++i) {
				numArray[i] = sc.nextInt();
			}
			
			recursionFunc(numArray, -1, 0);
			
			answer.append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
