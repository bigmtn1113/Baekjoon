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
		
		boolean isFind = false;
		
		for (int i = 1; i <= n; ++i) {
			String num = Integer.toString(i);
			int sum = i;
			
			for (int j = 0; j < num.length(); ++j)
				sum += num.charAt(j) - '0';
			
			if (sum == n) {
				bw.write(String.valueOf(i));
				isFind = true;
				break;
			}
		}
		
		if (!isFind) bw.write("0");
		bw.flush();
		bw.close();
	}
}