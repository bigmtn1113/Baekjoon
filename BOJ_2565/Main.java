import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] dp;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		dp = new int[n];
		arr = new int[n][2];
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		// 없애야 하는 최소 전깃줄 == 전체 전깃줄 - 안 겹치는 최대 전깃줄
		int max = 0;
		for (int i = 0; i < n; ++i) {
			dp[i] = 1;
			
			for (int j = 0; j < i; ++j)
				if (arr[i][1] > arr[j][1] && dp[j] + 1 > dp[i])
					dp[i] = dp[j] + 1;
			
			if (dp[i] > max)
				max = dp[i];
		}
		
		bw.write(String.valueOf(n - max));
		bw.flush();
		bw.close();
	}
}