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
		
		
		for (int i = 0; i < (2 * n - 1); ++i) {
			if (i < n) {
				for (int j = 0; j <= i; ++j)
					bw.write("*");
				bw.newLine();
			}
			else {
				for (int j = (2 * n - 1) - i; j > 0; --j)
					bw.write("*");
				bw.newLine();
			}
		}
		
        bw.flush();
        bw.close();
	}

}
