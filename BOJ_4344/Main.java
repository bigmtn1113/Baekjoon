import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int c = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < c; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			float avg = 0;
			float cnt = 0;
			
			for (int j = 0; j < n; ++j) {
				arr[j] = Integer.parseInt(st.nextToken());
				avg += arr[j];
			}
			avg /= n;
			
			for (int j = 0; j < n; ++j)
				if (arr[j] > avg)
					++cnt;
			
			bw.write(String.format("%.3f", (cnt / n * 100)) + "%\n");
		}
		br.close();
		
		bw.flush();
		bw.close();
	}
}