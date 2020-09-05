import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int n;
	static int[] dp = new int[1000001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		br.close();
		
		for (int i = 2; i <= n; ++i) {
			if (i % 2 == 0 && i % 3 == 0) dp[i] = Math.min(Math.min(dp[i / 3], dp[i / 2]), dp[i - 1]) + 1;
			else if (i % 3 == 0 && i % 2 != 0) dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
			else if (i % 2 == 0 && i % 3 != 0) dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
			else if (i % 2 != 0 && i % 3 != 0) dp[i] = dp[i - 1] + 1;
		}
		
		bw.write(String.valueOf(dp[n]));
		bw.flush();
		bw.close();
	}
}