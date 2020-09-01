import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String alphabet = br.readLine().toLowerCase();
		br.close();
		
		int[] arr = new int[26];
		for (int i = 0; i < alphabet.length(); ++i)
			++arr[(int)(alphabet.charAt(i)) - 97];
		
		int maxCntAlphabet = 0;
		char maxAlphabet = ' ';
		for (int i = 0; i < 26; ++i) {
			if (arr[i] == maxCntAlphabet)
				maxAlphabet = '?';
			else if (arr[i] > maxCntAlphabet) {
				maxCntAlphabet = arr[i];
				maxAlphabet = (char)(i + 65);
			}
		}
		
		bw.write(maxAlphabet);
		bw.flush();
		bw.close();
	}
}