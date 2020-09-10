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
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		// ex) stack
		// 1(+) 2(+) 3(+) 4(+) -> 4(-)
		// 1 2 3 -> 3(-)
		// 1 2 5(+) 6(+) -> 6(-)
		// 1 2 5 7(+) 8(+) -> 8(-)
		// 1 2 5 7 -> 7(-)
		// 1 2 5 -> 5(-)
		// 1 2 -> 2(-)
		// 1 -> 1(-)
		int cnt = 0;
		StringBuffer result = new StringBuffer();	// String과 달리 객체를 한 번만 생성. 문자열 변경 작업이 많을 경우 사용
		for (int i = 0; i < n; ++i) {
			int num = Integer.parseInt(br.readLine());
			
			for (int j = cnt; j < num; ++j) {
				stack.push(++cnt);
				result.append('+');
			}
			
			if (stack.pop() != num) {
				result.setLength(0);	// result 초기화
				break;
			};
			result.append('-');
		}
		br.close();
		
		if (result.length() == 0)
			bw.write("NO");
		else
			for (int i = 0; i < result.length(); ++i)
				bw.write(result.charAt(i) + "\n");
		
		bw.flush();
		bw.close();
	}
}