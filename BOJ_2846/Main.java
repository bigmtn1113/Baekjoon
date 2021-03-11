import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] heights = new int[n];
		
		for (int i = 0; i < n; ++i) {
			heights[i] = sc.nextInt();
		}
		
		sc.close();
		
		int maxSizeofUphill = 0;
		int min = heights[0];
		
		for (int i = 1; i < n; ++i) {
			if (heights[i] > heights[i - 1]) {
				min = Math.min(min, heights[i - 1]);
			} else {
				maxSizeofUphill = Math.max(maxSizeofUphill, heights[i - 1] - min);
				min = heights[i];
			}
		}
		
		System.out.print(Math.max(maxSizeofUphill, heights[n - 1] - min));
	}
	
}
