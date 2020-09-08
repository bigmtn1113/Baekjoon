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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] a = new int[n];
		for (int i = 0; i < n; ++i)
			a[i] = Integer.parseInt(br.readLine());
		br.close();
		
		int cnt = 0;
		for (int i = n - 1; i >= 0; --i) {
			if (k >= a[i]) {
				cnt += k / a[i];
				k -= k / a[i] * a[i];
			}
			
			if (k == 0) break;
		}
		
		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
	}
}