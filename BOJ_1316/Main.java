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
		int cnt = 0;
		
		for (int i = 0; i < n; ++i) {
			String word = br.readLine();
			boolean isGroupWord = true;
			
			for (int j = 0; j < word.length() - 1; ++j) {
				if (word.charAt(j) != word.charAt(j + 1))
					for (int k = j + 1; k < word.length(); ++k)
						if (word.charAt(j) == word.charAt(k)) {
							// ���� ���ĺ��� ���� ���ĺ��� �ٸ��� ���Ŀ� ���� ���ĺ��� ������ ���ĺ��� ���� ���
							// ex) happh -> h�� a�� �ٸ��� h�� ������ false
							isGroupWord = false;
							break;
						}
				if (!isGroupWord) break;
			}
			
			if (isGroupWord) ++cnt;
		}
		
		br.close();
		
		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
	}
}