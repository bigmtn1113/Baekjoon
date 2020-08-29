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
		
		for (int i = 0; i < n * 2; ++i) {
			if (i % 2 == 0) {
				for (int j = 0; j < n; ++j) {
					if (j % 2 == 0)
						bw.write("*");
					else
						bw.write(" ");
				}
				bw.newLine();
			}
			else {
				for (int j = 0; j < n; ++j) {
					if (j % 2 == 0)
						bw.write(" ");
					else
						bw.write("*");
				}
				bw.newLine();
			}
		}
		
        bw.flush();
        bw.close();
	}

}
