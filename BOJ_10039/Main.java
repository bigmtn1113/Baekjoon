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
		int sum = 0;
		
		for (int i = 0; i < 5; ++i) {
			int n = Integer.parseInt(br.readLine());
			
			if (n < 40) n = 40;
			sum += n;
		}
		
		bw.write(String.valueOf(sum / 5));
		
        bw.flush();
        bw.close();
	}

}
