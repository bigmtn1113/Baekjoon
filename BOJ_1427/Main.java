import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String n = br.readLine();
		br.close();
		
		Integer[] arr = new Integer[n.length()];	// Collections.reverseOrder()를 사용하기 위해 Integer사용
		for (int i = 0; i < n.length(); ++i)
			arr[i] = n.charAt(i) - '0';
		
		Arrays.sort(arr, Collections.reverseOrder());
		for (int i = 0; i < n.length(); ++i)
			bw.write(String.valueOf(arr[i]));
		
		bw.flush();
		bw.close();
	}
}