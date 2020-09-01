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
		
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			
			for (int j = 0; j < str.length(); ++j)
				for (int k = 0; k < r; ++k)
					bw.write(str.charAt(j));
			
			bw.newLine();
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}