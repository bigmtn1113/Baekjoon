import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	public static int[] subsequence;
	public static int subsequenceArrayIndex = 0;
	
	public static TreeSet<Integer> set = new TreeSet<>();
	
	public static void recursionFunc(int[] s, int subsequenceElementCnt, int preIndex, int cnt) {
		if (cnt == subsequenceElementCnt) {
			int sum = 0;
			
			for (int element : subsequence) {
				sum += element;
			}
			
			set.add(sum);
			return;
		}
		
		for (int i = preIndex + 1; i < s.length; ++i) {
			subsequence[subsequenceArrayIndex++] = s[i];
			
			recursionFunc(s, subsequenceElementCnt, i, cnt + 1);
			
			--subsequenceArrayIndex;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] s = new int[n];
		
		for (int i = 0; i < n; ++i) {
			s[i] = sc.nextInt();
		}
		
		sc.close();
		
		subsequence = new int[n];
		
		for (int subsequenceElementCnt = 1; subsequenceElementCnt <= n; ++subsequenceElementCnt) {
			recursionFunc(s, subsequenceElementCnt, -1, 0);
		}
		
		int answer = 1;
		
		for (int element : set) {
			if (element != answer) {
				break;
			}
			
			++answer;
		}
		
		System.out.print(answer);
	}

}
