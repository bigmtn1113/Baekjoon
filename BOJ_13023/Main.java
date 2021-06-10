import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static boolean[] visited = new boolean[2001];
    
    public static void dfs(ArrayList<Integer>[] graph, int currPerson, int cnt) {
        if (cnt == 4) {
            System.out.print(1);
            System.exit(0);
        }
        
        for (int nextPerson : graph[currPerson]) {
            if (!visited[nextPerson]) {
                visited[nextPerson] = true;
                
                dfs(graph, nextPerson, cnt + 1);
                
                visited[nextPerson] = false;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        ArrayList<Integer>[] graph = new ArrayList[n];
        
        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; ++i) {
            int person1 = sc.nextInt();
            int person2 = sc.nextInt();
            
            graph[person1].add(person2);
            graph[person2].add(person1);
        }
        
        sc.close();
        
        // 친구와 친구 사이의 거리가 4인 것이 존재하는지를 찾는 문제이다.
        
        for (int i = 0; i < n; ++i) {
            visited[i] = true;
            
            dfs(graph, i, 0);
            
            visited[i] = false;
        }
        
        System.out.print(0);
    }

}
