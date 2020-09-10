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
		
		while (true) {
			Stack<Character> stack = new Stack<>();
			String str = br.readLine();
			if (str.equals(".")) break;
			
			boolean isBalance = true;
			for (int j = 0; j < str.length(); ++j) {
				char c = str.charAt(j);
				
				if (c == '(' || c == '[') {
					stack.push(c);
				} else if (c == ')') {
					if (stack.isEmpty() || stack.peek() != '(') {
						isBalance = false;
						break;
					}
					
					stack.pop();
				} else if (c == ']') {
					if (stack.isEmpty() || stack.peek() != '[') {
						isBalance = false;
						break;
					}
					
					stack.pop();
				}
			}
			
			if (!stack.isEmpty() || !isBalance) bw.write("no\n");
			else bw.write("yes\n");
		}
		br.close();
		
		bw.flush();
		bw.close();
	}
}