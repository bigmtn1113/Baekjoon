import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int n;
	static int[] dp = new int[1000001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		dp[1] = 1;
		dp[2] = 2;
		
		n = Integer.parseInt(br.readLine());
		br.close();
		
		bw.write(String.valueOf(makeTile(n)));
		bw.flush();
		bw.close();
	}
	
	static int makeTile(int num) {
		if (num == 1) return 1;
		if (num == 2) return 2; 
		if (dp[num] != 0) return dp[num];
		else return dp[num] = (makeTile(num - 1) + makeTile(num - 2)) % 15746;
	}
}