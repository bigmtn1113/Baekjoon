import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void recursionFunc(int[] array, int m, String s, int preIndex, int cnt) {
		if (cnt == m) {
			System.out.println(s);
			return;
		}
		
		for (int i = preIndex; i < array.length; ++i) {
			recursionFunc(array, m, s + array[i] + " ", i, cnt + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] array = new int[n];
		
		for (int i = 0; i < n; ++i) {
			array[i] = sc.nextInt();
		}
		
		sc.close();
		
		Arrays.sort(array);
		
		recursionFunc(array, m, "", 0, 0);
	}

}
