import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int n;
	static long[] dp = new long[101];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		dp[1] = dp[2] = dp[3] = 1;
		dp[4] = dp[5] = 2;
		
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; ++i) {
			n = Integer.parseInt(br.readLine());
			bw.write(padovan(n) + "\n");
		}
		br.close();
		
		bw.flush();
		bw.close();
	}
	
	static long padovan(int num) {
		if (num == 1 || num == 2 || num == 3) return 1;
		if (num == 4 || num == 5) return 2; 
		if (dp[num] != 0) return dp[num];
		else return dp[num] = padovan(num - 1) + padovan(num - 5);
	}
}