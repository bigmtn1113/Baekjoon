import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static boolean[][] visited;
    
    public static int bfs(int[][] board) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        queue.offer(0);
        
        int height = board.length;
        int width = board[0].length;
        
        int meltedCheeseCnt = 0;
        
        while (!queue.isEmpty()) {
            int currI = queue.poll();
            int currJ = queue.poll();
            
            for (int[] direction : directions) {
                int nextI = currI + direction[0];
                int nextJ = currJ + direction[1];
                
                if ((nextI == -1) || (nextJ == -1) || (nextI == height) || (nextJ == width)) {
                    continue;
                }
                
                if (!visited[nextI][nextJ] && (board[nextI][nextJ] == 0)) {
                    visited[nextI][nextJ] = true;
                    
                    queue.offer(nextI);
                    queue.offer(nextJ);
                    continue;
                }
                
                if (board[nextI][nextJ] == 1) {
                    visited[nextI][nextJ] = true;
                    board[nextI][nextJ] = 0;
                    
                    ++meltedCheeseCnt;
                }
            }
        }
        
        return meltedCheeseCnt;
    }
    
    public static boolean existCheese(int[][] board) {
        int height = board.length;
        int width = board[0].length;
        
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if(board[i][j] == 1) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int height = sc.nextInt();
        int width = sc.nextInt();
        
        int[][] board = new int[height][width];
        
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                board[i][j] = sc.nextInt();
            }
        }
        
        sc.close();
        
        // 열려있는 공간과 닫혀있는 공간을 구분하기 위해 bfs를 사용했다.
        // 열러있는 공간은 서로 연결 되어 있으므로 bfs로 탐색했을 시, 방문하지 못한 부분이 닫혀있는 공간이 된다.
        // 판의 가장자리는 항상 열려있는 공간이니 가장자리(예를 들면 (0, 0))에서 탐색을 시작하면 된다.
        // 탐색하면서 열려있는 공간와 근접해 있는 치즈 부분을 녹이는 작업을 진행하였다.
        
        visited = new boolean[height][width];
        
        int time = 0;
        int pieceOfCheese = 0;
        
        while (true) {
            if (!existCheese(board)) {
                System.out.format("%d\n%d", time, pieceOfCheese);
                break;
            }
            
            ++time;
            
            for (boolean[] row : visited) {
                Arrays.fill(row, false);
            }
            
            pieceOfCheese = bfs(board);
        }
    }

}
