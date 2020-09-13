import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] vertex = new ArrayList[1001];
	static boolean[] isVisit = new boolean[1001];
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= n; ++i)
			vertex[i] = new ArrayList<>();
		
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			vertex[v1].add(v2);
			vertex[v2].add(v1);
		}
		br.close();
		
		for (int i = 1; i <= n; ++i)
			Collections.sort(vertex[i]);
		
		dfs(v);
		bw.newLine();
		for (int i = 1; i <= n; ++i)
			isVisit[i] = false;
		bfs(v);
        
		bw.flush();
		bw.close();
	}
	
	static void dfs(int v) throws IOException {
		// ���̿켱Ž��
		// �а� Ž������ �ʰ� ��� Ž����
		
		// ex)
		// Dfs(1)	->	adjacent_vertex[1] = 2, 3, 4	->	2 �湮
		// Dfs(2)	->	adjacent_vertex[2] = 1, 4		->	1�� �̹� �湮������ 4 �湮
		// Dfs(4)	->	adjacent_vertex[4] = 1, 2, 3	->	1, 2�� �̹� �湮������ 3 �湮
		// Dfs(3)	->	adjacent_vertex[3] = 1, 4		->	1, 4�� �̹� �湮������ ����
		// ���: 1 2 4 3
		
		if (isVisit[v]) return;
		
		isVisit[v] = true;
		bw.write(v + " ");
		
		for (int i : vertex[v])
			if (!isVisit[i])
				dfs(i);
	}
	
	static void bfs(int v) throws IOException{
		// �ʺ�켱Ž��
		// ��� Ž������ �ʰ� �а� Ž����

		// ex)
		// Bfs(1)	->	adjacent_vertex[1] = 2, 3, 4	->	1�� �湮������ ť���� ������ 2, 3, 4�� ť�� ����
		// Bfs(2)	->	adjacent_vertex[2] = 1, 4		->	2�� �湮������ ť���� ������ 1�� �̹� �湮�߰� 4�� ť�� ������ �н�
		// Bfs(3)	->	adjacent_vertex[3] = 1, 4		->	3�� �湮������ ť���� ������ 1�� �̹� �湮�߰� 4�� ť�� ������ �н�
		// Bfs(4)	->	adjacent_vertex[4] = 1, 2, 3	->	4�� �湮������ ť���� ������ 1, 2, 3�� �湮������ ����
		// ���: 1 2 3 4
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		isVisit[v] = true;
		
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			bw.write(curr + " ");
			
			for (int i : vertex[curr]) {
				if (!isVisit[i]) {
					queue.offer(i);
					isVisit[i] = true;
				}
			}
		}
	}
}