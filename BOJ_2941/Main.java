import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String word = br.readLine();
		br.close();
		
		String[] croatia = {"dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z="}; 
		String alphabet = "";
		int cnt = 0;
		
		for (int i = 0; i < word.length(); ++i) {
			alphabet += word.charAt(i);
			
			if (alphabet.length() >= 2) {
				for (int j = 0; j < croatia.length; ++j) {
					if (alphabet.equals(croatia[j])) {	// croatia 목록에 있는 경우
						++cnt;
						alphabet = "";
						break;
					}
				}
				
				if (alphabet.length() == 3) {	// croatia 목록에 없는 경우
					++cnt;
					alphabet = "";
					i -= 2;
				}
			}
		}
		
		if (alphabet.length() == 1) ++cnt;
		else if (alphabet.length() == 2) cnt += 2;
		
		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
	}
}