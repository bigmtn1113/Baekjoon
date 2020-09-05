import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int n;
	static int[] dp = new int[41];
	static int[][] cnt = new int[41][2]; 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		dp[0] = 0; dp[1] = 1;
		cnt[0][0] = 1; cnt[0][1] = 0; cnt[1][0] = 0; cnt[1][1] = 1;
		
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; ++i) {
			n = Integer.parseInt(br.readLine());
			fibonacci(n);
			
			bw.write(cnt[n][0] + " " + cnt[n][1] + "\n");
		}
		br.close();
		
		bw.flush();
		bw.close();
	}
	
	static int fibonacci(int num) {
		if (num == 0) return 0;
		if (num == 1) return 1; 
		if (dp[num] != 0) return dp[num];
		else {
			dp[num] = fibonacci(num - 1) + fibonacci(num - 2);
			cnt[num][0] = cnt[num - 1][0] + cnt[num - 2][0];
			cnt[num][1] = cnt[num - 1][1] + cnt[num - 2][1];
			return dp[num];
		}
	}
}