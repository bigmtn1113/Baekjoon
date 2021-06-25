import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
    private long num;
    private String operations;
    
    public Pair(long num, String operations) {
        this.num = num;
        this.operations = operations;
    }

    public long getNum() {
        return num;
    }

    public String getOperations() {
        return operations;
    }
}

public class Main {
    
    public static String bfs(int s, int t) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(s, ""));
        
        HashSet<Long> hashSet = new HashSet<>();
        hashSet.add((long) s);
        
        long[] nextNums = new long[4];
        char[] directions = {'*', '+', '-', '/'};
        
        while (!queue.isEmpty()) {
            long currNum = queue.peek().getNum();
            String currOps = queue.poll().getOperations();
            
            if (currNum == t) {
                return currOps;
            }
            
            nextNums[0] = currNum * currNum;
            nextNums[1] = currNum + currNum;
            nextNums[2] = currNum - currNum;
            nextNums[3] = currNum / currNum;
            
            for (int i = 0; i < 4; ++i) {
                if ((nextNums[i] < 1) || (nextNums[i] > t)) {
                    continue;
                }
                
                if (!hashSet.contains(nextNums[i])) {
                    queue.offer(new Pair(nextNums[i],currOps + directions[i]));
                    hashSet.add(nextNums[i]);
                }
            }
        }
        
        return "-1";
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int s = sc.nextInt();
        int t = sc.nextInt();
        
        sc.close();
        
        if (s == t) {
            System.out.print(0);
            System.exit(0);
        }
        
        System.out.print(bfs(s, t));
    }

}
