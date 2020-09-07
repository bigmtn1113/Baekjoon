import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int n;
	static int[][] dp = new int[1001][1001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		br.close();
		
		//	  c a p c a k
		//	a 0 0 0 0 0 0 0
		//	c 0 0 1 1 1 1 1
		//	a 0 1 1 1 2 2 2
		//	y 0 1 2 2 2 3 3
		//	k 0 1 2 2 2 3 3
		//	p 0 1 2 2 2 3 4
		// 	  0 1 2 3 3 3 4
		
		for (int i = 1; i <= str1.length(); ++i) {
			for (int j = 1; j <= str2.length(); ++j) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		
		bw.write(String.valueOf(dp[str1.length()][str2.length()]));
		bw.flush();
		bw.close();
	}
}