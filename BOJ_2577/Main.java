import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		br.close();
		
		String temp = Integer.toString(a * b * c);
		char[] result = temp.toCharArray();
		int[] arr = new int[10];
		
		for (int i = 0; i < temp.length(); ++i)
			++arr[result[i] - '0'];
		
		for (int i = 0; i < 10; ++i)
			bw.write(arr[i] + "\n");
		
		bw.flush();
		bw.close();
	}
}