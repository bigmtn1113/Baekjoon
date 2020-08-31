import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		br.close();
		
		int cnt = 0;
		
		for (int i = 1; i <= n; ++i) {
			if (i < 100)
				++cnt;
			else {			
				String num = Integer.toString(i);
				
				if (num.charAt(0) - num.charAt(1) == num.charAt(1) - num.charAt(2))
					++cnt;
			}
		}
		
		bw.write(String.valueOf(cnt));
		
		bw.flush();
		bw.close();
	}
}