import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int n, k;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 1 2 3
		// 2 4 6
		// 3 6 9
		// => 1 2 2 3 3 4 6 6 9
		
		// k번째 수는 k보다 항상 작거나 같다.
		// k보다 같거나 작은 수를 세려면 k를 각 행으로 나눈 값과 n중 더 작은 값을 더하면 된다.
		
		// ex) n = 3, k = 7
		// 7보다 작거나 같은 수는 3(1 2 3) + 3(2 4 6) + 2(3 6) = 8개
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		br.close();
		
		bw.write(String.valueOf(parametricSearch(1, k)));
		bw.flush();
		bw.close();
	}
	
	static int parametricSearch(int begin, int end) {
		int mid;
		int result = 0;
		
		while (begin <= end) {
			int cnt = 0;
			mid = (begin + end) / 2;
			
			for (int i = 1; i <= n; ++i)
				cnt += Math.min(mid / i, n);
			
			if (cnt < k) begin = mid + 1;
			else { result = mid; end = mid - 1; }
		}
		
		return result;
	}
	
}
