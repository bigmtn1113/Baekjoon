import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			
			String command = st.nextToken();
			
			if (command.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
			} else if (command.equals("pop")) {
				if (stack.isEmpty()) bw.write("-1\n");
				else bw.write(stack.pop() + "\n");
			} else if (command.equals("size")) {
				bw.write(stack.size() + "\n");
			} else if (command.equals("empty")) {
				if (stack.isEmpty()) bw.write("1\n");
				else bw.write("0\n");
			} else if (command.equals("top")) {
				if (stack.isEmpty()) bw.write("-1\n");
				else bw.write(stack.peek() + "\n");
			}
		}
		br.close();
		
		bw.flush();
		bw.close();
	}
}