import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[][] time = new int[n][2];
		
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());	// 시작 시간
			time[i][1] = Integer.parseInt(st.nextToken());	// 끝나는 시간
		}
		br.close();
		
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) 
					return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});
		
		int cnt = 1;
		int endTime = time[0][1];
		for (int i = 1; i < n; ++i) {
			if (time[i][0] >= endTime) {	// 끝나는 시간보다 다음 시작시간이 커야 회의 가능
				++cnt;
				endTime = time[i][1];
			}
		}
		
		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
	}
}