import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        char[] s1 = sc.next().toCharArray();
        char[] s2 = sc.next().toCharArray();
        
        sc.close();
        
        // 공통 부분 문자열
        // LCS(최장 공통 부분 수열)과의 차이점은 연속성 여부이다.
        // LCS는 비교 문자가 다를 경우에도 계산을 해주었지만 이 문제는 그럴 필요가 없다.
        
        int[][] dp = new int[4001][4001];
        
        int answer = 0;
        
        for (int i = 1; i <= s1.length; ++i) {
            for (int j = 1; j <= s2.length; ++j) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }
        
        System.out.print(answer);
    }

}
