import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] house = new int[200001];
	static int n, c;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// parametric search
		// binary search와 비슷하다.
		// binary search는 [조건]을 만족하는 값을 찾아라라면
		// parametric search는 [조건]을 만족하는 값 중에서 최적값(최대값, 최소값 같은 값)을 찾아라라고 할 수 있다.
		
		// 현재 집에서 특정 거리만큼 더해가면서 공유기를 설치했을 때 모두 설치가 가능하면
		// 특정 거리값을 저장하고 거리값을 증가시켜서 다시 설치해본다.
		// 이 과정을 반복해서 공유기를 모두 설치할 수 있는 최대 거리를 구한다.
		
		// 이때 현재 집에서 특정 거리만큼 더한 위치에 다음 집이 있어야 하므로
		// lowerBound를 통해 다음 집의 위치를 찾는다.
		
		// 최대 거리를 찾는 메소드	=> parametricSearch
		// 거리를 설정했을 때 모두 설치가 가능한 지 확인하는 메소드	=> canInstallation
		// 현재 위치에서 거리를 더했을 때의 집 위치를 찾는 메소드	=> lowerBound
		// 이 세 개의 메소드가 필요하다.
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; ++i)
			house[i] = Integer.parseInt(br.readLine());
		
		br.close();
		
		Arrays.sort(house, 0, n);
		
		bw.write(String.valueOf(parametricSearch(0, house[n - 1])));
		bw.flush();
		bw.close();
	}
	
	static int parametricSearch(int begin, int end) {
		int mid;
		int result = 0;
		
		while (begin <= end) {
			mid = (begin + end) / 2;
			
			if (canInstallation(mid)) { result = mid; begin = mid + 1; }	// 설치 가능하면 거리를 더 크게 설정
			else end = mid - 1;
		}
		
		return result;
	}
	
	static boolean canInstallation(int distance) {
		int routerCnt = 1;
		
		for (int i = house[0]; i <= house[n - 1]; ) {
			if (routerCnt == c) break;
			if (i + distance > house[n - 1]) return false;
			
			i = house[lowerBound(0, n, i + distance)];	// 현재 위치에서 거리를 더했을 때의 집 위치 찾기
			++routerCnt;
		}
		
		return true;
	}
	
	static int lowerBound(int begin, int end, int num) {
		int mid;
		
		while (begin < end) {
			mid = (begin + end) / 2;
			
			if (house[mid] < num) begin = mid + 1;
			else end = mid;
		}
		
		return end;
	}
}
