import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] arr = new int[42];
		int cnt = 0;
		
		for (int i = 0; i < 10; ++i) {
			int num = Integer.parseInt(br.readLine());			
			++arr[num % 42];
		}
		br.close();
		
		for (int i = 0; i < 42; ++i)
			if (arr[i] != 0)
				++cnt;
		
		bw.write(String.valueOf(cnt));
		
		bw.flush();
		bw.close();
	}
}