import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// 브루트포스와 백트래킹을 이용하지 않는 방법
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] aArray = new int[n];
		
		for (int i = 0; i < n; ++i) {
			aArray[i] = sc.nextInt();
		}
		
		sc.close();
		
		Arrays.sort(aArray);
		
		int[] array = new int[n];
		int arrayIndex = 0;
		
		if (n % 2 == 0) {
			array[arrayIndex++] = aArray[n / 2];
			
			for (int i = 0; i < n / 2 - 1; ++i) {
				array[arrayIndex++] = aArray[i];
				array[arrayIndex++] = aArray[n - 1 - i];
			}
			
			array[arrayIndex] = aArray[n / 2 - 1];
		} else {
			if ((aArray[n / 2] - aArray[0]) > (aArray[n / 2 + 1] - aArray[n / 2])) {
				array[arrayIndex++] = aArray[n / 2];
			} else {
				array[n - 1] = aArray[n / 2];
			}
			
			for (int i = 0; i < n / 2; ++i) {
				array[arrayIndex++] = aArray[i];
				array[arrayIndex++] = aArray[n - 1 - i];
			}
		}
		
		int answer = 0;
		
		for (int i = 1; i < n; ++i) {
			answer += Math.abs(array[i] - array[i - 1]);
		}
		
		System.out.print(answer);
	}

}
