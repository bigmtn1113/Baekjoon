import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String num = br.readLine();
		br.close();
		
		int[] arr = new int[26];
		Arrays.fill(arr, -1);
		for (int i = 0; i < num.length(); ++i)
			if (arr[(int)(num.charAt(i)) - 97] == -1)
				arr[(int)(num.charAt(i)) - 97] = i;
		
		for (int i = 0; i < 26; ++i)
			bw.write(arr[i] + " ");
		
		bw.flush();
		bw.close();
	}
}