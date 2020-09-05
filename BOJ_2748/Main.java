import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int n;
	static long[] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		br.close();
		
		dp = new long[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		
		bw.write(String.valueOf(fibonacci(n)));
		bw.flush();
		bw.close();
	}
	
	static long fibonacci(int num) {
		if (dp[num] != 0 || num == 0) return dp[num];
		else return dp[num] = fibonacci(num - 1) + fibonacci(num - 2);
	}
}