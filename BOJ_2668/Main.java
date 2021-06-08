import java.util.Scanner;

public class Main {
    public static boolean[] visited = new boolean[101];
    
    public static boolean dfs(int[] table, int startNum, int currNum) {
        // 탐색을 시작한 곳으로 다시 돌아왔으므로 true를 리턴.
        if (visited[startNum]) {
            return true;
        }
        
        boolean canReturn = false;
        
        if (!visited[table[currNum]]) {
            visited[table[currNum]] = true;
            
            canReturn = dfs(table, startNum, table[currNum]) ? true : false;
            
            // 탐색을 진행해보고 정답이 될 수 없는 경우는 다시 방문 처리를 false로 바꿔야 한다.
            if (!canReturn) {
                visited[table[currNum]] = false;
            }
        }
        
        return canReturn;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[] table = new int[n + 1];
        
        for (int i = 1; i <= n; ++i) {
            table[i] = sc.nextInt();
        }
        
        sc.close();
        
        // dfs 탐색을 1부터 n까지 진행한다.
        // 만약 1부터 탐색했다면 다시 1로 돌아와야 정답이 된다.
        // 예시처럼 4를 탐색한다면 5로 갈 것이고 4로 돌아오지 못한 채로 탐색이 종료되므로 정답이 될 수 없다.
        // 1 -> 3 -> 1, 5 -> 5는 다 처음으로 돌아오는 경우이므로 정답이 된다.
        
        for (int i = 1; i <= n; ++i) {
            if (!visited[i]) {
                dfs(table, i, i);
            }
        }
        
        StringBuffer answer = new StringBuffer();
        
        int cnt = 0;
        
        for (int i = 1; i <= n; ++i) {
            if (visited[i]) {
                ++cnt;
                answer.append(i).append("\n");
            }
        }
        
        System.out.println(cnt);
        System.out.print(answer);
    }

}
