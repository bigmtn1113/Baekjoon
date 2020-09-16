import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
	int i;
	int j;
	
	Pair(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	int first() { return i; }
	int second() { return j; }
}

public class Main {
	static int[][] box = new int[1001][1001];
	static int[][] isVisit = new int[1001][1001];
	static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};	// 상, 하, 좌, 우
	static int m, n, minDate;
	
	static Queue<Pair> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		/*ex) 6 4
			1 -1 0 0 0 0
			0 -1 0 0 0 0
			0 0 0 0 -1 0
			0 0 0 0 -1 1
			
			1 -1 6 5 4 3
			1 -1 5 4 3 2
			2 3 4 5 -1 1
			3 4 5 6 -1 1
			
			익은 토마토 주변에 안 익은 토마토가 있어야 익는 것이 전파되니
			익은 토마토에서 탐색을 시작해야 한다.
		*/
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < m; ++j)
				box[i][j] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		int ripeTomatoCnt = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (box[i][j] == 1) {
					++ripeTomatoCnt;
					
					queue.offer(new Pair(i, j));
					isVisit[i][j] = 1;
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
				for (int i = 0; i < n; ++i)	// 익지 않은 토마토가 있는지 찾기
					for (int j = 0; j < m; ++j)
						if (isVisit[i][j] ==0 && box[i][j] == 0)
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
			queue.poll();
			
			for (int k = 0; k < 4; ++k) {
				int nextI = currI + direction[k][0];
				int nextJ = currJ + direction[k][1];
				
				if (nextI < 0 || nextI > n - 1 || nextJ < 0 || nextJ > m - 1)
					continue;
				
				if (box[nextI][nextJ] == 0 && isVisit[nextI][nextJ] == 0) {
					queue.offer(new Pair(nextI, nextJ));
					minDate = isVisit[nextI][nextJ] = isVisit[currI][currJ] + 1;	// 다음 방문할 정점은 현재 정점의 다음 칸이므로 현재 칸+1
				}
			}
		}
	}
	
}
