import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] dp = new int[101][100001];
	static int[][] wv = new int[101][2];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= n; ++i) {
			st = new StringTokenizer(br.readLine());
			wv[i][0] = Integer.parseInt(st.nextToken());
			wv[i][1] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		// 가방 무게(k)를 1부터 n까지 늘려가면서 최대한 가치있게 물건을 담을 수 있는 경우를 계산
		// 			w 0 1 2 3 4 5 6 7
		// 			  0 0 0 0 0 0 0 0
		// 6, 13	1 0 0 0 0 0 0 13 13
		// 4, 8		2 0 0 0 0 8 8 13 13
		// 3, 6		3 0 0 0 6 8 8 13 14
		// 5, 12	4 0 0 0 6 8 12 13 14
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <=k; ++j) {
				if (j >= wv[i][0])
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wv[i][0]] + wv[i][1]);
				else
					dp[i][j] = dp[i - 1][j];
			}
		}
		
		bw.write(String.valueOf(dp[n][k]));
		bw.flush();
		bw.close();
	}
}