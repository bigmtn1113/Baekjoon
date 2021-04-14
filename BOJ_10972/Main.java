import java.util.Arrays;
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
			if (array[i] > array[i - 1]) {
				changeNumIndex = i - 1;
				check = true;
				
				break;
			}
		}
		
		if (!check) {
			System.out.print(-1);
			System.exit(0);
		}
		
		for (int i = n - 1; i > changeNumIndex; --i) {
			if (array[i] > array[changeNumIndex]) {
				int temp = array[i];
				array[i] = array[changeNumIndex];
				array[changeNumIndex] = temp;
				
				break;
			}
		}
		
		Arrays.sort(array, changeNumIndex + 1, array.length);
		
		StringBuilder answer = new StringBuilder();
		
		for (int i : array) {
			answer.append(i).append(" ");
		}
		
		System.out.print(answer);
	}

}
