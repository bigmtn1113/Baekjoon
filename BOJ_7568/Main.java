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
		
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		int[] rank = new int[n];
		Arrays.fill(rank, 1);
		for (int i = 0; i < n; ++i)
			for (int j = 0; j < n; ++j)
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1])
					++rank[i];
		
		for (int i = 0; i < n; ++i)
			bw.write(rank[i] + " ");
		
		bw.flush();
		bw.close();
	}
}