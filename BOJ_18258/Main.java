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
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			
			String command = st.nextToken();
			
			if (command.equals("push")) deque.offer(Integer.parseInt(st.nextToken()));
			else if (command.equals("pop")) bw.write(deque.isEmpty() ? "-1\n" : deque.poll() + "\n");
			else if (command.equals("size")) bw.write(deque.size() + "\n");
			else if (command.equals("empty")) bw.write(deque.isEmpty() ? "1\n" : "0\n");
			else if (command.equals("front")) bw.write(deque.isEmpty() ? "-1\n" : deque.peek() + "\n");
			else if (command.equals("back")) bw.write(deque.isEmpty() ? "-1\n" : deque.peekLast() + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}