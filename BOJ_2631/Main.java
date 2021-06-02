import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[] row = new int[n];
        
        for (int i = 0; i < n; ++i) {
            row[i] = sc.nextInt();
        }
        
        sc.close();
        
        // 줄에서 LIS를 찾으면 LIS의 순서는 바꿀 필요가 없다.
        // LIS를 제외한 나머지의 아이들만 순서를 바꾸면 된다.
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        int lisLength = 0;
        
        for (int i = 1; i < n; ++i) {
            for (int j = i - 1; j > -1; --j) {
                if ((row[j] < row[i]) && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    lisLength = Math.max(lisLength, dp[i]);
                }
            }
        }
        
        System.out.print(n - lisLength);
    }

}
