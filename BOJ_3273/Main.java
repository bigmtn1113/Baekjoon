import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static boolean binarySearch(int[] array, int target, int begin, int end, boolean[] visited) {
		while (begin <= end) {
			int mid = (begin + end) / 2;
			
			if (array[mid] == target) {
				if (visited[mid]) {
					return false;
				}
				
				visited[mid] = true;
				return true;
			} else if (array[mid] < target) {
				begin = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] array = new int[n];
		
		for (int i = 0; i < n; ++i) {
			array[i] = sc.nextInt();
		}
		
		int x = sc.nextInt();
		
		sc.close();
		
		Arrays.sort(array);
		
		boolean[] visited = new boolean[n];
		
		int answer = 0;
		
		for (int i = 0; i < n; ++i) {
			if (visited[i]) {
				continue;
			}
			
			visited[i] = true;
			
			if (binarySearch(array, x - array[i], 0, n - 1, visited)) {
				++answer;
			}
		}
		
		System.out.print(answer);
	}

}
