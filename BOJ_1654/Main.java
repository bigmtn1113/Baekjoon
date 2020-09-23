import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] arr = new int[10001];
	static int k, n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// parametric search
		// binary search와 비슷하다.
		// binary search는 [조건]을 만족하는 값을 찾아라라면
		// parametric search는 [조건]을 만족하는 값 중에서 최적값(최대값, 최소값 같은 값)을 찾아라라고 할 수 있다.
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		int maxLanCableLength = 0;
		for (int i = 0; i < k; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
			
			if (arr[i] > maxLanCableLength)
				maxLanCableLength = arr[i];
		}
		
		bw.write(String.valueOf(parametricSearch(0, maxLanCableLength)));
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	static long parametricSearch(long begin, long end) {
		long mid;
		long result = 1;
		int cnt;
		
		while (begin <= end) {
			mid = (begin + end) / 2;
			cnt = 0;
			
			if (mid > 0)	// 0으로 나누면 안되므로
				for (int i = 0; i < k; ++i)
					cnt += arr[i] / mid;
			
			if (cnt >= n) { result = mid; begin = mid + 1; }
			else end = mid - 1;
		}
		
		return result;
	}
	
}
