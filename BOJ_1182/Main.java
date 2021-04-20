import java.util.Scanner;

public class Main {
	public static int[] resultArray;
	public static int resultArrayIndex = 0;
	public static int answer = 0;
	
	public static void recursionFunc(int[] array, int elementCnt, int s, int preIndex, int cnt) {
		if (cnt == elementCnt) {
			int sum = 0;
			
			for (int i = 0; i < resultArrayIndex; ++i) {
				sum += resultArray[i];
			}
			
			if (sum == s) {
				++answer;
			}
			
			return;
		}
		
		for (int i = 0; i < array.length; ++i) {
			if (i > preIndex) {
				resultArray[resultArrayIndex++] = array[i];
				
				recursionFunc(array, elementCnt, s, i, cnt + 1);
				
				--resultArrayIndex;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int s = sc.nextInt();
		
		int[] array = new int[n];
		
		for (int i = 0; i < n; ++i) {
			array[i] = sc.nextInt();
		}
		
		sc.close();
		
		resultArray = new int[n];
		
		for (int elementCnt = 1; elementCnt <= n; ++elementCnt) {
			recursionFunc(array, elementCnt, s, -1, 0);
		}
		
		System.out.print(answer);
	}

}
