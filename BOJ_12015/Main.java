import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] a = new int[1000001];
	static int[] resultSequence = new int[1000001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 결과 수열 = 가장 긴 증가하는 부분 수열이 저장되는 공간
		// 결과 수열의 최대값 = 마지막 인덱스 값
		
		// 숫자가 결과 수열의 최대값과 같으면 계산할 필요가 없으니 다음 숫자로 넘어간다.
		// 숫자가 결과 수열의 최대값보다 크면 결과 수열에 숫자를 추가한다.
		// 숫자가 결과 수열의 최대값보다 작으면 결과 수열에서 적절한 위치를 찾아 그 위치에 숫자를 추가한다.
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i)
			a[i] = Integer.parseInt(st.nextToken());
		br.close();
		
		int cnt = 0;
		resultSequence[0] = a[0];
		for (int i = 1; i < n; ++i) {
			if (resultSequence[cnt] == a[i]) continue;
			
			if (resultSequence[cnt] < a[i]) resultSequence[++cnt] = a[i];
			else resultSequence[lowerBound(0, cnt + 1, a[i])] = a[i];
		}
		
		bw.write(String.valueOf(cnt + 1));
		bw.flush();
		bw.close();
	}
	
	static int lowerBound(int begin, int end, int num) {
		int mid;
		
		while (begin < end) {
			mid = (begin + end) / 2;
			
			if (resultSequence[mid] < num) begin = mid + 1;
			else end = mid;
		}
		
		return end;
	}
	
}
