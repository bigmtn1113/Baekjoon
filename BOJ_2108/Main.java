import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		int avg = 0;
		int min = 4000;
		int max = -4000;
		
		for (int i = 0; i < n; ++i) {
			int num = Integer.parseInt(br.readLine());
			
			if (num < min) min = num;
			if (num > max) max = num;
			
			arr[i][0] = num;
			arr[i][1] = 1;
			avg += num;
		}
		br.close();
		
		avg = Math.round(avg/(float)n);
		bw.write(avg + "\n");
		
		Arrays.sort(arr, new Comparator<int[]>() {	// 2차원 배열 0번째 값을 기준으로 정렬
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		bw.write(arr[n / 2][0] + "\n");
		
		int maxFrequency = 0;
		int maxFrequencyIndex = 0;
		int cnt = 1;
		for (int i = 1; i < n; ++i) {
			if (arr[i][0] == arr[i - 1][0]) {
				++cnt;
				arr[i][1] = cnt; 
			} else {
				cnt = 1;
			}
			
			if (cnt > maxFrequency) {
				maxFrequency = cnt;
				maxFrequencyIndex = i;
			}
		}
		
		boolean isFind = false;
		boolean isSecond = false;
		for (int i = 0; i < n; ++i) {
			if (arr[i][1] == maxFrequency) {
				if (isFind) {
					bw.write(arr[i][0] + "\n");
					isSecond = true;
					break;
				} else {
					isFind = true;
				}
			}
		}
		
		if (!isSecond)
			bw.write(arr[maxFrequencyIndex][0] + "\n");
		
		int arrange = max - min;
		bw.write(arrange + "\n");
		
		bw.flush();
		bw.close();
	}
}