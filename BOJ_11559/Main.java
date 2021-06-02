import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Location {
    private int r;
    private int c;
    
    public Location(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }
}

public class Main {
    public static Deque<Location> saveDeque = new ArrayDeque<>();
    private static boolean[][] visited = new boolean[12][6];
    
    public static void dropPuyo(char[][] field) {
        for (int i = 0; i < 6; ++i) {
            for (int j = 11; j > -1; --j) {
                if (field[j][i] != '.') {
                    continue;
                }
                
                for (int k = j - 1; k > -1; --k) {
                    if (field[k][i] != '.') {
                        field[j][i] = field[k][i];
                        field[k][i] = '.';
                        break;
                    }
                }
            }
        }
    }
    
    public static void bfs(char[][] field, char puyoType, int i, int j) {
        Queue<Location> searchQueue = new LinkedList<>();
        searchQueue.offer(new Location(i, j));
        saveDeque.offer(new Location(i, j));

        visited[i][j] = true;
        int puyoCnt = 1;
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!searchQueue.isEmpty()) {
            int currI = searchQueue.peek().getR();
            int currJ = searchQueue.poll().getC();
            
            for (int[] direction : directions) {
                int nextI = currI + direction[0];
                int nextJ = currJ + direction[1];
                
                if ((nextI == -1) || (nextJ == -1) || (nextI == 12) || (nextJ == 6)) {
                    continue;
                }
                
                if (field[nextI][nextJ] == puyoType && !visited[nextI][nextJ]) {
                    visited[nextI][nextJ] = true;
                    searchQueue.offer(new Location(nextI, nextJ));
                    saveDeque.offer(new Location(nextI, nextJ));
                    
                    ++puyoCnt;
                }
            }
        }
        
        // 같은 색의 뿌요들이 4개 이상 모이지 않았으면 탐색하면서 저장했던 뿌요들 제거
        if (puyoCnt < 4) {
            while (puyoCnt-- > 0) {
                saveDeque.pollLast();
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        char[][] field = new char[12][6];
        
        for (int i = 0; i < 12; ++i) {
            field[i] = sc.next().toCharArray();
        }
    
        sc.close();
        
        int answer = 0;
        
        char[] puyoTypes = {'R', 'G', 'B', 'P', 'Y'};
        
        while (true) {
            for (char puyoType : puyoTypes) {
                for (int i = 0; i < 12; ++i) {
                    for (int j = 0; j < 6; ++j) {
                        if ((field[i][j] == puyoType) && !visited[i][j]) {
                            bfs(field, puyoType, i, j);
                        }
                    }
                }
            }
            
            // 같은 색의 뿌요들이 4개 이상 모인 경우가 없으면 종료
            if (saveDeque.isEmpty()) {
                break;
            }
            
            // 터져야 할 뿌요들을 터트리고 터진 자리는 빈칸으로 변경
            while (!saveDeque.isEmpty()) {
                int currI = saveDeque.peek().getR();
                int currJ = saveDeque.poll().getC();
                
                field[currI][currJ] = '.';
                visited[currI][currJ] = false;
              }
            
            ++answer;
            
            // 터지지 않은 뿌요들 중 공중에 떠 있는 뿌요들이 있으면 밑으로 drop
            dropPuyo(field);
            
            for (boolean[] row : visited) {
                Arrays.fill(row, false);
            }
        }
        
        System.out.print(answer);
    }

}
