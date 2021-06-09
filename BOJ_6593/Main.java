import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Location {
    private int l;
    private int r;
    private int c;
    
    public Location(int l, int r, int c) {
        this.l = l;
        this.r = r;
        this.c = c;
    }

    public int getL() {
        return l;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }
}

public class Main {
    public static int[][][] time = new int[31][31][31];
    
    public static int bfs(char[][][] building, int startL, int startR, int startC) {
        Queue<Location> queue = new LinkedList<>();
        queue.offer(new Location(startL, startR, startC));
        
        time[startL][startR][startC] = 0;
        
        // 동, 서, 남, 북, 상, 하
        int[][] directions = {{0, 0, 1}, {0, 0, -1},
                {0, 1, 0}, {0, -1, 0},
                {-1, 0, 0}, {1, 0, 0}};
        
        while (!queue.isEmpty()) {
            int currL = queue.peek().getL();
            int currR = queue.peek().getR();
            int currC = queue.poll().getC();
            
            for (int[] direction : directions) {
                int nextL = currL + direction[0];
                int nextR = currR + direction[1];
                int nextC = currC + direction[2];
                
                if ((nextL < 0) || (nextR < 0) || (nextC < 0)
                        || (nextL == building.length)
                        || (nextR == building[0].length)
                        || (nextC == building[0][0].length)) {
                    continue;
                }
                
                if (building[nextL][nextR][nextC] == 'E') {
                    return time[currL][currR][currC] + 1;
                }
                
                if ((building[nextL][nextR][nextC] == '.') && time[nextL][nextR][nextC] == -1) {
                    time[nextL][nextR][nextC] = time[currL][currR][currC] + 1;
                    queue.offer(new Location(nextL, nextR, nextC));
                }
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        StringBuffer answer = new StringBuffer();
        
        while (true) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            if ((l == 0) && (r == 0) && (c == 0)) {
                break;
            }
            
            char[][][] building = new char[l][r][c];
            
            for (int i = 0; i < l; ++i) {
                for (int j = 0; j < r; ++j) {
                    building[i][j] = sc.next().toCharArray();
                }
            }
            
            for (int[][] layer : time) {
                for (int[] row : layer) {
                    Arrays.fill(row, -1);
                }
            }
            
            label: for (int i = 0; i < l; ++i) {
                for (int j = 0; j < r; ++j) {
                    for (int k = 0; k < c; ++k) {
                        if (building[i][j][k] == 'S') {
                            int result = bfs(building, i, j, k);
                            
                            if (result != -1) {
                                answer.append("Escaped in ").append(result).append(" minute(s).\n");
                            } else {
                                answer.append("Trapped!\n");
                            }
                            
                            break label;
                        }
                    }
                }
            }
        }
        
        sc.close();
        
        System.out.print(answer);
    }

}
