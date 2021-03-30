package baekjoon;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// 이미 정렬된 배열을 이용하는 방법
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] a = new int[n];
		int[] b = new int[m];
		
		for (int i = 0; i < n; ++i) {
			a[i] = sc.nextInt();
		}
		
		for (int i = 0; i < m; ++i) {
			b[i] = sc.nextInt();
		}
		
		sc.close();
		
		int aIndex = 0;
		int bIndex = 0;
		
		int[] resultArray = new int[n + m];
		int resultArrayIndex = 0;
		
		while (true) {
			if (a[aIndex] < b[bIndex]) {
				resultArray[resultArrayIndex++] = a[aIndex++];
			} else {
				resultArray[resultArrayIndex++] = b[bIndex++];
			}
			
			if ((aIndex == n) || (bIndex == m)) {
				break;
			}
		}
		
		while (aIndex < n) {
			resultArray[resultArrayIndex++] = a[aIndex++];
		}
		
		while (bIndex < m) {
			resultArray[resultArrayIndex++] = b[bIndex++];
		}
		
		StringBuilder answer = new StringBuilder();
		
		for (int i : resultArray) {
			answer.append(i + " ");
		}
		
		System.out.print(answer);
    
    
		/* 단순 배열 정렬 방법
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] array = new int[n + m];

		for (int i = 0; i < n + m; ++i) {
			array[i] = sc.nextInt();
		}

		sc.close();

		Arrays.sort(array);

		StringBuilder answer = new StringBuilder();

		for (int i : array) {
			answer.append(i + " ");
		}

		System.out.print(answer);
		*/
	}
	
}
