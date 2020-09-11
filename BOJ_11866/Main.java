import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> queue = new LinkedList<>();
		
		// ex) 1 2 3 4 5 6 7
		// 3 4 5 6 7 1 2 -> 3
		// 6 7 1 2 4 5 -> 6
		// 2 4 5 7 1 -> 2
		// 7 1 4 5 -> 7
		// 5 1 4 -> 5
		// 1 4 -> 1
		// 4 -> 4
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		br.close();
		
		for (int i = 1; i <= n; ++i)
			queue.offer(i);
		
		bw.write("<");
		int cnt = 0;
		while (queue.size() > 1) {
			++cnt;
			if (cnt == k) {
				cnt = 0;
				bw.write(queue.poll() + ", ");
			} else {
				queue.offer(queue.poll());
			}
		}
		
		bw.write(queue.poll() + ">");
		bw.flush();
		bw.close();
	}
}