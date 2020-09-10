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
		
		int t = Integer.parseInt(br.readLine());
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < t; ++i) {
			String ps = br.readLine();
			boolean isVps = true;
			
			for (int j = 0; j < ps.length(); ++j) {
				if (ps.charAt(j) == '(') {
					stack.push('(');
				} else {
					if (stack.isEmpty()) {
						isVps = false;
						break;
					} else {
						stack.pop();
					}
				}
			}
			
			if (!stack.isEmpty() || !isVps) bw.write("NO\n");
			else bw.write("YES\n");
			
			while (true) {
				if (stack.isEmpty()) break;
				
				stack.pop();
			}
		}
		br.close();
		
		bw.flush();
		bw.close();
	}
}