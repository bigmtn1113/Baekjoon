import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		br.close();
		
		int minSum = 5000;
		
		for (int i = 0; i <= n / 5; ++i) {
			for (int j = 0; j <= n / 3; ++j) {
				int sum = 5 * i + 3 * j;
				
				if (sum == n) {
					if (i + j < minSum)
						minSum = i + j;
				}
				else if (sum > n)
					break;
			}
		}
		
		if (minSum == 5000) bw.write("-1");
		else bw.write(String.valueOf(minSum));
		
		bw.flush();
		bw.close();
	}
}