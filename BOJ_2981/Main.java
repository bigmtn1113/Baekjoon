import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static TreeSet<Integer> treeSet = new TreeSet<>();
    
    public static void findDivisors(int gcd) {
        for (int i = 2; i * i <= gcd; ++i) {
            if (gcd % i == 0) {
                treeSet.add(i);
                treeSet.add(gcd / i);
            }
        }
        
        treeSet.add(gcd);
    }
    
    public static int calcGcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        
        return num1;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[] nums = new int[n];
        
        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }
        
        sc.close();
        
        // a1 / m + r
        // a2 / m + r
        // a3 / m + r
        // 위의 세 개의 식에서 r은 다 같다.
        // 우선 두 개씩 비교하면서 r을 없애면 (a1 - a2) / m과 (a2 - a3) / m이 된다.
        // (a1 - a2) / m, (a2 - a3) / m에서 m이 같다는 소리는 (a1 - a2)와 (a2 - a3)의 공약수가 m이란 것이다.
        // 이때 음수가 발생하지 않게 큰 수에서 작은수를 빼주고 공약수를 구해야 하므로 정렬을 사용한다.
        
        Arrays.sort(nums);
        
        int gcd = nums[1] - nums[0];
        
        for (int i = 2; i < n; ++i) {
            gcd = calcGcd(gcd, nums[i] - nums[i - 1]);
        }
        
        findDivisors(gcd);

        StringBuffer answer = new StringBuffer();
        
        for (int element : treeSet) {
            answer.append(element).append(" ");
        }
        
        System.out.print(answer);
    }

}
