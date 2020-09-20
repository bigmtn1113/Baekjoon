import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < n; ++i) {
			int num = Integer.parseInt(br.readLine());
			
			if (num == 0) bw.write(pq.isEmpty() ? "0\n" : pq.poll() + "\n");
			else pq.offer(num);
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
}
