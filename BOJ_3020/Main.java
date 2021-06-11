import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    public static int binarySearch(int[] obstacles, int height, int begin, int end) {
        int result = Integer.MAX_VALUE;
        
        while (begin <= end) {
            int mid = (begin + end) / 2;
            
            if (obstacles[mid] >= height) {
                result = Math.min(result, mid);
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        
        return (result != Integer.MAX_VALUE) ? result : obstacles.length;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int h = sc.nextInt();
        
        int[] stalagmite = new int[n / 2];    // 석순
        int[] stalactite = new int[n / 2];    // 종유석
        
        for (int i = 0; i < n / 2; ++i) {
            stalagmite[i] = sc.nextInt();
            stalactite[i] = sc.nextInt();
        }
        
        sc.close();
        
        // 개똥벌레가 어느 높이에서 장애물을 최소로 파괴할 것인가를 구할 것이므로 개똥벌레를 1 ~ h 높이로 날려보자.
        // 석순과 종유석을 따로 분리해서 계산(파괴할 석순 + 파괴할 종유석)할 것이다.
        // 석순은 개똥벌레 높이를 1 ~ h 순으로 설정하지만, 종유석은 거꾸로 되어 있으니 h ~ 1 순으로 설정한다.
        // 높이를 설정하고 이분 탐색을 진행한다.
        // 이분 탐색이 리턴하는 값은 파괴할 수 있는 장애물의 최소 인덱스이고, 이것보다 인덱스가 크거나 같은 장애물들은 다 파괴할 수 있다는 뜻이다.
        // 이때, 파괴할 장애물 개수를 구하기 위해 n / 2(석순, 종유석의 개수)에서 리턴 값을 빼주는 것이다.
        
        Arrays.sort(stalagmite);
        Arrays.sort(stalactite);
        
        int minObstacleCnt = Integer.MAX_VALUE;
        int cnt = 0;
        
        for (int i = 1; i <= h; ++i) {
            int stalagmiteCnt = n / 2 - binarySearch(stalagmite, i, 0, n / 2 - 1);
            int stalactiteCnt = n / 2 - binarySearch(stalactite, h - i + 1, 0, n / 2 - 1);
            
            int obstacleCnt = stalagmiteCnt + stalactiteCnt;
            
            if (obstacleCnt < minObstacleCnt) {
                minObstacleCnt = obstacleCnt;
                cnt = 1;
            } else if (obstacleCnt == minObstacleCnt) {
                ++cnt;
            }
        }
        
        System.out.format("%d %d", minObstacleCnt, cnt);
    }

}
