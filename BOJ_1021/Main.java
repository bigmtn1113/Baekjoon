import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque<Integer> deque = new ArrayDeque<>();
		
		// ex) 10 3, 2 9 5
		// 1 2 3 4 5 6 7 8 9 10
		// 3 4 5 6 7 8 9 10 1 - 1, 2 out
		// 1 3 4 5 6 7 8 9 10 - 2
		// 10 1 3 4 5 6 7 8 9 - 3
		// 10 1 3 4 5 6 7 8 - 4, 9 out
		// 8 10 1 3 4 5 6 7 - 5
		// 7 8 10 1 3 4 5 6 - 6
		// 6 7 8 10 1 3 4 5 - 7
		// 6 7 8 10 1 3 4 - 8, 5 out
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= n; ++i)
			deque.offer(i);
		
		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for (int i = 0; i < m; ++i) {
			int num = Integer.parseInt(st.nextToken());
			int numIndex = 0;
			
			for (int j = 0; j < deque.size(); ++j) {	// 찾고자 하는 숫자의 위치를 deque에서 찾기
				int temp = deque.poll();
				deque.offer(temp);
				
				if (temp == num)
					numIndex = j;
			}
			
			if (numIndex <= deque.size() / 2) {	// 찾은 위치가 중앙 기준으로 중앙에 있거나 왼쪽에 있을 경우
				while (deque.peek() != num) {
					deque.offer(deque.poll());
					++cnt;
				}
			} else {	// 찾은 위치가 중앙 기준으로 오른쪽에 있을 경우
				while (deque.peek() != num) {
					deque.offerFirst(deque.pollLast());
					++cnt;
				}
			}
			deque.poll();	// 찾은 숫자 deque에서 빼기
		}
		br.close();
		
		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
	}
}