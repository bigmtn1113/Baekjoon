import java.util.Scanner;

public class Main {
	public static boolean[] canPressChannel = new boolean[10];
	public static int answer = Integer.MAX_VALUE;
	
	public static void makeChannel(int n, int nLength, String s) {
		if (s.length() == nLength) {
			answer = Math.min(answer, nLength + Math.abs(n - Integer.parseInt(s)));
			return;
		}
		
		for (int i = 0; i < 10; ++i) {
			if (!canPressChannel[i]) {
				makeChannel(n, nLength, s + i);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		for (int i = 0; i < m; ++i) {
			canPressChannel[sc.nextInt()] = true;
		}
		
		sc.close();
		
		int nLength = (n > 0) ? (int) Math.log10(n) + 1 : 1;
		
		for (int i = 1; i <= nLength + 1; ++i) {
			makeChannel(n, i, "");
		}
		
		answer = Math.min(answer, Math.abs(n - 100));
		
		System.out.print(answer);
	}

}
