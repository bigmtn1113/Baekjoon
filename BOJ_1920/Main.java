import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr = new int[100001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr, 0, n);	// 이분탐색은 오름차순 정렬된 상태에서만 사용가능
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; ++i) {
			int num = Integer.parseInt(st.nextToken());
			
			if (num < arr[0] || num > arr[n - 1])	//숫자가 범위를 벗어난 값이면
				bw.write("0\n");
			else
				bw.write(binarySearch(0, n - 1, num) ? "1\n" : "0\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	static boolean binarySearch(int begin, int end, int num) {
		if (begin > end) return false;
		
		int mid = (begin + end) / 2;
		
		if (arr[mid] == num) return true;
		if (arr[mid] > num) return binarySearch(begin, mid - 1, num);
		return binarySearch(mid + 1, end, num);
	}
}
