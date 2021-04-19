import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// Scanner로 통과 못해서 버퍼 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int[][] groundArray = new int[n][m];
		
		int maxHeight = 0;
		int minHeight = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < m; ++j) {
				groundArray[i][j] = Integer.parseInt(st.nextToken());
				
				maxHeight = Math.max(maxHeight, groundArray[i][j]);
				minHeight = Math.min(minHeight, groundArray[i][j]);
			}
		}
		
		br.close();
		
		int resultTime = Integer.MAX_VALUE;
		int resultHeight = 0;
		
		while (maxHeight >= minHeight) {
			int time = 0;
			int tempB = b;
			
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < m; ++j) {
					if (groundArray[i][j] == maxHeight) {
						continue;
					}
					
					if (groundArray[i][j] > maxHeight) {
						time += (groundArray[i][j] - maxHeight) * 2;
						tempB += (groundArray[i][j] - maxHeight);
					} else {
						time += maxHeight - groundArray[i][j];
						tempB -= maxHeight - groundArray[i][j];
					}
				}
			}
			
			if ((tempB >= 0) && (resultTime > time)) {
				resultTime = time;
				resultHeight = maxHeight;
			}
			
			--maxHeight;
		}
		
		System.out.print(resultTime + " " + resultHeight);
	}

}
