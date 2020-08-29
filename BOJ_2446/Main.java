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
			int j;
			if (i < n) {
				for (j = 0; j < i; ++j)
					bw.write(" ");
				for (int k = j * 2; k < (2 * n - 1); ++k)
					bw.write("*");
				bw.newLine();
			}
			else {
				for (j = 0; j < (2 * n - 1) - i - 1; ++j)
					bw.write(" ");
				for (int k = 0; k < (2 * n - 1) - (j * 2); ++k)
					bw.write("*");
				bw.newLine();
			}
		}
		
        bw.flush();
        bw.close();
	}

}
