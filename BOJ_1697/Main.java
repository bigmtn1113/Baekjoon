import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int[] visit = new int[100001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		br.close();
		
		bfs(n, k);
		
		bw.write(String.valueOf(visit[k] - 1));
		bw.flush();
		bw.close();
	}
	
	static void bfs(int src, int dest) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(src);
		visit[src] = 1;
		
		int[] next = new int[3];
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			
			next[0] = curr - 1;
			next[1] = curr + 1;
			next[2] = curr * 2;
			
			for (int i : next) {
				if (i < 0 || i > 100000)
					continue;
				
				if (visit[i] == 0) {
					queue.offer(i);
					visit[i] = visit[curr] + 1;
				}
				
				if (i == dest)
					break;
			}
		}
	}
	
}
