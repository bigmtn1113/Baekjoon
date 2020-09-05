import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int n;
	static int[] dp = new int[301];
	static int[] stair = new int[301];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; ++i)
			stair[i] = Integer.parseInt(br.readLine());
		br.close();
		
		dp[0] = stair[0];
		dp[1] = stair[0] + stair[1];
		dp[2] = Math.max(stair[0] + stair[2], stair[1] + stair[2]);
		
		for (int i = 3; i < n; ++i)
			dp[i] = Math.max(dp[i - 2] + stair[i], dp[i - 3] + stair[i - 1] + stair[i]);
		
		bw.write(String.valueOf(dp[n - 1]));
		bw.flush();
		bw.close();
	}
}