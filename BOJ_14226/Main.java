import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    // dp[i][j]: 이모티콘 개수가 i이고 클립보드 이모티콘 개수가 j일 때의 최소 시간
    public static int[][] dp = new int[1001][1001];
    
    public static int bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(0);
        
        while (!queue.isEmpty()) {
            int emoticonCnt = queue.poll();
            int clipboard = queue.poll();
            
            if (emoticonCnt == s) {
                return dp[emoticonCnt][clipboard];
            }
            
            if ((0 < emoticonCnt) && (emoticonCnt < 1001)) {
                if (dp[emoticonCnt][emoticonCnt] == 0) {
                    dp[emoticonCnt][emoticonCnt] = dp[emoticonCnt][clipboard] + 1;
                    queue.offer(emoticonCnt);
                    queue.offer(emoticonCnt);
                }
                
                if (dp[emoticonCnt - 1][clipboard] == 0) {
                    dp[emoticonCnt - 1][clipboard] = dp[emoticonCnt][clipboard] + 1;
                    queue.offer(emoticonCnt - 1);
                    queue.offer(clipboard);
                }
            }
            
            if ((clipboard > 0) && (emoticonCnt + clipboard < dp.length)
                    && (dp[emoticonCnt + clipboard][clipboard] == 0)) {
                dp[emoticonCnt + clipboard][clipboard] = dp[emoticonCnt][clipboard] + 1;
                queue.offer(emoticonCnt + clipboard);
                queue.offer(clipboard);
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int s = sc.nextInt();
        
        sc.close();
        
        System.out.print(bfs(s));
    }

}
