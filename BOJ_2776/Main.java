// 이분 탐색 풀이
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static boolean binarySearch(int[] note, int target, int begin, int end) {
		while (begin <= end) {
			int mid = (begin + end) / 2;
			
			if (note[mid] == target) {
				return true;
			} else if (note[mid] < target) {
				begin = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int n = sc.nextInt();
			
			int[] note = new int[n];
			
			for (int j = 0; j < n; ++j) {
				note[j] = sc.nextInt();
			}
			
			Arrays.sort(note);
			
			int m = sc.nextInt();
			
			for (int j = 0; j < m; ++j) {
				answer.append((binarySearch(note, sc.nextInt(), 0, n - 1)) ? "1" : "0").append("\n");
			}
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}

/*
// Set 풀이
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int n = sc.nextInt();
			
			HashSet<Integer> set = new HashSet<>();
			
			for (int j = 0; j < n; ++j) {
				set.add(sc.nextInt());
			}
			
			int m = sc.nextInt();
			
			for (int j = 0; j < m; ++j) {
				answer.append((set.contains(sc.nextInt())) ? "1" : "0").append("\n");
			}
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
*/
