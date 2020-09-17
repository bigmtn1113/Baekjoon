import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tuple {
	int i;
	int j;
	int k;
	
	Tuple(int i, int j, int k) {
		this.i = i;
		this.j = j;
		this.k = k;
	}
	
	int first() { return i; }
	int second() { return j; }
	int third() { return k; }
}

public class Main {
	static int[][][] box = new int[101][101][101];
	static int[][][] isVisit = new int[101][101][101];
	static int[][] direction = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};	// 위 상자, 아래 상자, 상, 하, 좌, 우
	static int m, n, h, minDate;
	
	static Queue<Tuple> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		/*ex) 5 3 2
			0 0 0 0 0
			0 0 0 0 0
			0 0 0 0 0
			0 0 0 0 0
			0 0 1 0 0
			0 0 0 0 0
			
			4 3 2 3 4
			3 2 1 2 3
			4 3 2 3 4
			3 2 1 2 3
			2 1 1 1 2
			3 2 1 2 3
			
			익은 토마토 주변에 안 익은 토마토가 있어야 익는 것이 전파되니
			익은 토마토에서 탐색을 시작해야 한다.
		*/
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < h; ++i) {
			for (int j = 0; j < n; ++j) {
				st = new StringTokenizer(br.readLine());
				
				for (int k = 0; k < m; ++k)
					box[i][j][k] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		
		int ripeTomatoCnt = 0;
		for (int i = 0; i < h; ++i) {
			for (int j = 0; j < n; ++j) {
				for (int k = 0; k < m; ++k) {
					if (box[i][j][k] == 1) {
						++ripeTomatoCnt;
						
						queue.offer(new Tuple(i, j, k));
						isVisit[i][j][k] = 1;
					}
				}
			}
		}
		
		if (ripeTomatoCnt == 0)	// 익은 토마토가 없으면 주변 토마토가 익는 것이 불가
			bw.write("-1");
		else {
			bfs();
			
			if (minDate == 0)	// 토마토가 이미 모두 익어 있었으면 minDate가 0
				bw.write("0");
			else {
				boolean existZero = false;
				for (int i = 0; i < h; ++i)	// 익지 않은 토마토가 있는지 찾기
					for (int j = 0; j < n; ++j)
						for (int k = 0; k < m; ++k)
							if (isVisit[i][j][k] == 0 && box[i][j][k] == 0)
								existZero = true;
				
				
				bw.write(existZero ? "-1" : String.valueOf(minDate - 1));
			}
		}
		bw.flush();
		bw.close();
	}
	
	static void bfs() {
		while (!queue.isEmpty()) {
			int currI = queue.peek().first();
			int currJ = queue.peek().second();
			int currK = queue.peek().third();
			queue.poll();
			
			for (int k = 0; k < 6; ++k) {
				int nextI = currI + direction[k][0];
				int nextJ = currJ + direction[k][1];
				int nextK = currK + direction[k][2];
				
				if (nextI < 0 || nextI > h - 1 || nextJ < 0 || nextJ > n - 1 || nextK < 0 || nextK > m - 1)
					continue;
				
				if (box[nextI][nextJ][nextK] == 0 && isVisit[nextI][nextJ][nextK] == 0) {
					queue.offer(new Tuple(nextI, nextJ, nextK));
					minDate = isVisit[nextI][nextJ][nextK] = isVisit[currI][currJ][currK] + 1;	// 다음 방문할 정점은 현재 정점의 다음 칸이므로 현재 칸+1
				}
			}
		}
	}
	
}
