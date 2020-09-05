import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] dp = new int[501][501];
	static int[][] num = new int[501][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num[i] = new int[i + 1];
			
			for (int j = 0; j <= i; ++j)
				num[i][j] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		dp[0][0] = num[0][0];
		for (int i = 0; i < n - 1; ++i) {
			for (int j = 0; j <= i; ++j) {
				dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + num[i + 1][j]);
				dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + num[i + 1][j + 1]);
			}
		}
		
		int max = 0;
		for (int i = 0; i < n; ++i)
			if (dp[n - 1][i] > max)
				max = dp[n - 1][i];
		
		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}
}