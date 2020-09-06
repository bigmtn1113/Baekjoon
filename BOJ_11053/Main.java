import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] dp = new int[1001];
	static int[] arr = new int[1001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i)
			arr[i] = Integer.parseInt(st.nextToken());
		br.close();
		
		for (int i = 0; i < n; ++i) {
			dp[i] = 1;
			
			for (int j = 0; j < i; ++j)
				if (arr[i] > arr[j] && dp[j] + 1 > dp[i])
					dp[i] = dp[j] + 1;
		}
		
		int max = 0;
		for (int i = 0; i < n; ++i)
			if (dp[i] > max)
				max = dp[i];
		
		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}
}