import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static int n;
	static int[][] dp = new int[101][10];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		br.close();
		
		int mod = 1000000000;
		
		Arrays.fill(dp[1], 1, 10, 1);
		for (int i = 2; i <= n; ++i) {
			for (int j = 0; j < 10; ++j) {	// dp[i][j] = 숫자 길이가 i고 중 맨 끝자리가 j인 것 
				if (j == 0) 
					dp[i][0] = dp[i - 1][1];	// ex) 0 = 1 - 1
				else if (j == 9) 
					dp[i][9] = dp[i - 1][8];	// ex) 9 = 8 + 1
				else 
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;	// ex) 4 = 3 + 1, 5 - 1
			}
		}
		
		int sum = 0;
		for (int i = 0; i < 10; ++i)
			sum = (sum + dp[n][i]) % mod; 
		
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
	}
}