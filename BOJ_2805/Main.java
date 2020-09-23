import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] tree = new int[1000001];
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// parametric search
		// binary search와 비슷하다.
		// binary search는 [조건]을 만족하는 값을 찾아라라면
		// parametric search는 [조건]을 만족하는 값 중에서 최적값(최대값, 최소값 같은 값)을 찾아라라고 할 수 있다.
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int maxTree = 0;
		for (int i = 0; i < n; ++i) {
			tree[i] = Integer.parseInt(st.nextToken());
			
			if (tree[i] > maxTree)
				maxTree = tree[i];
		}
		
		bw.write(String.valueOf(parametricSearch(0, maxTree)));
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	static int parametricSearch(int begin, int end) {
		int mid;
		int result = 0;
		long sumTree;
		
		while (begin <= end) {
			mid = (begin + end) / 2;
			sumTree = 0;
			
			for (int i = 0; i < n; ++i)
				if (tree[i] > mid)
					sumTree += tree[i] - mid;
			
			if (sumTree >= m) { result = mid; begin = mid + 1; }
			else end = mid - 1;
		}
		
		return result;
	}
	
}
