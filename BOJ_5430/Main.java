import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque<String> deque = new ArrayDeque<>();
		StringBuffer p = new StringBuffer();
		
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; ++i) {
			p.append(br.readLine());
			int n = Integer.parseInt(br.readLine());
			String x = br.readLine();
			
			x = x.substring(1, x.length() - 1);	// 문자열에서 [] 없애기
			String[] strSplit = x.split(",");	// 문자열에서 숫자만 가져오기
			
			for (int j = 0; j < n; ++j)
				deque.offer(strSplit[j]);
			
			boolean isReverse = false;
			boolean isError = false;
			for (int j = 0; j < p.length(); ++j) {
				if (p.charAt(j) == 'R') isReverse = isReverse ? false : true;
				else if (p.charAt(j) == 'D') {
					if (deque.isEmpty()) { isError = true; break; }
					
					if (isReverse) deque.pollLast();
					else deque.poll();
				}
			}
			
			if (isError) bw.write("error\n");
			else {
				bw.write("[");
				while (deque.size() > 1)
					bw.write(isReverse ? deque.pollLast() + "," : deque.poll() + ",");
				bw.write(deque.isEmpty() ? "]\n" : deque.poll() + "]\n");
			}
			
			deque.clear();
			p.setLength(0);
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}