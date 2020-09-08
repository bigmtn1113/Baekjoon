import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] p = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i)
			p[i] = Integer.parseInt(st.nextToken());
		br.close();
		
		Arrays.sort(p);
		
		int sum = 0;
		int temp = 0;
		for (int i = 0; i < n; ++i) {
			temp += p[i];
			sum += temp;
		}
		
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
	}
}