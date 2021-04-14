import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] array = new int[n];
		
		for (int i = 0; i < n; ++i) {
			array[i] = sc.nextInt();
		}
		
		sc.close();
		
		int changeNumIndex = 0;
		boolean check = false;
		
		for (int i = n - 1; i > 0; --i) {
			if (array[i - 1] > array[i]) {
				changeNumIndex = i - 1;
				check = true;
				break;
			}
		}
		
		if (!check) {
			System.out.print(-1);
			System.exit(0);
		}
		
		Integer[] descendingArray = new Integer[n - (changeNumIndex + 1)];
		
		for (int i = 0; i < descendingArray.length; ++i) {
			descendingArray[i] = array[changeNumIndex + 1 + i];
		}
		
		Arrays.sort(descendingArray, Collections.reverseOrder());
		
		for (int j = 0; j < descendingArray.length; ++j) {
			array[changeNumIndex + 1 + j] = descendingArray[j];
		}
		
		for (int j = changeNumIndex + 1; j < n; ++j) {
			if (array[changeNumIndex] > array[j]) {
				int temp = array[changeNumIndex];
				array[changeNumIndex] = array[j];
				array[j] = temp;
				
				break;
			}
		}
		
		StringBuilder answer =  new StringBuilder();
		
		for (int i : array) {
			answer.append(i).append(" ");
		}
		
		System.out.print(answer);
	}

}
