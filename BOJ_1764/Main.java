import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static boolean binarySearch(String[] cantListen, String target, int begin, int end) {
		while (begin <= end) {
			int mid = (begin + end) / 2;
			
			if (cantListen[mid].equals(target)) {
				return true;
			} else if (cantListen[mid].compareTo(target) < 0) {
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
		int m = sc.nextInt();
		
		String[] cantListen = new String[n];
		
		for (int i = 0; i < n; ++i) {
			cantListen[i] = sc.next();
		}
		
		Arrays.sort(cantListen);
		
		ArrayList<String> list = new ArrayList<>();
		
		int cnt = 0;
		
		for (int i = 0; i < m; ++i) {
			String cantSee = sc.next();
			
			boolean find = binarySearch(cantListen, cantSee, 0, n - 1);
			
			if (find) {
				list.add(cantSee);
				++cnt;
			}
		}
		
		sc.close();
		
		Collections.sort(list);
		
		StringBuilder answer = new StringBuilder();
		
		for (String s : list) {
			answer.append(s).append("\n");
		}
		
		System.out.print(cnt + "\n" + answer);
	}
	
}
