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
		
		// 1: 1
		// 2 ~ 7(6): 2
		// 8 ~ 19(12): 3
		// 20 ~ 37(18): 4
		// 38 ~ 61(24): 5
		
		int from = 1;
		int to = 1;
		int room = 1;
		
		while (true) {
			if (from <= n && n <= to) break;
			
			from = to + 1;
			to += room * 6;
			++room;
		}
		
		bw.write(String.valueOf(room));
		bw.flush();
		bw.close();
	}
}