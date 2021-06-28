import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static boolean[] visited;
    
    public static boolean canMakeTree(ArrayList<Integer>[] graph, int parentVertex, int vertex) {
        // dfs 탐색
        visited[vertex] = true;
        
        for (int nextVertex : graph[vertex]) {
            if (nextVertex == parentVertex) {
                continue;
            }
            
            // tree는 cycle이 존재할 수 없으므로 false
            if (visited[nextVertex]) {
                return false;
            }
            
            if (!canMakeTree(graph, vertex, nextVertex)) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        StringBuffer answer = new StringBuffer("");
        
        int tc = 1;
        
        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            if ((n == 0) && (m == 0)) {
                break;
            }
            
            ArrayList<Integer>[] graph = new ArrayList[n + 1];
            visited = new boolean[n + 1];
            
            for (int i = 1; i <= n; ++i) {
                graph[i] = new ArrayList<>();
            }
            
            for (int i = 0; i < m; ++i) {
                int vertex1 = sc.nextInt();
                int vertex2 = sc.nextInt();
                
                graph[vertex1].add(vertex2);
                graph[vertex2].add(vertex1);
            }
            
            int cnt = 0;
            
            for (int i = 1; i <= n; ++i) {
                if (!visited[i] && canMakeTree(graph, 0, i)) {
                    ++cnt;
                }
            }
            
            answer.append("Case ").append(tc).append(": ");
            
            if (cnt > 1) {
                answer.append("A forest of ").append(cnt).append(" trees.").append("\n");
            } else if (cnt == 1) {
                answer.append("There is one tree.").append("\n");
            } else {
                answer.append("No trees.").append("\n");
            }
            
            ++tc;
        }
        
        sc.close();
        
        System.out.print(answer);
    }

}
