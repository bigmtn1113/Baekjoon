import java.util.Scanner;

public class Main {
    public static int answer = 0;
    
    public static void recursionFunc(int n, int numLength, int preValue, String num) {
        if (num.length() == numLength) {
            ++answer;
            
            if (answer == n) {
                System.out.print(Long.parseLong(num));
                System.exit(0);
            }
            
            return;
        }
        
        for (int i = 0; i < 10; ++i) {
            if (i < preValue) {
                recursionFunc(n, numLength, i, num + i);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        sc.close();
        
        if (n == 0) {
            System.out.print(0);
            System.exit(0);
        } else if (n > 1022) {    // n이 1022일 때 9876543210로 최대치가 된다.
            System.out.print(-1);
            System.exit(0);
        }
        
        int numLength = 1;
        
        while (true) {
            for (int i = 1; i < 10; ++i) {
                recursionFunc(n, numLength, i, String.valueOf(i));
            }
            
            ++numLength;
        }
    }

}
