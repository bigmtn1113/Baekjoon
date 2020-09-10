import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int k = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		int sum = 0;
		for (int i = 0; i < k; ++i) {
			int num = Integer.parseInt(br.readLine());
			
			if (num != 0) {
				stack.push(num);
				sum += num;
			} else {
				sum -= stack.pop();
			}
		}
		br.close();
		
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
	}
}