import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr = new int[500001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 같은 숫자카드가 여러 개일 경우
		// 카드 개수 = 카드숫자보다 큰 숫자가 나오는 첫 인덱스 - 카드숫자가 나오는 첫 인덱스
		// ex)
		// -10 -10 2 3 3 6 7 10 10 10 일때 3의 개수는?
		// 카드 개수(2) = 카드숫자보다 큰 숫자가 나오는 첫 인덱스(5) - 카드숫자가 나오는 첫 인덱스(3)
		
		// upperBound = 찾고자 하는 숫자보다 큰 값이 나오는 첫 인덱스
		// lowerBound = 찾고자 하는 숫자가 나오는 첫 인덱스
		// 범위 = [시작, 끝)
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr, 0, n);	// 이분탐색은 오름차순 정렬된 상태에서만 사용가능
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; ++i) {
			int num = Integer.parseInt(st.nextToken());
			int cnt = 0;
			
			if (!(num < arr[0] || num > arr[n - 1]))	//숫자가 범위를 벗어난 값이면
				cnt = upperBound(0, n, num) - lowerBound(0, n, num);
			
			bw.write(cnt + " ");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	static int upperBound(int begin, int end, int num) {
		int mid;
		
		while (begin < end) {
			mid = (begin + end) / 2;
			
			if (arr[mid] <= num) begin = mid + 1;
			else end = mid;
		}
		
		return end;
	}
	
	static int lowerBound(int begin, int end, int num) {
		int mid;
		
		while (begin < end) {
			mid = (begin + end) / 2;
			
			if (arr[mid] < num) begin = mid + 1;
			else end = mid;
		}
		
		return end;
	}
}
