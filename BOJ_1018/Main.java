import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		char[][] chess = new char[n][m];
		for (int i = 0; i < n; ++i) {
			String row = br.readLine();
			
			for (int j = 0; j < m; ++j) {
				chess[i][j] = row.charAt(j);
			}
		}
		br.close();
		
		int min = n * m;
		for (int i= 0; i < n - 7; ++i) {
			for (int j = 0; j < m - 7; ++j) {
				int bCnt = 0;	// 체스판 가장 첫 번째 칸을 B로 가정했을 경우
				int wCnt = 0;	// 체스판 가장 첫 번째 칸을 W로 가정했을 경우
				int minCnt = n * m;
				
				for (int k = i; k < i + 8; ++k) {
					for (int l = j; l < j + 8; ++l) {
						if (k % 2 == 0 && l % 2 == 0 && chess[k][l] != 'B') ++bCnt;
						else if (k % 2 == 0 && l % 2 == 1 && chess[k][l] != 'W') ++bCnt;
						else if (k % 2 == 1 && l % 2 == 0 && chess[k][l] != 'W') ++bCnt;
						else if (k % 2 == 1 && l % 2 == 1 && chess[k][l] != 'B') ++bCnt;
					} 
				}
				
				for (int k = i; k < i + 8; ++k) {
					for (int l = j; l < j + 8; ++l) {
						if (k % 2 == 0 && l % 2 == 0 && chess[k][l] != 'W') ++wCnt;
						else if (k % 2 == 0 && l % 2 == 1 && chess[k][l] != 'B') ++wCnt;
						else if (k % 2 == 1 && l % 2 == 0 && chess[k][l] != 'B') ++wCnt;
						else if (k % 2 == 1 && l % 2 == 1 && chess[k][l] != 'W') ++wCnt;
					} 
				}
				
				minCnt = bCnt < wCnt ? bCnt : wCnt;
				if (minCnt < min) min = minCnt;
			}
		}
		
		bw.write(String.valueOf(min));
		bw.flush();
		bw.close();
	}
}