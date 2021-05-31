import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int checkSafetyZone(int[] map) {
        int cnt = 0;
        
        for (int i : map) {
            if (i == 0) {
                ++cnt;
            }
        }
        
        return cnt;
    }
    
    public static void bfs(int[] map, int m, ArrayList<Integer> virusLocationList) {
        Queue<Integer> queue = new LinkedList<>();
        
        for (int virusLocation : virusLocationList) {        // 바이러스가 있는 곳에서 탐색시작
            queue.offer(virusLocation);
        }
        
        int[] directions = {-m, m, -1, 1};        // 1차원 배열 기준으로 상, 하, 좌, 우
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            
            for (int direction : directions) {
                int next = curr + direction;
                
                // k행 1열에서 k - 1행 m열에 접근하거나 k행 m열에서 k + 1행 1열에 접근할 수 없도록 방지
                // 인덱스 벗어나지 못하도록 방지
                if (((curr % m == 0) && (curr - 1 == next))
                        || ((curr % m == m - 1) && (curr + 1 == next))
                        || (next < 0) || (next >= map.length)) {
                    continue;
                }
                
                if (map[next] == 0) {
                    map[next] = 2;
                    queue.offer(next);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] map = new int[n * m];        // 2차원 map 데이터를 1차원 형식으로 받기
        ArrayList<Integer> virusLocationList = new ArrayList<>();
        
        for (int i = 0; i < map.length; ++i) {
            map[i] = sc.nextInt();
            
            if (map[i] == 2) {
                virusLocationList.add(i);
            }
        }
        
        sc.close();
        
        int[] temp = new int[map.length];
        
        int answer = 0;
        
        for (int firstWall = 0; firstWall < map.length - 2; ++firstWall) {
            if (map[firstWall] != 0) {
                continue;
            }
            
            map[firstWall] = 1;
            
            for (int secondWall = firstWall + 1; secondWall < map.length - 1; ++secondWall) {
                if (map[secondWall] != 0) {
                    continue;
                }
                
                map[secondWall] = 1;
                
                for (int thirdWall = secondWall + 1; thirdWall < map.length; ++thirdWall) {
                    if (map[thirdWall] != 0) {
                        continue;
                    }
                    
                    map[thirdWall] = 1;
                    temp = Arrays.copyOf(map, map.length);
                    
                    bfs(temp, m, virusLocationList);
                    
                    answer = Math.max(answer, checkSafetyZone(temp));
                    map[thirdWall] = 0;
                }
                
                map[secondWall] = 0;
            }
            
            map[firstWall] = 0;
        }
        
        System.out.print(answer);
    }

}
