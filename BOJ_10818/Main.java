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
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();
		
		int minNum = 1000001;
		int maxNum = -1000001;
		
		for (int i = 0; i < n; ++i) {
			int num = Integer.parseInt(st.nextToken());
			
			if (minNum > num) minNum = num;
			if (maxNum < num) maxNum = num;
		}
		
		bw.write(minNum + " " + maxNum);
		bw.flush();
		bw.close();
	}
}