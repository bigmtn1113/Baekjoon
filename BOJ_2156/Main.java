import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int n;
	static int[] dp = new int[10001];
	static int[] wine = new int[10001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; ++i)
			wine[i] = Integer.parseInt(br.readLine());
		br.close();
		
		dp[0] = wine[0];
		dp[1] = wine[0] + wine[1];
		dp[2] = Math.max(Math.max(wine[0] + wine[2], wine[1] + wine[2]), dp[1]);	// dp[1]: 와인을 지금 먹지 않은 경우
		for (int i = 3; i < n; ++i)	
			dp[i] = Math.max(Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]), dp[i - 1]);
		
		bw.write(String.valueOf(dp[n - 1]));
		bw.flush();
		bw.close();
	}
}