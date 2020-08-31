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
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();
		
		int[] arr = new int[n];
		int maxNum = 0;
		
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			if (arr[i] > maxNum) maxNum = arr[i];
		}
		
		
		float sum = 0;
		for (int i = 0; i < n; ++i)
			sum += arr[i] / (float)maxNum * 100;
		
		bw.write(String.valueOf(sum / n));
		
		bw.flush();
		bw.close();
	}
}