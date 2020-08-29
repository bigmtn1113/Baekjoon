import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		int newNum = n;
        
		while (true) {
			int left = newNum / 10;
			int right = newNum % 10;
			int sum = left + right;
			newNum = right * 10 + sum % 10;
			++cnt;
			
			if (n == newNum) break;
		}
		
		bw.write(String.valueOf(cnt));
		
        bw.flush();
        bw.close();
	}

}
