import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static char[][] vertex = new char[27][2];	// 이진 트리이므로 자식이 2개
	static boolean[] isVisit = new boolean[27];
	static ArrayList<Character>[] order = new ArrayList[3];	// 전위 순회, 중위 순회, 후위 순회 결과 저장
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 전위 순회: dfs로 탐색할 때 가장 먼저 방문하는 노드순으로 저장
		// 중위 순회: dfs로 탐색할 때 노드에 방문한 뒤 왼쪽 노드 탐색 후 현재 노드 저장
		// 후위 순회: dfs로 탐색할 때 노드에 방문한 뒤 왼쪽, 오른쪽 노드 탐색 후 현재 노드 저장
		
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < 3; ++i)
			order[i] = new ArrayList<>();
		
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			char v1 = st.nextToken().charAt(0);
			char v2 = st.nextToken().charAt(0);
			char v3 = st.nextToken().charAt(0);
			
			vertex[v1 - 'A'][0] = v2;
			vertex[v1 - 'A'][1] = v3;
		}
		br.close();
		
		dfs('A');	// 시작 노드를 지정하고 탐색
				
		for (char v : order[0]) bw.write(v); bw.newLine();
		for (char v : order[1]) bw.write(v); bw.newLine();
		for (char v : order[2]) bw.write(v);
		
		bw.flush();
		bw.close();
	}
	
	static void dfs(char v) {
		isVisit[v - 'A'] = true;
				
		char leftV = vertex[v - 'A'][0];
		char rightV = vertex[v - 'A'][1];
		
		order[0].add(v);	// 전위 순회
		if (leftV != '.' && !isVisit[leftV - 'A']) dfs(leftV); order[1].add(v);	// 중위 순회
		if (rightV != '.' && !isVisit[rightV - 'A']) dfs(rightV); order[2].add(v);	// 후위 순회
	}
}
