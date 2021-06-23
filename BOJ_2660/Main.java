import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[][] distance = new int[n + 1][n + 1];
        
        for (int[] row : distance) {
            Arrays.fill(row, 123456789);
        }
        
        while (true) {
            int member1 = sc.nextInt();
            int member2 = sc.nextInt();
            
            if ((member1 == -1) && (member2 == -1)) {
                break;
            }
            
            distance[member1][member2] = 1;
            distance[member2][member1] = 1;
        }
        
        sc.close();
        
        // 플로이드-워셜 알고리즘
        
        for (int i = 1; i <= n; ++i) {
            distance[i][i] = 0;
            
            for (int from = 1; from <= n; ++from) {
                for (int to = 1; to <= n; ++to) {
                    distance[from][to] = Math.min(distance[from][to], distance[from][i] + distance[i][to]);
                }
            }
        }
        
        int[] membersScore = new int[n + 1];
        
        int clubPresidentScore = 123456789;
        
        for (int from = 1; from <= n; ++from) {
            int memberMaxScore = 0;
            
            for (int to = 1; to <= n; ++to) {
                memberMaxScore = Math.max(memberMaxScore, distance[from][to]);
            }
            
            membersScore[from] = memberMaxScore;
            clubPresidentScore = Math.min(clubPresidentScore, memberMaxScore);
        }
        
        StringBuffer answer = new StringBuffer("");
        
        int cnt = 0;
        
        for (int i = 1; i <= n; ++i) {
            if (membersScore[i] == clubPresidentScore) {
                ++cnt;
                answer.append(i).append(" ");
            }
        }
        
        System.out.format("%d %d\n", clubPresidentScore, cnt);
        System.out.print(answer);
    }

}
