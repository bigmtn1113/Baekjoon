import java.util.Scanner;

public class Main {
    public static long dp[][];
    
    public static long recursionFunc(int[] nums, int num, int idx) {
        if ((num < 0) || (num > 20)) {
            return 0;
        }
        
        if (dp[idx][num] != 0) {
            return dp[idx][num];
        }
        
        if (idx == 1) {
            return dp[idx][num] = (num == nums[1]) ? 1 : 0;
        }
        
        return dp[idx][num] = recursionFunc(nums, num + nums[idx], idx - 1)
                + recursionFunc(nums, num - nums[idx], idx - 1);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[] nums = new int[n + 1];
        
        for (int i = 1; i <= n; ++i) {
            nums[i] = sc.nextInt();
        }
        
        sc.close();
        
        dp = new long[n + 1][21];
        
        System.out.print(recursionFunc(nums, nums[n], n - 1));
    }

}
