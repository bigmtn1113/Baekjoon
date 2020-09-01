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
		String num = br.readLine();
		br.close();
		
		int sum = 0;
		for (int i = 0; i < num.length(); ++i)
			sum += num.charAt(i) - '0';
		bw.write(String.valueOf(sum));
		
		bw.flush();
		bw.close();
	}
}