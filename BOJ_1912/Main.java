import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] dp = new int[100001];
	static int[] arr = new int[100001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i)
			arr[i] = Integer.parseInt(st.nextToken());
		br.close();
		
		//	10 -4 3 1 5 6 -35 12 21 -1
		//	10  6 9 10 15 21 -14 12 33 32
		dp[0] = arr[0];
		int max = -Integer.MIN_VALUE;
		for (int i = 1; i < n; ++i) {
			dp[i] = Math.max(arr[i] + dp[i - 1], arr[i]);
			
			if (dp[i] > max)
				max = dp[i];
		}
		
		bw.write(String.valueOf(Math.max(max, dp[0])));
		bw.flush();
		bw.close();
	}
}