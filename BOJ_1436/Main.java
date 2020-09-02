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
		for (int i = 666; ; ++i) {
			String num = Integer.toString(i);
			
			for (int j = 0; j < num.length() - 2; ++j) {
				if (num.charAt(j) == '6' && num.charAt(j + 1) == '6' && num.charAt(j + 2) == '6') {
					++cnt;
					break;
				}
			}
			
			if (cnt == n) {
				bw.write(num);
				break;
			}
		}
		
		bw.flush();
		bw.close();
	}
}