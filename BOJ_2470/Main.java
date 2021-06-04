import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        // Scanner로 통과 안 되네...
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] solutions = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; ++i) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }
        
        br.close();
        
        Arrays.sort(solutions);
        
        int[] answer = new int[2];
        
        int begin = 0;
        int end = n - 1;
        int minCharacteristicValue = Integer.MAX_VALUE;
        
        while (begin < end) {
            int sum = solutions[begin] + solutions[end];
            
            if (Math.abs(sum) < minCharacteristicValue) {
                minCharacteristicValue = Math.abs(sum);
                answer[0] = solutions[begin];
                answer[1] = solutions[end];
            }
            
            if (sum < 0) {
                ++begin;
            } else {
                --end;
            }
        }
        
        System.out.format("%d %d", answer[0], answer[1]);
    }

}
