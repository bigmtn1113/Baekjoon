import java.util.Scanner;

public class Main {
	public static int[] resultArray;
	public static int resultArrayIndex = 1;
	public static boolean[] visited = new boolean[10];
	
	public static StringBuilder answer = new StringBuilder();
	
	public static void recursionFunc(String[] inequalitySignArray, int inequalitySignArrayIndex, int preNum, int cnt) {
		if (cnt == inequalitySignArray.length) {
			for (int num : resultArray) {
				answer.append(num);
			}
			
			answer.append("\n");
			return;
		}
		
		for (int i = 0; i < 10; ++i) {
			if (!visited[i] 
					&& ((inequalitySignArray[inequalitySignArrayIndex].equals("<") && (preNum < i))
					|| (inequalitySignArray[inequalitySignArrayIndex].equals(">") && (preNum > i)))) {
				
				visited[i] = true;
				resultArray[resultArrayIndex++] = i;
				
				recursionFunc(inequalitySignArray, inequalitySignArrayIndex + 1, i, cnt + 1);
				
				visited[i] = false;
				--resultArrayIndex;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		sc.nextLine();
		
		String[] inequalitySignArray = sc.nextLine().split(" ");
		
		sc.close();
		
		resultArray = new int[k + 1];
		
		for (int i = 0; i < 10; ++i) {
			resultArray[0] = i;
			visited[i] = true;
			
			recursionFunc(inequalitySignArray, 0, i, 0);
			
			visited[i] = false;
		}
		
		System.out.format("%s%s", answer.substring((answer.length() - 1) - (k + 1)), answer.substring(0, k + 1));
	}

}
