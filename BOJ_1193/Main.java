import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int x = Integer.parseInt(br.readLine());
		br.close();
		
		// i = 1, j = 1 
		// i = 1, j = 2 -> i = 2, j = 1
		// i = 3, j = 1 -> i = 2, j = 2 -> i = 1, j = 3
		// i = 1, j = 4 -> i = 2, j = 3 -> i = 3, j = 2 -> i = 4, j = 1
		
		boolean iInc = false, isFind = false;
		int i = 1, j = 1, cnt = 1, num = 1;
		
		while (true) {
			if (iInc) {	// i�� �����ϴ� �����̸�
				for (j = num; j > 0 ; ++i, --j) {	// i����, j����
					if (cnt == x) {
						bw.write(i + "/" + j);
						isFind = true;
						break;
					}
					
					++cnt;
				}
				
				j = 1;
				++num;
				iInc = false;
			}
			else {	// i�� �����ϴ� �����̸�
				for (i = num; i > 0; --i, ++j) {	// i����, j����
					if (cnt == x) {
						bw.write(i + "/" + j);
						isFind = true;
						break;
					}
					
					++cnt;
				}
				
				i = 1;
				++num;
				iInc = true;
			}
			
			if (isFind) break;
		}
		
		bw.flush();
		bw.close();
	}
}