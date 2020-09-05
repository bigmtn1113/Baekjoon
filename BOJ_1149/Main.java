import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] dp = new int[1001][3];
	static int[][] home = new int[1001][3];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			home[i][0] = Integer.parseInt(st.nextToken());
			home[i][1] = Integer.parseInt(st.nextToken());
			home[i][2] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		dp[0][0] = home[0][0];
		dp[0][1] = home[0][1];
		dp[0][2] = home[0][2];
		
		for (int i = 1; i < n; ++i) {
			dp[i][0] = home[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] = home[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] = home[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
		}
		
		bw.write(String.valueOf(Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2])));
		bw.flush();
		bw.close();
	}
}