import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] array = new int[n];
		
		for (int i = 0; i < n; ++i) {
			array[i] = sc.nextInt();
		}
		
		sc.close();
		
		long sum = 0;
		
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				sum += Math.abs(array[j] - array[i]);
			}
		}
		
		System.out.print(sum * 2);
	}
	
}
