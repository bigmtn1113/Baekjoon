import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] dp = new int[1001][2];
	static int[] arr = new int[1001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i)
			arr[i] = Integer.parseInt(st.nextToken());
		br.close();
		
		
		for (int i = 0; i < n; ++i)
			dp[i][0] = dp[i][1] = 1;
		
		for (int i = 0; i < n; ++i) {			
			for (int j = 0; j < i; ++j) {
				// dp[i][0] = 앞에서 부터 가장 긴 증가하는 수열 찾기
				// dp[i][1] = 뒤에서 부터 가장 긴 감소하는 수열 찾기
				if (arr[i] > arr[j] && dp[j][0] + 1 > dp[i][0])
					dp[i][0] = dp[j][0] + 1;
				if (arr[n - 1 - i] > arr[n - 1 - j] && dp[n - 1 - j][1] + 1 > dp[n - 1 - i][1])
					dp[n - 1 - i][1] = dp[n - 1 - j][1] + 1;
			}
		}
		
		int max = 0;
		for (int i = 0; i < n; ++i)
			if (dp[i][0] + dp[i][1] > max)
				max = dp[i][0] + dp[i][1];
		
		bw.write(String.valueOf(max - 1));
		bw.flush();
		bw.close();
	}
}