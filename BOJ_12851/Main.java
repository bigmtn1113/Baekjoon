import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int[] dp;
    public static int[] routeCnt;
    
    public static void bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        
        int[] nextN = new int[3];
        
        while (!queue.isEmpty()) {
            int currN = queue.poll();
            
            nextN[0] = currN * 2;
            nextN[1] = currN + 1;
            nextN[2] = currN - 1;
            
            for (int i = 0; i < 3; ++i) {
                if ((nextN[i] < 0) || (nextN[i] >= dp.length)) {
                    continue;
                }
                
                if (nextN[i] == n) {
                    continue;
                }
                
                if ((dp[nextN[i]] == 0) || (dp[nextN[i]] == dp[currN] + 1)) {
                    ++routeCnt[nextN[i]];
                    dp[nextN[i]] = dp[currN] + 1;
                    queue.offer(nextN[i]);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        sc.close();
        
        dp = new int[Math.max(n, k) + 2];
        routeCnt = new int[dp.length];
        
        bfs(n, k);
        
        System.out.format("%d\n%d", dp[k], (n != k) ? routeCnt[k] : 1);
    }

}
