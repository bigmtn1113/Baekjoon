import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] vipSeats = new int[m];
        
        for (int i = 0; i < m; ++i) {
            vipSeats[i] = sc.nextInt();
        }
        
        sc.close();
        
        // DP 문제
        // dp[i]: 좌석이 i개 있을 때 앉을 수 있는 경우의 수
        
        // 좌석이 1개 = 1. a
        // 좌석이 2개 = 2. ab/ ba
        // 좌석이 3개 = 3, abc/ bac/ acb
        // 좌석이 4개 = 5. abcd/ bacd/ acbd/ abdc/ badc
        
        // 좌석이 4개인 경우를 보자.
        // ((abc, bac, acb) + d) + ((ab, ba) + d + c)
        // 이 것을 보면 d가 맨 뒤에 앉는 경우(좌석이 3개인 경우)와 d가 한 칸 앞에 앉는 경우(좌석이 2개인 경우)의 합이란 것을 알 수 있다.
        // 즉, dp[i] = dp[i - 1] + dp[1 - 2]인 것이다.
        
        // 고정된 자리는 위와 같은 계산을 할 수 없으므로 제외한다.
        // 9자리에서 4와 7을 제외하고 나머지 자리를 계산하면 dp[3] * dp[2] * dp[2]가 된다.
        
        int[] dp = new int[n + 1];
        
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        int answer = 1;
        int standardSeatBeginIndex = 1;
        
        for (int vipSeat : vipSeats) {
            answer *= dp[vipSeat - standardSeatBeginIndex];
            standardSeatBeginIndex = vipSeat + 1;
        }
        
        answer *= dp[n + 1 - standardSeatBeginIndex];
        
        System.out.print(answer);
    }

}
