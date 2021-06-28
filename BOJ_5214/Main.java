import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int[] distance;
    
    public static int bfs(ArrayList<Integer>[] graph, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        
        distance[1] = 1;
        
        while (!queue.isEmpty()) {
            int currStation = queue.poll();
            
            if (currStation == n) {
                return distance[currStation];
            }
            
            for (int nextStation : graph[currStation]) {
                if (distance[nextStation] == 0) {
                    // 역이면 거리를 증가시켜야 하나, 하이퍼 튜브면 거리를 증가시키면 안된다.
                    distance[nextStation] = (nextStation <= n) ? distance[currStation] + 1 : distance[currStation];
                    queue.offer(nextStation);
                }
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();
        
        // 하이퍼 튜브도 graph에 연결하기 위해 하이퍼 튜브 개수(m)만큼 메모리를 더 할당해야 한다.
        ArrayList<Integer>[] graph = new ArrayList[n + 1 + m];
        
        for (int i = 1; i < graph.length; ++i) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 1; i <= m; ++i) {
            for (int j = 0; j < k; ++j) {
                int station = sc.nextInt();
                
                // 하이버 튜브와 역을 연결한다.
                // graph[1 ~ n]은 역, graph[n + 1 ~ ]는 하이퍼 튜브를 나타낸다.
                graph[n + i].add(station);
                graph[station].add(n + i);
            }
        }
        
        sc.close();
        
        // 모든 역끼리 연결하면 간선이 너무 많이 생겨 메모리 초과가 발생한다.
        // 그래서 하이퍼 튜브와 역들을 연결해 간선의 수를 줄여야 한다.
        // 역을 이동할 때 하이퍼 튜브를 통해 다른 역으로 가는 원리다.
        
        distance = new int[n + 1 + m];
        
        System.out.print(bfs(graph, n));
    }

}
