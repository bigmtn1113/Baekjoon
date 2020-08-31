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
		
		for (int i = 0; i < n; ++i) {
			String quizResult = br.readLine();
			char[] arr = quizResult.toCharArray();
			int cnt = 0;
			
			for (int j = 0; j < quizResult.length(); ++j) {
				if (arr[j] == 'O') {
					for (int k = j; k >= 0; --k) {
						if (arr[k] == 'O')
							++cnt;
						else
							break;
					}
				}
			}
			
			bw.write(cnt + "\n");
		}
		br.close();
		
		bw.flush();
		bw.close();
	}
}