import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] str1 = sc.next().toCharArray();
		char[] str2 = sc.next().toCharArray();
		
		sc.close();
		
		String[][] dp = new String[str1.length + 1][str2.length + 1];
		
		for (String[] row : dp) {
			Arrays.fill(row, "");
		}
		
		for (int i = 1; i <= str1.length; ++i) {
			for (int j = 1; j <= str2.length; ++j) {
				if (str1[i - 1] == str2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + str1[i - 1];
					continue;
				}
				
				dp[i][j] = (dp[i - 1][j].length() > dp[i][j - 1].length()) ? dp[i - 1][j] : dp[i][j - 1];
			}
		}
		
		System.out.format("%d\n%s", dp[str1.length][str2.length].length(), dp[str1.length][str2.length]);
	}

}
